package gamePackage.sonidos;

import java.net.MalformedURLException;
import java.net.URL; //Para directorios; ej. "fx/sonido1.wav"
import javax.sound.sampled.*; //Librerias que permiten utilizar audio (limitado a .wav y otros primitivos)

import com.sun.tools.javac.Main; //Util para obtener directorio

import java.io.File; //Fichero
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

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

//Credits to the Java Sound API crew and 
public class SoundMngr {
	Object currentSound;
	String currentName;
	int gain = 100;
	long duration;
	Mixer mixer;
	Clip clip;
	File file;
	Logger log;

	public SoundMngr(Object name, int rule, int vol) {
		this.gain = vol;
		if (name != null) {
			URL url = SoundMngr.class.getResource("/gamePackage/sonidos/fx/" + (String) name);
			if (url != null) {
				try {
					AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
					DataLine.Info dataInfo = new DataLine.Info(Clip.class, audioStream.getFormat());
					clip = (Clip) AudioSystem.getLine(dataInfo);
					duration = audioStream.getFrameLength();
					clip.open(audioStream);
					clip.start();
					if (rule == 0) {
						clip.loop(Clip.LOOP_CONTINUOUSLY);
						do {
							Thread.sleep(50);
						} while (clip.isActive());
						clip.stop();
						clip.close();
						audioStream.close();
					} else {
						do {
							Thread.sleep(50);
						} while (clip.isActive());
						clip.close();
						audioStream.close();
					}
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else
			log.log(Level.INFO, "Unable to read directory");

	}

	public void play() {
		clip.setFramePosition(0);
		clip.start();

	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public void stop() {
		clip.stop();
	}

	public void end() {
		clip.stop();
		clip.close();

	}

	public void playLoop() {
		clip.setFramePosition(0);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public boolean isActive() {

		return clip.isActive();
	}

//Test
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SoundMngr soundMngr = new SoundMngr("mainmenu.wav", 1, 1);
				soundMngr.play();
			}
		});
	thread1.run();	
	}

}
