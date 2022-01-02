package gamePackage.sonidos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL; //Para directorios; ej. "fx/sonido1.wav"
import javax.sound.sampled.*; //Librerias que permiten utilizar audio (limitado a .wav y otros primitivos)
import java.io.File;
import java.io.IOException;
//TODO: !!!AUN NO FUNCIONA!!!
//Da error por que no reconoce el URL como directorio.
//Gestor de sonido
/*
 * Idea: crea un hilo por sonido para permitir el uso de multiples sonidos a la vez
 * Abierto a experimentacion
 * 
 * Idea para gestion de directorios: ya que son dos musicas distintas por cada turno,
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
public class SoundMngr {
	private Clip soundbit;
	public SoundMngr(String fileName) {
		try {
		File file = new File(fileName);
		//if (file.exists()) {
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			soundbit = AudioSystem.getClip();
			soundbit.open(sound);
		//}
		//else {
			//System.out.println("file not found in the realm of real files");
		//} //Credits to Tyler Thomas from that one StackOverflow page for guiding me through these dark times
		}catch (MalformedURLException e){
			e.printStackTrace();
			System.out.println(e);
		}
		catch (UnsupportedAudioFileException e){
			e.printStackTrace();
			System.out.println(e);
		}
		catch (LineUnavailableException e){
			e.printStackTrace();
			System.out.println(e);
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}
	
	public void play() {
		soundbit.setFramePosition(0);
		soundbit.start();
	}
	
	public void loop() {
		soundbit.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		soundbit.stop();
	}
	//This might appear useless, but I tend to overengineer things to heck
	public void playAt(int spot) {
		soundbit.setFramePosition(spot);
		soundbit.start();
	}
	public void playLoop() {
		soundbit.setFramePosition(0);
		soundbit.start();
		soundbit.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void main(String[] args) {

		SoundMngr x = new SoundMngr("fx/CantinaBand60.wav");
		x.play();
		x.loop();
	}
}
