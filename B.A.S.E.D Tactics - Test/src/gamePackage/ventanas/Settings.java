package gamePackage.ventanas;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import javax.swing.*;
import gamePackage.entidades.*;
import gamePackage.entidades.terrestres.*;
import gamePackage.sonidos.SoundMngr;
import gamePackage.terrenos.estructuras.City;
import gamePackage.terrenos.estructuras.Factory;
import gamePackage.terrenos.estructuras.Hq;
import gamePackage.terrenos.terrenos.*;


public class Settings extends JFrame implements Serializable {

	public static void main(String[] args) {
		// creación de la instancia de la ventana y modificacion de algunos de sus
		// atributos para que sea visible
		Settings config = new Settings();
		config.pack();
		config.setLocationRelativeTo(null);
		config.setResizable(false);
		config.setVisible(true);
	}

	// public static int tiles = 17; <-- Viejo tamaño de las casillas
	public static int mov = 32; // Tamaño de las casillas y valor por el que se multiplica el valor de x e y de
								// los labels
	public HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid = new HashMap<>();

	public Settings() {
		SoundMngr sic = new SoundMngr("Settings.wav",1,0);
		Thread mus = new Thread(sic);
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS)); // Se le pone un BoxLayout al contenedor de la ventana en el
															// eje X que coloca los componentes en serie horizontalmente
		// Creación de un panel que permite colocar unos componentes por encima de
		// otros
		// layeredSettingsPanel.setBackground(Color.green); //for testing

		JLabel cursor = new JLabel(); // Label que contiene el cursor

		// Instrucciones para colocar las imagenes en los labels
		mus.start();

		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor.gif")));

		JPanel mapPanel = new JPanel(); // Creación del panel en el que está el label del mapa (más tarde serán
										// muchos componentes que forman un mapa)
		mapPanel.setBounds(0, 0, 672, 672); // Posición y tamaño del panel del config
		mapPanel.setBackground(Color.red);
		mapPanel.setPreferredSize(new Dimension(672, 672)); // Tamaño preferido para el panel que hace que alguna
															// instrucción no ignore este valor
		mapPanel.setLayout(null); // Se le pone un BoxLayout al panel del mapa en el eje X que coloca los
									// componentes en serie horizontalmente

		mapPanel.setBounds(0, 0, 672, 672); // Posición y tamaño del panel del mapa

		cursor.setPreferredSize(new Dimension(32, 32)); // Tamaño preferido del label que contiene el gif del cursor
		cursor.setBounds(mov * 8, mov * 8, 32, 32); // Lo mismo de antes pero siendo la posición el centro del mapa


		JButton exit = new JButton("");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				// TODO Auto-generated method stub
				System.exit(0);

			}

		});
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mus.interrupt();
				try {
					sic.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Thread(new SoundMngr("weegee.wav", 0, 0)).start();
				MainMenu menu = new MainMenu();
				menu.pack();
				menu.setLocationRelativeTo(null);
				menu.setResizable(false);
				menu.setVisible(true);
				dispose();
			}

		});
		JSlider slider = new JSlider(-100, 100, 0);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(0,0,672,672);
		mapPanel.add(slider, 9, 0);
		
		
		int[] troopColor = new int[2];
		JButton rVb = new JButton("");
		rVb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new SoundMngr("bip.wav", 0, 0)).start();
				troopColor[0] = 1;
				troopColor[1] = 2;
			}

		});
		JButton aVb = new JButton("");
		aVb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new SoundMngr("bip.wav", 0, 0)).start();
				troopColor[0] = 3;
				troopColor[1] = 2;
			}

		});
		JButton rVg = new JButton("");
		rVg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new SoundMngr("bip.wav", 0, 0)).start();
				troopColor[0] = 1;
				troopColor[1] = 4;
			}

		});
		JButton aVg = new JButton("");
		aVg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new SoundMngr("bip.wav", 0, 0)).start();
				troopColor[0] = 3;
				troopColor[1] = 4;
			}

		});
		
		
		slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int transparency = slider.getValue();
            	System.out.println(transparency);
            	if (transparency < 0) {
        			transparency = -transparency;
        			Color bright = new Color(0,0,0,transparency);
        			JLabel brillo = new JLabel();
                	brillo.setPreferredSize(new Dimension(1088, 672));
                	brillo.setBackground(bright);
                	mapPanel.add(brillo,1,0);
        		}

                else if ( transparency > 0.0) {
                	Color bright = new Color(255,255,255,transparency);
                	JLabel brillo = new JLabel();
                	brillo.setPreferredSize(new Dimension(1088, 672));
                	brillo.setBackground(bright);
                	mapPanel.add(brillo,1,0);
                	
                }
                    

                else {
                	Color bright = new Color(255,255,255,transparency);
                	JLabel brillo = new JLabel();
                	brillo.setPreferredSize(new Dimension(1088, 672));
                	brillo.setBackground(bright);
                	mapPanel.add(brillo,1,0);
                	
                }
            	
            }
            
            
        });
		
		

		

		// Thread for testing mouse location relative to panels
		
		
		// KeyListener para mover el cursor

		JPanel derecha = new JPanel(); // Creación del panel de la derecha que contiene otros paneles que mostrarán
										// la información de tropas y terrenos
		derecha.setPreferredSize(new Dimension(416, 672)); // Se define el tamaño preferido del panel
		derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS)); // Se le pone un BoxLayout en el eje Y que coloca
																		// los componentes en serie verticalmente

		JPanel info = new JPanel(); // Creación del panel superior de información general de la partida
		info.setBackground(Color.black); // Instrucción de prueba para diferenciar los paneles mientras no estén
											// programados
		info.setPreferredSize(new Dimension(416, 416)); // Tamaño preferido del panel de información general

		JPanel abajo = new JPanel(); // Creación del panel inferior de la seccion de información (parte derecha de
										// la pantalla)
		abajo.setLayout(new BoxLayout(abajo, BoxLayout.X_AXIS)); // Sele pone un BoxLayout en el eje Y que coloca los
																	// componentes en serie horizontalmente

		JPanel movData = new JPanel(); // Creación del panel inferior con información de movimiento
		movData.setBackground(Color.yellow); // Instrucción de prueba para diferenciar los paneles mientras no estén
												// programados
		movData.setPreferredSize(new Dimension(160, 256)); // Tamaño preferido del panel de información de tropas
		// movData.setLayout(new BoxLayout(movData, BoxLayout.Y_AXIS));

		JPanel troopInfo = new JPanel(); // Creación del panel inferior con información de tropas
		troopInfo.setBackground(Color.white); // Instrucción de prueba para diferenciar los paneles mientras no estén
												// programados
		troopInfo.setPreferredSize(new Dimension(256, 256)); // Tamaño preferido del panel de información de tropas
		// troopInfo.setLayout(new BoxLayout(troopInfo, BoxLayout.X_AXIS));

		// Botones del panel derecho
	
		troopInfo.add(back);
		troopInfo.add(exit);
		
		back.setIcon(new ImageIcon(getClass().getResource("img/Back.png")));
		exit.setIcon(new ImageIcon(getClass().getResource("img/Exit.png")));

		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		
		
		info.add(rVb);
		info.add(rVg);
		info.add(aVb);
		info.add(aVg);
		rVb.setIcon(new ImageIcon(getClass().getResource("img/rVb.png")));
		rVg.setIcon(new ImageIcon(getClass().getResource("img/rVg.png")));
		aVb.setIcon(new ImageIcon(getClass().getResource("img/aVb.png")));
		aVg.setIcon(new ImageIcon(getClass().getResource("img/aVg.png")));
		
		rVb.setOpaque(false);rVb.setContentAreaFilled(false);rVb.setBorderPainted(false);
		rVg.setOpaque(false);rVg.setContentAreaFilled(false);rVg.setBorderPainted(false);
		aVb.setOpaque(false);aVb.setContentAreaFilled(false);aVb.setBorderPainted(false);
		aVg.setOpaque(false);aVg.setContentAreaFilled(false);aVg.setBorderPainted(false);


		// Labels de los atributos del panel movData

		// Labels de los atributos del panel troopInfo

		abajo.add(movData); // Se añade el panel de información de movimiento al panel que contiene toda
							// la parte inferior
		abajo.add(troopInfo); // Se añade el panel de información de tropas al panel que contiene toda la
								// parte inferior

		derecha.add(info); // Se añade el panel superior que contiene información general de la partida
							// al panel que contiene toda la parte derecha (informacion)
		derecha.add(abajo); // Se añade el panel inferior que contiene los paneles movData y troopInfo al
							// panel que contiene toda la parte derecha (informacion)

		cp.add(mapPanel); // Se añade el panel del config al contenedor de la ventana
		cp.add(derecha); // Se añade el panel de la derecha (información) al contenedor de la ventana

		// redundant in newer versions
		// int width =
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		// int height =
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight():
		this.pack(); // Se asegura de que todos los componentes están por lo menos a su tamaño
						// preferido
		this.setTitle("B.A.S.E.D Tactics"); // Se cambia el titulo de la ventana
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage()); // Coloca el icono de
																									// la ventana
		this.setSize(new Dimension(1088, 672)); // Se cambia el tamaño de la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // El proceso se termina cuando se cierra la ventana

	}}

