package gamePackage.ventanas;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;
import javax.swing.*;


@SuppressWarnings("serial")
public class MapMaker extends JFrame{
	
	public static void main(String[] args){
		//creación de la instancia de la ventana y modificacion de algunos de sus atributos para que sea visible 
		MapMaker juego = new MapMaker();
		juego.pack();
		juego.setLocationRelativeTo(null);
		juego.setResizable(false);
		juego.setVisible(true);
		Logger logger = Logger.getLogger(MapMaker.class.getName());
		System.out.println("vert: " + grafoVert(3));
		System.out.println("arist: " + grafoArist(3));
	}
	//public static int tiles = 17;  <-- Viejo tamaño de las casillas
	public static int mov = 32;		//Tamaño de las casillas y valor por el que se multiplica el valor de x e y de los labels
	public HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid = new HashMap<>();
	
	public MapMaker() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al contenedor de la ventana en el eje X que coloca los componentes en serie horizontalmente
		JLayeredPane layeredMapMakerPanel = new JLayeredPane();		//Creación de un panel que permite colocar unos componentes por encima de otros
		//layeredMapMakerPanel.setBackground(Color.green);		//for testing
		layeredMapMakerPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del juego
		layeredMapMakerPanel.setPreferredSize(new Dimension(672, 672));		//Tamaño preferido para el panel que hace que alguna instrucción no ignore este valor
		
		
				
		JLabel cursor = new JLabel();		//Label que contiene el cursor
		
		//Instrucciones para colocar las imagenes en los labels

		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor.gif")));
		
	
		
		JPanel mapPanel = new JPanel();		//Creación del panel en el que está el label del mapa (más tarde serán muchos componentes que forman un mapa)
		mapPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del juego
		mapPanel.setPreferredSize(new Dimension(672, 672));		//Tamaño preferido para el panel que hace que alguna instrucción no ignore este valor
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al panel del mapa en el eje X que coloca los componentes en serie horizontalmente
	
		mapPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del mapa
		mapPanel.setOpaque(false);		//Hace que se pueda ver lo que haya detrás del panel
		
		cursor.setPreferredSize(new Dimension(32, 32));		//Tamaño preferido del label que contiene el gif del cursor
		cursor.setBounds(mov*8, mov*8, 32, 32);		//Lo mismo de antes pero siendo la posición el centro del mapa
			
		
		int [] brush = new int[2];
		JButton plains = new JButton("");
		plains.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 1;
				
				}
					

			});
		JButton sea = new JButton("");
		sea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 0;
				
				}
					

			});
		JButton mountain = new JButton("");
		mountain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 2;
				
				}
					

			});
		JButton forest = new JButton("");
		forest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 3;
				
				}
					

			});
		JButton road = new JButton("");
		road.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 4;
				
				}
					

			});
		JButton city = new JButton("");
		city.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 5;
				
				}
					

			});
		JButton factory = new JButton("");
		factory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 6;
				
				}
					

			});
		JButton hq = new JButton("");
		hq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brush[0] = 7;
				
				}
					

			});
		JComboBox color = new JComboBox();
		color.addItem("Red");
		color.addItem("Blue");
		color.addItem("White");
		if (color.getSelectedItem()=="Blue") {
			brush[1]=2;
		}
		else if (color.getSelectedItem()=="White"){
			brush[1]=0;
		}
		else {
			brush[1]=1;
		}
		
		

		
		
		//Thread for testing mouse location relative to panels 
		/*
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				try {
					while(!Thread.interrupted()) {
						
						Point mouse = MouseInfo.getPointerInfo().getLocation();
						SwingUtilities.convertPointFromScreen(mouse, cursor);
						System.out.println(mouse);
						Thread.sleep(1000);
						
						
						
					
				//Test of moving troop
						for (int i = 0; i < 10; i++) {
							troopLabel1.setLocation(mov*i, mov*i);
							Thread.sleep(1000);
						}
						
						
					}
				} catch (Exception e) {
					
				}
			}
		});
		
		hilo.start();
		*/
		
		
		
		//KeyListener para mover el cursor
		//KeyListener para mover el cursor
		KeyListener kListener = new KeyListener() {
			boolean released = true;		//Redundante de momento pero sirve para nno dejar que se mantenga pulsada la tecla y haya que soltar la tecla antes de que se vuelva a registrar
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				released = true;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ESCAPE && released) {
					MainMenu menu = new MainMenu();
					menu.pack();
					menu.setLocationRelativeTo(null);
					menu.setResizable(false);
					menu.setVisible(true);
					dispose();
			        //System.out.println("left");
					//released = false;		//quitar el comentario del inicio de esta linea para dar uso a la variable released
			    }

			}
		};
		
		
		
		
		JPanel derecha = new JPanel();		//Creación del panel de la derecha que contiene otros paneles que mostrarán la información de tropas y terrenos
		derecha.setPreferredSize(new Dimension(416, 672));		//Se define el tamaño preferido del panel
		derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));		//Se le pone un BoxLayout en el eje Y que coloca los componentes en serie verticalmente
		
		JPanel info = new JPanel();		//Creación del panel superior de información general de la partida
		info.setBackground(Color.black);		//Instrucción de prueba para diferenciar los paneles mientras no estén programados
		info.setPreferredSize(new Dimension(416, 416));		//Tamaño preferido del panel de información general
		
		JPanel abajo = new JPanel();		//Creación del panel inferior de la seccion de información (parte derecha de la pantalla)
		abajo.setLayout(new BoxLayout(abajo, BoxLayout.X_AXIS));		//Sele pone un BoxLayout en el eje Y que coloca los componentes en serie horizontalmente
		
		JPanel movData = new JPanel();		//Creación del panel inferior con información de movimiento
		movData.setBackground(Color.yellow);		//Instrucción de prueba para diferenciar los paneles mientras no estén programados
		movData.setPreferredSize(new Dimension(160, 256));		//Tamaño preferido del panel de información de tropas
		movData.setLayout(new BoxLayout(movData, BoxLayout.Y_AXIS));
		
		JPanel troopInfo = new JPanel();		//Creación del panel inferior con información de tropas
		troopInfo.setBackground(Color.white);		//Instrucción de prueba para diferenciar los paneles mientras no estén programados
		troopInfo.setPreferredSize(new Dimension(256, 256));		//Tamaño preferido del panel de información de tropas
		troopInfo.setLayout(new BoxLayout(troopInfo, BoxLayout.X_AXIS));
		
		
		//Botones del panel derecho
		info.add(sea);
		info.add(plains);
		info.add(mountain);
		info.add(forest);
		info.add(road);
		info.add(city);
		info.add(factory);
		info.add(hq);
		info.add(color);
		JLabel buildingNum = new JLabel();
		
		sea.setIcon(new ImageIcon(getClass().getResource("img/terrain/Sea.png")));
		plains.setIcon(new ImageIcon(getClass().getResource("img/terrain/Plains.png")));
		mountain.setIcon(new ImageIcon(getClass().getResource("img/terrain/mountain.png")));
		forest.setIcon(new ImageIcon(getClass().getResource("img/terrain/Forest.png")));
		road.setIcon(new ImageIcon(getClass().getResource("img/terrain/Road.png")));
		
		Thread hilo = new Thread() {
		public void run() {
			while (true) {
				if (brush[1]==0) {
					city.setIcon(new ImageIcon(getClass().getResource("img/structure/CityWHITE.png")));
					factory.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryWHITE.png")));
				}
				else if (brush[1]==1) {
					city.setIcon(new ImageIcon(getClass().getResource("img/structure/CityRED.png")));
					factory.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryRED.png")));
					hq.setIcon(new ImageIcon(getClass().getResource("img/structure/HqRED.png")));
				}
				else if (brush[1]==2) {
					city.setIcon(new ImageIcon(getClass().getResource("img/structure/CityBLUE.png")));
					factory.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryBLUE.png")));
					hq.setIcon(new ImageIcon(getClass().getResource("img/structure/HqBLUE.png")));
				}
			}
				
			}
		};
		hilo.start();
		
		
		sea.setOpaque(false);sea.setContentAreaFilled(false);sea.setBorderPainted(false);
		plains.setOpaque(false);plains.setContentAreaFilled(false);plains.setBorderPainted(false);
		mountain.setOpaque(false);mountain.setContentAreaFilled(false);mountain.setBorderPainted(false);
		forest.setOpaque(false);forest.setContentAreaFilled(false);forest.setBorderPainted(false);
		road.setOpaque(false);road.setContentAreaFilled(false);road.setBorderPainted(false);
		city.setOpaque(false);city.setContentAreaFilled(false);city.setBorderPainted(false);
		factory.setOpaque(false);factory.setContentAreaFilled(false);factory.setBorderPainted(false);
		hq.setOpaque(false);hq.setContentAreaFilled(false);hq.setBorderPainted(false);
		
		info.add(buildingNum);
		
		
		
		//Labels de los atributos del panel movData
		JLabel move = new JLabel();
		JLabel attack = new JLabel();
		JLabel capture = new JLabel();
		
		movData.add(move);
		movData.add(attack);
		movData.add(capture);
		
		
		//Labels de los atributos del panel troopInfo
		JLabel name = new JLabel();
		JLabel health = new JLabel();
		JLabel attack1 = new JLabel();
		JLabel attack2 = new JLabel();
		JLabel minRange = new JLabel();
		JLabel maxRange = new JLabel();
		JLabel ammo = new JLabel();
		JLabel energy = new JLabel();
		JLabel terrain = new JLabel();
		
		
		troopInfo.add(name);
		troopInfo.add(health);
		troopInfo.add(attack1);
		troopInfo.add(attack2);
		troopInfo.add(minRange);
		troopInfo.add(maxRange);
		troopInfo.add(ammo);
		troopInfo.add(energy);
		
		
		abajo.add(movData);			//Se añade el panel de información de movimiento al panel que contiene toda la parte inferior
		abajo.add(troopInfo);		//Se añade el panel de información de tropas al panel que contiene toda la parte inferior
		
		derecha.add(info);		//Se añade el panel superior que contiene información general de la partida al panel que contiene toda la parte derecha (informacion)
		derecha.add(abajo);		//Se añade el panel inferior que contiene los paneles movData y troopInfo al panel que contiene toda la parte derecha (informacion)
		
		cp.add(layeredMapMakerPanel);		//Se añade el panel del juego al contenedor de la ventana
		cp.add(derecha);		//Se añade el panel de la derecha (información) al contenedor de la ventana
		
		//redundant in newer versions
		//int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		//int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		
		this.pack();		//Se asegura de que todos los componentes están por lo menos a su tamaño preferido
		addKeyListener(kListener);		//Se añade el KeyListener a la ventana
		this.setTitle("B.A.S.E.D Tactics");		//Se cambia el titulo de la ventana
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());		//Coloca el icono de la ventana
		this.setSize(new Dimension(1088, 672));		//Se cambia el tamaño de la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		//El proceso se termina cuando se cierra la ventana
		
		
		
		
		
	}
	
	public static int grafoVert(int trop) {
		int n = 1;
		int vert = 1;
		for (int i = 0; i < (trop - 1); i++) {
			n += 2;
			vert += n;		
			//System.out.println("n: " + n + " vert: " + vert);
		}
		vert *= 2;
		vert += n + 2;
		return vert;
	}
	public static int grafoArist(int trop) {
		int n = 1;
		int arist = 1;
		for (int i = 0; i < ((trop * 2) - 2); i++) {
			n += 1;
			arist += n;		
			//System.out.println("n: " + n + " arist: " + arist);
		}
		arist *= 2;
		arist += n + 1;
		return arist;
	}
	public static Dimension grafoVertPos() {
		
		
		
		return new Dimension(1,2);
	}
	
	WindowListener wListener = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			hilo.start();
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			hilo.interrupt();
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	

	
	
	
}


//TODO list
/*
·Panel de información para quien quiera hacerlo
 
·Methods (...)
·Graph:
	-node positions relative to map
	-positions in map relative to troop



Problems:
�detecting things that are on top of eachother
�movement -> graph detecting what the troop can be on top of and calculate where it cant reach anymore
�








 
 */
