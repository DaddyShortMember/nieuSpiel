package gamePackage.ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import gamePackage.baseDatos.DataBase;
import gamePackage.sonidos.SoundMngr;

public class MainMenu extends JFrame {
	
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.setLocationRelativeTo(null);
		menu.setResizable(false);
		menu.setVisible(true);
		
	}

	public MainMenu() {
		DataBase scores = new DataBase();
		scores.iniciaDB();
		scores.creaTablas();
		//Inicializa valores de: HOY, basado en fecha de sistema
		scores.actualizaGlobal(false, false, false, false, false);
		scores.actualizaTEquipos(0, 0, 0, 0);
		SoundMngr sic = new SoundMngr("mainmenu.wav",1,0);
		Thread mus = new Thread(sic);
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		JLayeredPane layeredMenuPanel = new JLayeredPane();
		layeredMenuPanel.setBounds(0, 0, 1088, 672);
		layeredMenuPanel.setBackground(Color.green);
		mus.start();

		JPanel options = new JPanel();
		options.setLayout(null);
		options.setBounds(0, 0, 1088, 672);

		// JLabel filter, playSingle, playMulti, settings, exit = new JLabel();
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("img/MainMenu.png")));
		background.setBounds(0, 0, 1088, 672);

		JLabel title = new JLabel();
		JButton play = new JButton("");
		play.setBounds(137, 524, 100, 100);
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scores.actualizaGlobal(false, false, false, false, true);
				scores.finalizaDB();
				new Thread(new SoundMngr("click1.wav", 0, 0)).start();
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MapLoaderPrompt juego = new MapLoaderPrompt();
				juego.pack();
				juego.setLocationRelativeTo(null);
				juego.setResizable(false);
				juego.setVisible(true);
				dispose();
			}
		});

		// JLabel playMulti = new JLabel();
		JButton mapMaker = new JButton("");
		mapMaker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scores.finalizaDB();
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MapMakerPrompt juego = new MapMakerPrompt();
				juego.pack();
				juego.setLocationRelativeTo(null);
				juego.setResizable(false);
				juego.setVisible(true);
				dispose();
			}
		});
		mapMaker.setBounds(292, 536, 115, 160);
		mapMaker.setOpaque(false);
		mapMaker.setContentAreaFilled(false);
		mapMaker.setBorderPainted(false);

		JButton settings = new JButton("");
		settings.setBounds(632, 541, 160, 160);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);

		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scores.finalizaDB();
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Settings sets = new Settings();
				sets.setLocationRelativeTo(null);
				sets.pack();
				sets.setResizable(false);
				sets.setVisible(true);
				dispose();
				

			}
		});

		JButton exit = new JButton("");
		exit.setBounds(848, 492, 200, 200);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scores.finalizaDB();
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				System.exit(0);

			}
		});

		background.setBackground(Color.magenta);
		title.setBackground(Color.cyan);

		options.add(play);
		options.add(mapMaker);
		options.add(settings);
		options.add(exit);

		options.setOpaque(false);

		layeredMenuPanel.add(background, 0, 0);
		layeredMenuPanel.add(options, 1, 0);

		// test mierda

		// background.setIcon(new ImageIcon(getClass().getResource("img/mapa1.png")));
		options.setPreferredSize(new Dimension(1088, 672));
		layeredMenuPanel.setPreferredSize(new Dimension(1088, 672));
		cp.setPreferredSize(new Dimension(1088, 672));
		cp.add(layeredMenuPanel);

		this.setTitle("B.A.S.E.D Tactics");
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());
		this.setSize(new Dimension(1088, 672));
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
