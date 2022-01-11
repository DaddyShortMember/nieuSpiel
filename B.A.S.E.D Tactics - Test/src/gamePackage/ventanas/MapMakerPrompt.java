package gamePackage.ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.*;

import gamePackage.logica.PlayableMap;
import gamePackage.sonidos.SoundMngr;

public class MapMakerPrompt extends JFrame {
	ArrayList<PlayableMap> listaMaps; // Permite cargar una lista de mapas?

	public static void main(String[] args) {
		MapMakerPrompt promp = new MapMakerPrompt();
	}

	public MapMakerPrompt() {

		String nomMapa = "map";
		// Contenedores
		JPanel pCreacion = new JPanel();
		JPanel pCarga = new JPanel();
		pCreacion.setLayout(new BoxLayout(pCreacion, BoxLayout.X_AXIS));
		pCarga.setLayout(new BoxLayout(pCarga, BoxLayout.Y_AXIS));
		// Componentes
		JComboBox maps = new JComboBox();
		JButton cargar = new JButton("Cargar Mapa");
		JButton crear = new JButton("Crear Nuevo Mapa");
		JTextField nombreMap = new JTextField(nomMapa, 21);
		pCreacion.add(nombreMap);
		pCreacion.add(crear);

	}

	public void loadMapList() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("MapList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveMapList() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("MapList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaMaps);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
