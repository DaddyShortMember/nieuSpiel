package gamePackage.sonidos;

import java.net.URL; //Para directorios; ej. "fx/sonido1.wav"
import javax.sound.sampled.*; //Librerias que permiten utilizar audio (limitado a .wav y otros primitivos)

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

}
