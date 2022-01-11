package gamePackage.ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gamePackage.sonidos.SoundMngr;

public class MapMakerPrompt extends JFrame {
	private String nomMapa = "newmap"; // Not CaseSensitive

	public static void main(String[] args) {
		MapMakerPrompt promp = new MapMakerPrompt();
		promp.setVisible(true);
	}

	public MapMakerPrompt() {

		// Contenedores
		Container contentPane = this.getContentPane();
		JPanel pTextField = new JPanel();
		JPanel pButtons = new JPanel();
		pButtons.setLayout(new BorderLayout());
		pTextField.setLayout(new BoxLayout(pTextField, BoxLayout.X_AXIS));
		// Componentes
		// JComboBox<Object> maps = new JComboBox<Object>();
		// JTextField mapSearcher = new JTextField(21);
		JButton cargar = new JButton("Cargar Mapa");
		JButton crear = new JButton("Crear Mapa");
		JButton back = new JButton("Volver a Menu");
		JButton quit = new JButton("Cerrar Juego");
		JTextField nombreMap = new JTextField(nomMapa, 21);

		nombreMap.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			public void changed() {
				nomMapa = nombreMap.getText();
			}

		});

		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new SoundMngr("bip2.wav", 0, 0)).start();
				MapMaker mmaker = new MapMaker(nomMapa, false);
				mmaker.setLocationRelativeTo(null);
				mmaker.pack();
				mmaker.setResizable(false);
				mmaker.setVisible(true);
				dispose();

			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				MainMenu mmenu = new MainMenu();
				mmenu.setLocationRelativeTo(null);
				mmenu.pack();
				mmenu.setResizable(false);
				mmenu.setVisible(true);
				dispose();

			}
		});

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				System.exit(0);

			}
		});
		cargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new SoundMngr("bip3.wav", 0, 0)).start();
				MapMaker mmaker = new MapMaker(nomMapa, true);
				mmaker.setLocationRelativeTo(null);
				mmaker.pack();
				mmaker.setResizable(false);
				mmaker.setVisible(true);
				dispose();

			}
		});

		pTextField.add(nombreMap);
		pButtons.add(crear, BorderLayout.WEST);
		// pButtons.add(maps);
		// pButtons.add(mapSearcher,BorderLayout.CENTER);
		pButtons.add(cargar, BorderLayout.EAST);
		pButtons.add(back, BorderLayout.NORTH);
		pButtons.add(quit, BorderLayout.SOUTH);
		contentPane.add(pTextField, BorderLayout.WEST);
		contentPane.add(pButtons, BorderLayout.EAST);
		setTitle("B.A.S.E.D Map Maker");
		setSize(500, 150);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	

}
