package gamePackage.sonidos;

import java.net.URL; //Para directorios; ej. "fx/sonido1.wav"
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.*; //Librerias que permiten utilizar audio (limitado a .wav y otros primitivos)

import java.io.File; //Fichero
import java.io.IOException;

//Gestor de sonido
//Todo sonido es un hilo.
//TODO: Instrucciones de STOP/PLAY, pulido de duracion/funcionamiento

/* Idea para gestion de directorios: ya que son dos musicas distintas por cada turno,
 * se puede hacer que cada turno cambie el audio.
 * 
 * int rndA //Uno por cada equipo
 * 
 * if rndA == 2
 * rndA--
 * if rndA == 1
 * rndA++
 * 
 * y asi
 */

//Credits to the Java Sound API crew and some StackOverflow peoples that have carried me through this pain.
public class SoundMngr implements Runnable {

	private static Logger logSounds = Logger.getLogger("SoundStatus");
	Object currentSound;
	Object name;
	int rule;
	int gain;
	long duration;
	Mixer mixer;
	Clip clip;
	File file;
	Thread thread;
	AudioInputStream audioStream;
	DataLine.Info dataInfo;
	// SourceDataLine line;
	// AudioFormat audioFormat;
	private volatile boolean kill = false;
	private volatile boolean live = false;

	public SoundMngr(Object name, int rule, int volume) {
		this.name = name;
		this.rule = rule;
		this.gain = volume;
	}

	public void loadSound(Object name) {
		if (name != null) {
			logSounds.log(Level.INFO,"New audiofile received: " + name);
			URL url = SoundMngr.class.getResource("/gamePackage/sonidos/fx/" + (String) name);
			if (url != null) {
				try {
					logSounds.log(Level.INFO,"Audiofile exists, attempting to play");
					audioStream = AudioSystem.getAudioInputStream(url);
					dataInfo = new DataLine.Info(Clip.class, audioStream.getFormat());
					clip = (Clip) AudioSystem.getLine(dataInfo);
					duration = audioStream.getFrameLength();
					clip.open(audioStream);
					logSounds.log(Level.INFO,"Audio initialized");
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logSounds.log(Level.WARNING,"Audiofile is unsupported, try another",e);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logSounds.log(Level.SEVERE,"Unable to obtain file",e);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					logSounds.log(Level.WARNING,"Line is unavailable. Try again when the sound finishes.",e);
					e.printStackTrace();
				}
			} else {}
				
		}
	}

	public void setVolume(int volume) {
		this.gain = volume; // VOLUME UNDER 100 IS MESSY CRACKLE, DO NOT CHANGE
		if (this.gain < 0) {
			this.gain = 100;
		} else if (this.gain > 100) {
			this.gain = 100;
		} else
			this.gain = 100;
		double value = this.gain / 100;
		try {
			FloatControl gainC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float db = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0); // Java Sound API
			gainC.setValue(db);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void play() throws InterruptedException, IOException {
		clip.setFramePosition(0);
		live = true;
		clip.start();
		do {
			Thread.sleep(50);
		} while (kill == false);
		clip.stop();
		clip.close();
		audioStream.close();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public void stop() throws IOException {
		if (clip != null) {
			logSounds.log(Level.INFO,"Audio Stopped");
			clip.stop();
			clip.close();
			audioStream.close();
		}
		kill = true;
	}

	public void playLoop() throws InterruptedException, IOException {
		logSounds.log(Level.INFO,"Audio will play on loop");
		live = true;
		clip.setFramePosition(0);
		this.loop();
		clip.start();
		do {
			Thread.sleep(50);
		} while (kill == false);
		clip.stop();
		clip.close();
		audioStream.close();
	}

	public boolean isActive() {
		return clip.isActive();
	}

	public Thread getThread() {
		return thread;
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stopIt() {
		if (thread != null) {
			thread.interrupt();
		}
		thread = null;
	}

	public void changeSound(String newSound) {
		logSounds.log(Level.INFO,"Audiofile changed to " + newSound);
		this.name = newSound;
	}
	
	public void primer() {
		kill = false;
		live = false;
		logSounds.log(Level.INFO,"Soundmanager ready to play new sound");
	}

	@Override
	public void run() {
		while (!kill) {
			logSounds.log(Level.INFO,"Audio running");
			if (live == false) {
				this.loadSound(name);
				if (rule == 0) {
					try {
						this.play();
						this.stop();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logSounds.log(Level.WARNING,"Audio thread has been interrupted",e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						logSounds.log(Level.SEVERE,"Audiofile not found",e);
						e.printStackTrace();
					}

				} else {
					try {
						this.playLoop();
					} catch (InterruptedException | IOException e) {
						// TODO Auto-generated catch block
						logSounds.log(Level.SEVERE,"An error has ocurred",e);
						e.printStackTrace();
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		SoundMngr sounds = new SoundMngr("combat1.wav", 0, 0);
		Thread x = new Thread(sounds);
		x.start();
		try {
			sounds.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sounds.changeSound("combat2.wav");
		sounds.primer();
		sounds.run();

	}
}
