package gamePackage.ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gamePackage.sonidos.SoundMngr;

public class MapLoaderPrompt extends JFrame {
	private String nomMapa = "newmap"; // Not CaseSensitive

	public static void main(String[] args) {
		MapLoaderPrompt promp = new MapLoaderPrompt();
		promp.setVisible(true);
	}

	public MapLoaderPrompt() {

		// Contenedores
		Container contentPane = this.getContentPane();
		JPanel pTextField = new JPanel();
		JPanel pButtons = new JPanel();
		pButtons.setLayout(new BorderLayout());
		pTextField.setLayout(new BoxLayout(pTextField, BoxLayout.X_AXIS));
		// Componentes
		JButton cargar = new JButton("Cargar Mapa");
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
				new Thread(new SoundMngr("click1.wav", 0, 0)).start();
//				MapMaker mmaker = new MapMaker(nomMapa, true); CHANGE TO GAME WINDOW and implement loading
//				mmaker.setLocationRelativeTo(null);
//				mmaker.pack();
//				mmaker.setResizable(false);
//				mmaker.setVisible(true);
//				dispose();

			}
		});

		pTextField.add(nombreMap);
		// pButtons.add(maps);
		// pButtons.add(mapSearcher,BorderLayout.CENTER);
		pButtons.add(cargar, BorderLayout.CENTER);
		pButtons.add(back, BorderLayout.NORTH);
		pButtons.add(quit, BorderLayout.SOUTH);
		contentPane.add(pTextField, BorderLayout.WEST);
		contentPane.add(pButtons, BorderLayout.EAST);
		setTitle("B.A.S.E.D Tactics");
		setSize(365, 150);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
