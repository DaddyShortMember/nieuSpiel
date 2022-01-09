package gamePackage.ventanas;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;


import javax.swing.*;

import gamePackage.terrenos.terrenos.*;
import gamePackage.terrenos.estructuras.*;



@SuppressWarnings("serial")
public class MapMaker extends JFrame implements Serializable{
	
	public static void main(String[] args){
		//creación de la instancia de la ventana y modificacion de algunos de sus atributos para que sea visible 
		MapMaker juego = new MapMaker();
		juego.pack();
		juego.setLocationRelativeTo(null);
		juego.setResizable(false);
		juego.setVisible(true);
	}
	//public static int tiles = 17;  <-- Viejo tamaño de las casillas
	public static int mov = 32;		//Tamaño de las casillas y valor por el que se multiplica el valor de x e y de los labels
	public HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid = new HashMap<>();
	
	public MapMaker() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al contenedor de la ventana en el eje X que coloca los componentes en serie horizontalmente
		//Creación de un panel que permite colocar unos componentes por encima de otros
		//layeredMapMakerPanel.setBackground(Color.green);		//for testing

		
				
		JLabel cursor = new JLabel();		//Label que contiene el cursor
		
		//Instrucciones para colocar las imagenes en los labels

		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor.gif")));
		
	
		
		JPanel mapPanel = new JPanel();		//Creación del panel en el que está el label del mapa (más tarde serán muchos componentes que forman un mapa)
		mapPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del juego
		mapPanel.setBackground(Color.red);
		mapPanel.setPreferredSize(new Dimension(672, 672));		//Tamaño preferido para el panel que hace que alguna instrucción no ignore este valor
		mapPanel.setLayout(null);		//Se le pone un BoxLayout al panel del mapa en el eje X que coloca los componentes en serie horizontalmente
	
		mapPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del mapa
		
		
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
		color.addItem("White");
		color.addItem("Blue");
		color.addItem("Red");
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (color.getSelectedItem()=="Blue") {
					brush[1]=2;
				}
				else if (color.getSelectedItem()=="White"){
					brush[1]=0;
				}
				else {
					brush[1]=1;
				}
				
			}
		});
		
		
		
		JButton exit = new JButton("");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
				}
					

			});
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainMenu menu = new MainMenu();
				menu.pack();
				menu.setLocationRelativeTo(null);
				menu.setResizable(false);
				menu.setVisible(true);
				dispose();
				}
					

			});
		JButton save = new JButton("");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Map.dat"));
					oos.writeObject(mapGrid);
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
					

			});
		JButton load = new JButton("");
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadMap(mapPanel).repaint();
				
				}
				
					

			});
		
		

		
		
		//Thread for testing mouse location relative to panels 
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				try {
					while(!Thread.interrupted()) {
						
						Point mouse = MouseInfo.getPointerInfo().getLocation();
						SwingUtilities.convertPointFromScreen(mouse, cp);
						Thread.sleep(25);
						double x = mouse.getX();
						double y = mouse.getY();
						x = x/32;
						y=y/32;
						x=Math.floor(x);
						y=Math.floor(y);
						if (x<=21 && y<=21) {
							Point clave = new Point((int) x ,(int) y);
							ArrayList<ArrayList<Object>> casilla = new  ArrayList<>();
							ArrayList<Object> terreno = new ArrayList<>();
							JLabel jm = new JLabel();
							switch (brush[0]){
								case 0: 
									jm.setIcon(new ImageIcon(getClass().getResource("img/terrain/Sea.png")));	
									terreno.add(jm);
									terreno.add(new Sea());
									break;
								case 1:
									jm.setIcon(new ImageIcon(getClass().getResource("img/terrain/Plains.png")));	
									terreno.add(jm);
									terreno.add(new Plains());
									break;
								case 2:
									jm.setIcon(new ImageIcon(getClass().getResource("img/terrain/Mountain.png")));	
									terreno.add(jm);
									terreno.add(new Mountain());
									break;
								case 3:
									jm.setIcon(new ImageIcon(getClass().getResource("img/terrain/Forest.png")));	
									terreno.add(jm);
									terreno.add(new Forest());
									break;
								case 4:
									jm.setIcon(new ImageIcon(getClass().getResource("img/terrain/RoadX.png")));	
									terreno.add(jm);
									terreno.add(new Road());
									break;
								case 5:
									switch (brush[1]) {
										case 0:
											
											jm.setIcon(new ImageIcon(getClass().getResource("img/structure/CityWHITE.png")));	
											terreno.add(jm);
											terreno.add(new City(brush[1]));
											break;
										case 1:
											jm.setIcon(new ImageIcon(getClass().getResource("img/structure/CityRED.png")));	
											terreno.add(jm);
											terreno.add(new City(brush[1]));
											break;
										case 2:
											jm.setIcon(new ImageIcon(getClass().getResource("img/structure/CityBLUE.png")));	
											terreno.add(jm);
											terreno.add(new City(brush[1]));
											break;
										default:
											break;
										}
									break;
								case 6:
									switch (brush[1]) {
									case 0:
										jm.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryWHITE.png")));	
										terreno.add(jm);
										terreno.add(new Factory(brush[1]));
										break;
									case 1:
										jm.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryRED.png")));	
										terreno.add(jm);
										terreno.add(new Factory(brush[1]));
										break;
									case 2:
										jm.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryBLUE.png")));	
										terreno.add(jm);
										terreno.add(new Factory(brush[1]));
										break;
									default:
										break;
									}
									break;
								case 7:
									switch (brush[1]) {
									case 0:
										break;
									case 1:
										jm.setIcon(new ImageIcon(getClass().getResource("img/structure/HqRED.png")));	
										terreno.add(jm);
										terreno.add(new Hq(brush[1]));
										break;
									case 2:
										jm.setIcon(new ImageIcon(getClass().getResource("img/structure/HqBLUE.png")));	
										terreno.add(jm);
										terreno.add(new Hq(brush[1]));
										break;
									default:
										break;
									}
									break;
								default:
									break;
							}
							
							casilla.add(terreno);
							mapGrid.put(clave, casilla);
							jm.setBounds((int) x * mov,(int) y * mov, 32, 32);
							
							mapPanel.add(jm);
							
							mapPanel.repaint();
						}
						
						
						
						
					}
				} catch (Exception e) {
					
				}
			}
		});
		hilo.start();
		hilo.suspend();
	
		
		//MouseListener para Pintar
		MouseListener ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				hilo.suspend();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				hilo.resume();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		//KeyListener para mover el cursor
		
		
		
		
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
		//movData.setLayout(new BoxLayout(movData, BoxLayout.Y_AXIS));
		
		JPanel troopInfo = new JPanel();		//Creación del panel inferior con información de tropas
		troopInfo.setBackground(Color.white);		//Instrucción de prueba para diferenciar los paneles mientras no estén programados
		troopInfo.setPreferredSize(new Dimension(256, 256));		//Tamaño preferido del panel de información de tropas
		//troopInfo.setLayout(new BoxLayout(troopInfo, BoxLayout.X_AXIS));
		
		
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
		troopInfo.add(save);
		troopInfo.add(load);
		troopInfo.add(back);
		troopInfo.add(exit);
		JLabel buildingNum = new JLabel();
		
		sea.setIcon(new ImageIcon(getClass().getResource("img/terrain/Sea.png")));
		plains.setIcon(new ImageIcon(getClass().getResource("img/terrain/Plains.png")));
		mountain.setIcon(new ImageIcon(getClass().getResource("img/terrain/mountain.png")));
		forest.setIcon(new ImageIcon(getClass().getResource("img/terrain/Forest.png")));
		road.setIcon(new ImageIcon(getClass().getResource("img/terrain/RoadX.png")));
		city.setIcon(new ImageIcon(getClass().getResource("img/structure/CityWHITE.png")));
		factory.setIcon(new ImageIcon(getClass().getResource("img/structure/FactoryWHITE.png")));
		hq.setIcon(new ImageIcon(getClass().getResource("img/structure/HqRED.png")));
		save.setIcon(new ImageIcon(getClass().getResource("img/SaveIcon.png")));
		load.setIcon(new ImageIcon(getClass().getResource("img/Load.png")));
		back.setIcon(new ImageIcon(getClass().getResource("img/Back.png")));
		exit.setIcon(new ImageIcon(getClass().getResource("img/Exit.png")));
		
		
		sea.setOpaque(false);sea.setContentAreaFilled(false);sea.setBorderPainted(false);
		plains.setOpaque(false);plains.setContentAreaFilled(false);plains.setBorderPainted(false);
		mountain.setOpaque(false);mountain.setContentAreaFilled(false);mountain.setBorderPainted(false);
		forest.setOpaque(false);forest.setContentAreaFilled(false);forest.setBorderPainted(false);
		road.setOpaque(false);road.setContentAreaFilled(false);road.setBorderPainted(false);
		city.setOpaque(false);city.setContentAreaFilled(false);city.setBorderPainted(false);
		factory.setOpaque(false);factory.setContentAreaFilled(false);factory.setBorderPainted(false);
		hq.setOpaque(false);hq.setContentAreaFilled(false);hq.setBorderPainted(false);
		save.setOpaque(false);save.setContentAreaFilled(false);save.setBorderPainted(false);
		load.setOpaque(false);load.setContentAreaFilled(false);load.setBorderPainted(false);
		back.setOpaque(false);back.setContentAreaFilled(false);back.setBorderPainted(false);
		exit.setOpaque(false);exit.setContentAreaFilled(false);exit.setBorderPainted(false);
		
		info.add(buildingNum);
		
		
		
		//Labels de los atributos del panel movData
		
		
		//Labels de los atributos del panel troopInfo
		
		
		abajo.add(movData);			//Se añade el panel de información de movimiento al panel que contiene toda la parte inferior
		abajo.add(troopInfo);		//Se añade el panel de información de tropas al panel que contiene toda la parte inferior
		
		derecha.add(info);		//Se añade el panel superior que contiene información general de la partida al panel que contiene toda la parte derecha (informacion)
		derecha.add(abajo);		//Se añade el panel inferior que contiene los paneles movData y troopInfo al panel que contiene toda la parte derecha (informacion)
		
		cp.add(mapPanel);		//Se añade el panel del juego al contenedor de la ventana
		cp.add(derecha);		//Se añade el panel de la derecha (información) al contenedor de la ventana
		
		//redundant in newer versions
		//int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		//int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight():
		addMouseListener(ml);
		this.pack();		//Se asegura de que todos los componentes están por lo menos a su tamaño preferido
		this.setTitle("B.A.S.E.D Tactics");		//Se cambia el titulo de la ventana
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());		//Coloca el icono de la ventana
		this.setSize(new Dimension(1088, 672));		//Se cambia el tamaño de la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		//El proceso se termina cuando se cierra la ventana
		
		
		
		
		
	}
	public JPanel loadMap(JPanel mapPanel) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Map.dat"));
			
			mapGrid = (HashMap)ois.readObject();
			
			ois.close();
			Set<Point> keys = mapGrid.keySet();
			mapPanel.removeAll();
			JLabel jl = new JLabel();
			for (Point i : keys) {
				jl = (JLabel) mapGrid.get(i).get(0).get(0);
				mapPanel.add(jl);
				
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return mapPanel;
	}
	
	
	

	
	
	
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
