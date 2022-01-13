package gamePackage.ventanas;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.logging.Logger;
import javax.swing.*;

import gamePackage.sonidos.SoundMngr;
import gamePackage.baseDatos.DataBase;
import gamePackage.entidades.*;
import gamePackage.logica.*;
import gamePackage.entidades.terrestres.*;
import gamePackage.terrenos.*;
import gamePackage.terrenos.estructuras.*;
import gamePackage.terrenos.terrenos.*;




@SuppressWarnings("serial")
public class Game extends JFrame{
	
	public static void main(String[] args){
		//creaciÃ³n de la instancia de la ventana y modificacion de algunos de sus atributos para que sea visible 
		Game juego = new Game("BeanIsland");
		juego.pack();
		juego.setLocationRelativeTo(null);
		juego.setResizable(false);
		juego.setVisible(true);
		Logger logger = Logger.getLogger(Game.class.getName());

	}
	//public static int tiles = 17;  <-- Viejo tamaÃ±o de las casillas
	public static int mov = 32;		//TamaÃ±o de las casillas y valor por el que se multiplica el valor de x e y de los labels
	public volatile HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid = new HashMap<>();
	public int turn = 1;
	public boolean estadoMov = false;
	Point ogPos = new Point();
	Player p1 = new Player(1);
	Player p2 = new Player(2);
	SoundMngr sic = new SoundMngr("combat1.wav",0,0);
	Thread mus = new Thread(sic);
	
	
	public Game(String nomMapa) {
		mus.start();
		p1.setfunds(1000);
		DataBase dataBase = new DataBase();
		dataBase.getConn();
		p2.setfunds(1000);
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al contenedor de la ventana en el eje X que coloca los componentes en serie horizontalmente
		JLayeredPane layeredGamePanel = new JLayeredPane();		//CreaciÃ³n de un panel que permite colocar unos componentes por encima de otros
		//layeredGamePanel.setBackground(Color.green);		//for testing
		layeredGamePanel.setBounds(0, 0, 672, 672);		//PosiciÃ³n y tamaÃ±o del panel del juego
		layeredGamePanel.setPreferredSize(new Dimension(672, 672));		//TamaÃ±o preferido para el panel que hace que alguna instrucciÃ³n no ignore este valor
		
		JLabel cursor = new JLabel();		//Label que contiene el cursor
		
		//Instrucciones para colocar las imagenes en los labels
		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor.gif")));
		
		//mapLabel.setPreferredSize(new Dimension(672, 672));		//De nuevo se coloca el tamaÃ±o preferido para que las instrucciones tiendan a usar este valor
		
		JPanel mapPanel = new JPanel();		//CreaciÃ³n del panel en el que estÃ¡ el label del mapa (mÃ¡s tarde serÃ¡n muchos componentes que forman un mapa)
		mapPanel.setLayout(null);		//Se le pone un BoxLayout al panel del mapa en el eje X que coloca los componentes en serie horizontalmente
		//mapPanel.add(mapLabel);		//AÃ±adir el label que contiene el mapa
		mapPanel.setBounds(0, 0, 672, 672);		//PosiciÃ³n y tamaÃ±o del panel del mapa
		//mapPanel.setOpaque(true);		//Hace que se pueda ver lo que haya detrÃ¡s del panel
		
		JPanel troopPanel = new JPanel();
		troopPanel.setLayout(null);
		troopPanel.setBounds(0, 1, 672, 672);
		troopPanel.setOpaque(false);
		
		//-------------------------------------------------------------------------
		

		
		
		//-------------------------------------------------------------------------
		
		/*
		ArrayList<ListaIDTerreno> buildings = new ArrayList<>(); buildings.add(ListaIDTerreno.CITY);buildings.add(ListaIDTerreno.FACTORY);buildings.add(ListaIDTerreno.HQ);
		int building1 = 0;
		int building2 = 0;
		int building3 = 0;
		int building4 = 0;
		for (Point p : mapGrid.keySet()) {
			try {
				Estructura struc = (Estructura) mapGrid.get(p).get(0).get(1);
				if (buildings.contains(struc.getIDTerreno())) {
					switch (struc.getTeam()) {
					case 1: 
						building1+=1;
						break;
					case 2:
						building2+=1;
						break;
					case 3:
						building3+=1;
						break;
					case 4:
						building4+=1;
						break;
					default:
						break;
					}
				}
			} catch (Exception e) {
				
			}
			//System.out.println(building1 + "-" + building2);	
		}
		*/
		

		cursor.setPreferredSize(new Dimension(32, 32));		//TamaÃ±o preferido del label que contiene el gif del cursor
		cursor.setBounds(mov*8, mov*8, 32, 32);		//Lo mismo de antes pero siendo la posiciÃ³n el centro del mapa
		
		JLayeredPane entityPanel = new JLayeredPane();		//CreaciÃ³n del panel que contiene las entidades como tropas o edificios
		entityPanel.setLayout(null);		//Se le pone layout nulo para que deje poner componentes mediante posiciones absolutas
		entityPanel.setBounds(0, 0, 672, 672);		//PosiciÃ³n y tamaÃ±o del panel de entidades
		entityPanel.add(cursor, 2, 0);		//Se aÃ±ade el label del cursor con una prioridad mayor que hace que estÃ© sobre las tropas y entidades
		entityPanel.add(troopPanel, 1, 0);
		entityPanel.setOpaque(false);		//Se cambia el atributo del panel para hacer que se pueda ver lo que tiene debajo (otro panel)
		
		layeredGamePanel.add(mapPanel, 0, 0);		//Se aÃ±ade el panel que contiene el mapa con prioridad baja para que estÃ© por debajo del resto de cosas que se aÃ±adan
		layeredGamePanel.add(entityPanel, 1, 0);		//Se aÃ±ade el panel de entidades con mayor prioridad que el del mapa para que se vean por encima de este
		
		class ThreadMV implements Runnable{
			volatile boolean stateSwitcher = false;
			volatile boolean on = true;
			@Override
			public void run() {
				mapGrid = loadMap();
				Tropa t = (Tropa) mapGrid.get(ogPos).get(1).get(1);
				Point pos = ogPos;
				while (on) {
					while(stateSwitcher == true) {
						System.out.println("Thread de Mov");
						Point mouse = MouseInfo.getPointerInfo().getLocation();
						SwingUtilities.convertPointFromScreen(mouse, layeredGamePanel);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						double x = mouse.getX();
						double y = mouse.getY();
						x = x / mov; y = y / mov;
						x = Math.floor(x); y = Math.floor(y);
						Point cN = new Point((int)pos.getX(), (int)pos.getY()-1);
						Point cS = new Point((int)pos.getX(), (int)pos.getY()+1);
						Point cE = new Point((int)pos.getX()+1, (int)pos.getY());
						Point cO = new Point((int)pos.getX()-1, (int)pos.getY());
						int peajeN = ((Terreno) mapGrid.get(cN).get(0).get(1)).getPeaje(t);
						int peajeS = ((Terreno) mapGrid.get(cS).get(0).get(1)).getPeaje(t);
						int peajeE = ((Terreno) mapGrid.get(cE).get(0).get(1)).getPeaje(t);
						int peajeO = ((Terreno) mapGrid.get(cO).get(0).get(1)).getPeaje(t);
						if (((t.getDistMax()-peajeN)>=0) && (t.getEnergia() != 0) && (mapGrid.get(cN).size() == 1) && (mouse.equals(cN))) {
							cursor.setLocation(cN);
						} else if (((t.getDistMax()-peajeS)>=0) && (t.getEnergia() != 0) && (mapGrid.get(cS).size() == 1) && (mouse.equals(cS))) {
							cursor.setLocation(cS);
						} else if (((t.getDistMax()-peajeE)>=0) && (t.getEnergia() != 0) && (mapGrid.get(cE).size() == 1) && (mouse.equals(cE))) {
							cursor.setLocation(cE);
						} else if (((t.getDistMax()-peajeO)>=0) && (t.getEnergia() != 0) && (mapGrid.get(cO).size() == 1) && (mouse.equals(cO))) {
							cursor.setLocation(cO);
						}
						if (x>= 0 && x <= 21 && y>= 0 && y <= 21) {
							int xCT = (int) (x * mov); int yCT = (int) (y * mov); //xCT = x Cursor Tile 
							cursor.setLocation(xCT, yCT);
						}
						
					}
				}
			}
			public void pause() {
				stateSwitcher = false;
			}
			
			public void resume() {
				stateSwitcher = true;
			}
			

			
		}

		ThreadMV mv = new ThreadMV();
		Thread tMV = new Thread(mv);
		
		
		class CursorMovement implements Runnable{
			volatile boolean stateSwitcher = false;
			volatile boolean on = true;
			@Override
			public void run() {
				while (on) {
					while(stateSwitcher == true) {
						System.out.println("Thread de cursor general");
						Point mouse = MouseInfo.getPointerInfo().getLocation();
						SwingUtilities.convertPointFromScreen(mouse, layeredGamePanel);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						double x = mouse.getX();
						double y = mouse.getY();
						x = x / mov; y = y / mov;
						x = Math.floor(x); y = Math.floor(y);
						if (x>= 0 && x <= 21 && y>= 0 && y <= 21) {
							int xCT = (int) (x * mov); int yCT = (int) (y * mov); //xCT = x Cursor Tile 
							cursor.setLocation(xCT, yCT);
						}
					}
				}
			}
			public void pause() {
				stateSwitcher = false;
			}
			
			public void resume() {
				stateSwitcher = true;
			}
			

			
		}

		CursorMovement cm = new CursorMovement();
		Thread tCM = new Thread(cm);
		tCM.start();
		
		//----------------------------------
		
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomMapa + ".dat"));
			
			mapGrid = (HashMap) ois.readObject();
			//System.out.println("ini");
			//System.out.println(mapGrid.get(new Point(0,0)).get(0).get(0));
			//System.out.println("fin");

			ois.close();

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
		
		//System.out.println(mapGrid);
		mapPanel.removeAll();
		
		Set<Point> keys = mapGrid.keySet();
		JLabel jl = new JLabel();
		for (Point i : keys) {
			jl = (JLabel) mapGrid.get(i).get(0).get(0);
			mapPanel.add(jl);
		}
		
		
		mapPanel.repaint();
		
		//----------------------------------
		
		MouseListener ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Point casilla = new Point((int) cursor.getX()/32, (int) cursor.getY()/32);
				
				int teamTester;
				switch (turn%2) {
				case 0:
					teamTester = 2;
					break;
				default:
					teamTester = 1;
					break;
				}
				if (mapGrid.get(casilla).size() == 2) {
					if (estadoMov == false) {
						if (((Tropa) mapGrid.get(casilla).get(1).get(1)).getTeam() == teamTester) {
								estadoMov = true;
								ogPos = casilla;
								if (tMV.isAlive()) {
									mv.resume();
								} else {
									tMV.start();
									mv.resume();
								}
						} 
						
				
					}
				 else {
					moverTropa(cursor.getLocation(), mapGrid, layeredGamePanel, troopPanel, turn, casilla, ogPos);
					mv.pause();
					cm.resume();
					estadoMov = false;
				 }
				} else if (!(((Terreno) mapGrid.get(casilla).get(0).get(1)).getIDTerreno() != ListaIDTerreno.FACTORY || mapGrid.get(casilla).size() == 2)) {
					if (((Factory) mapGrid.get(casilla).get(0).get(1)).getTeam() == teamTester) {
						createTropa(cursor.getLocation(), mapGrid, layeredGamePanel, troopPanel, turn, casilla);
						} 
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!estadoMov) {
					cm.resume();
				}
				
				
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
				System.out.println("fuck");
				int x = cursor.getLocation().x;
				int y = cursor.getLocation().y;
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT && x > 0 && released) {
					cursor.setLocation(x - mov, y);
			        //System.out.println("left");
					//released = false;		//quitar el comentario del inicio de esta linea para dar uso a la variable released
			    }

			    if (key == KeyEvent.VK_RIGHT && x < 640) {
			    	cursor.setLocation(x + mov, y);
			    	//System.out.println("right");
			    	//released = false;
			    }

			    if (key == KeyEvent.VK_UP && y > 0) {
			    	cursor.setLocation(x, y - mov);
			    	//System.out.println("up");
			    	//released = false;
			    }

			    if (key == KeyEvent.VK_DOWN && y < 640) {
			    	cursor.setLocation(x, y + mov);
			    	//System.out.println("down");
			    	//released = false;
			    }
			    
			    if (key == KeyEvent.VK_SPACE) {
			    	
			    }
			}
		};
		
		
		
		
		JPanel derecha = new JPanel();		//CreaciÃ³n del panel de la derecha que contiene otros paneles que mostrarÃ¡n la informaciÃ³n de tropas y terrenos
		derecha.setPreferredSize(new Dimension(416, 672));		//Se define el tamaÃ±o preferido del panel
		derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));		//Se le pone un BoxLayout en el eje Y que coloca los componentes en serie verticalmente
		
		JPanel info = new JPanel();		//CreaciÃ³n del panel superior de informaciÃ³n general de la partida
		info.setBackground(Color.black);		//InstrucciÃ³n de prueba para diferenciar los paneles mientras no estÃ©n programados
		info.setPreferredSize(new Dimension(416, 416));		//TamaÃ±o preferido del panel de informaciÃ³n general
		
		JPanel abajo = new JPanel();		//CreaciÃ³n del panel inferior de la seccion de informaciÃ³n (parte derecha de la pantalla)
		abajo.setLayout(new BoxLayout(abajo, BoxLayout.X_AXIS));		//Sele pone un BoxLayout en el eje Y que coloca los componentes en serie horizontalmente
		
		JPanel movData = new JPanel();		//CreaciÃ³n del panel inferior con informaciÃ³n de movimiento
		movData.setBackground(Color.yellow);		//InstrucciÃ³n de prueba para diferenciar los paneles mientras no estÃ©n programados
		movData.setPreferredSize(new Dimension(160, 256));		//TamaÃ±o preferido del panel de informaciÃ³n de tropas
		//movData.setLayout(new BoxLayout(movData, BoxLayout.Y_AXIS));
		
		JPanel troopInfo = new JPanel();		//CreaciÃ³n del panel inferior con informaciÃ³n de tropas
		troopInfo.setBackground(Color.white);		//InstrucciÃ³n de prueba para diferenciar los paneles mientras no estÃ©n programados
		troopInfo.setPreferredSize(new Dimension(256, 256));		//TamaÃ±o preferido del panel de informaciÃ³n de tropas
		//troopInfo.setLayout(new BoxLayout(troopInfo, BoxLayout.X_AXIS));
		
		
		//Labels de los atributos del panel info
		/*
		JLabel troopNum = new JLabel();
		JLabel buildingNum = new JLabel();
		JLabel gold = new JLabel();
		
		info.add(troopNum);
		info.add(buildingNum);
		info.add(gold);
		*/
		
		//Labels de los atributos del panel movData
		
		JButton move = new JButton("MOVER");
		JButton attack = new JButton("ATACAR");
		JButton capture = new JButton("CAPTURAR");
		JButton turnEnd = new JButton("TERMINAR TURNO");
		
		movData.add(move);
		movData.add(attack);
		movData.add(capture);
		movData.add(turnEnd);
		
		turnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				terminaTurno(turn, mapPanel, mapGrid);
				System.out.println(turn);
				dataBase.actualizaTEquipos(p1.getfunds(),0,p2.getfunds(),0);
			}
		});
		
		//Labels de los atributos del panel troopInfo
		/*
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
		*/
		
		abajo.add(movData);			//Se aÃ±ade el panel de informaciÃ³n de movimiento al panel que contiene toda la parte inferior
		abajo.add(troopInfo);		//Se aÃ±ade el panel de informaciÃ³n de tropas al panel que contiene toda la parte inferior
		
		derecha.add(info);		//Se aÃ±ade el panel superior que contiene informaciÃ³n general de la partida al panel que contiene toda la parte derecha (informacion)
		derecha.add(abajo);		//Se aÃ±ade el panel inferior que contiene los paneles movData y troopInfo al panel que contiene toda la parte derecha (informacion)
		
		cp.add(layeredGamePanel);		//Se aÃ±ade el panel del juego al contenedor de la ventana
		cp.add(derecha);		//Se aÃ±ade el panel de la derecha (informaciÃ³n) al contenedor de la ventana
		
		//redundant in newer versions
		//int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		//int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		
		this.pack();		//Se asegura de que todos los componentes estÃ¡n por lo menos a su tamaÃ±o preferido
		addKeyListener(kListener);		//Se aÃ±ade el KeyListener a la ventana
		addMouseListener(ml);
		this.setTitle("B.A.S.E.D Tactics");		//Se cambia el titulo de la ventana
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());		//Coloca el icono de la ventana
		this.setSize(new Dimension(1088, 672));		//Se cambia el tamaÃ±o de la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		//El proceso se termina cuando se cierra la ventana
		
		
		
		
		}
	/*
	public HashMap<Point, ArrayList<ArrayList<Object>>> loadHashMap() {
		HashMap<Point, ArrayList<ArrayList<Object>>> mapGridFunc = new HashMap<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BeanIsland.dat"));
			
			mapGridFunc = (HashMap) ois.readObject();
			System.out.println("fuck");
			System.out.println(mapGridFunc.get(new Point(0,0)).get(0).get(0));
			System.out.println("endFuck");

			ois.close();

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
		System.out.println(mapGridFunc);
		return mapGridFunc;
	}
	
	public JPanel loadMap(JPanel mapPanel, HashMap<Point, ArrayList<ArrayList<Object>>> mapGridFunc2) {
			Set<Point> keys = mapGridFunc2.keySet();
			mapPanel.removeAll();
			JLabel jl = new JLabel();
			for (Point i : keys) {
				jl = (JLabel) mapGridFunc2.get(i).get(0).get(0);
				mapPanel.add(jl);
			}

		return mapPanel;
	}
	
	*/
	
	public void mover(HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid, Point pos) {
		
	}
	
	public int income(int count) {
		return count*1000;
	}
	
	public int buildCount(int team, JPanel mapPanel, HashMap<Point, ArrayList<ArrayList<Object>>> mapGridFunc3) {
			mapPanel.repaint();
			ArrayList<ListaIDTerreno> buildings = new ArrayList<>(); buildings.add(ListaIDTerreno.CITY);buildings.add(ListaIDTerreno.FACTORY);buildings.add(ListaIDTerreno.HQ);
			int building1 = 0;
			int building2 = 0;
			int building3 = 0;
			int building4 = 0;
			for (Point p : mapGridFunc3.keySet()) {
				try {
					Estructura struc = (Estructura) mapGridFunc3.get(p).get(0).get(1);
					if (buildings.contains(struc.getIDTerreno())) {
						switch (struc.getTeam()) {
						case 1: 
							building1+=1;
							break;
						case 2:
							building2+=1;
							break;
						case 3:
							building3+=1;
							break;
						default:
							building4+=1;
							break;
						}
					}
				} catch (Exception e) {
					
				}
			}
			//System.out.println(building1 + "-" + building2);	
			switch (team) {
			case 1:
				return building1;
			case 2:
				return building2;
			case 3:
				return building3;
			default:
				return building4;
			}
		
	}
	
	public void terminaTurno(int team, JPanel mapPanel, HashMap<Point, ArrayList<ArrayList<Object>>> mapGridFunc3) {
		int teamSetter;
		switch (turn % 2) {
		case 0:
			teamSetter = 2;
			break;
		default:
			teamSetter = 1;
			break;
		}
		int buildings = buildCount(teamSetter, mapPanel, mapGridFunc3);
		int cashout = income(buildings);
		switch (teamSetter) {
		case 1:
			p1.setfunds(cashout);
			this.turn++;
			sic.changeSound("combat2.wav");
			mus.interrupt();
			mus.start();
			break;
		default:
			p2.setfunds(cashout);
			this.turn++;
			sic.changeSound("combat1.wav");
			mus.interrupt();
			mus.start();
			break;
		}
	}
	
	public void createTropa(Point pos, HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid, JLayeredPane lp, JPanel troopPanel, int turn, Point casilla) {
		JInternalFrame jif = new JInternalFrame();
		
		jif.pack();
		jif.setLocation(192, 160);
		jif.setResizable(false);
		jif.setVisible(true);
		Container jifCP = jif.getContentPane();
		JLabel jm = new JLabel();
		JButton infFoot = new JButton("1500");
		infFoot.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			infFoot.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/InftBLUE.png")));
			break;
		default:
			infFoot.setIcon(new ImageIcon(getClass().getResource("img/troop/red/InftRED.png")));
			break;
		}
		infFoot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfFoot tr = new InfFoot(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/InftBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/InftRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		JButton infMech = new JButton("2500");
		infMech.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			infMech.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/MecBLUE.png")));
			break;
		default:
			infMech.setIcon(new ImageIcon(getClass().getResource("img/troop/red/MecRED.png")));
			break;
		}
		infMech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfMech tr = new InfMech(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/MecBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/MecRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton infBike = new JButton("2500");
		infBike.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			infBike.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/BikeBLUE.png")));
			break;
		default:
			infBike.setIcon(new ImageIcon(getClass().getResource("img/troop/red/BikeRED.png")));
			break;
		}
		infBike.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfBike tr = new InfBike(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/BikeBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/BikeRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton rocl = new JButton("15000");
		rocl.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			rocl.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/RocketBLUE.png")));
			break;
		default:
			rocl.setIcon(new ImageIcon(getClass().getResource("img/troop/red/RocketRED.png")));
			break;
		}
		rocl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Rocl tr = new Rocl(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/RocketBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/RocketRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton antiA = new JButton("8000");
		antiA.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			antiA.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/AaBLUE.png")));
			break;
		default:
			antiA.setIcon(new ImageIcon(getClass().getResource("img/troop/red/AaRED.png")));
			break;
		}
		antiA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AntiA tr = new AntiA(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/AaBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/AaRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton vAPC = new JButton("5000");
		vAPC.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			vAPC.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ToaBLUE.png")));
			break;
		default:
			vAPC.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ToaRED.png")));
			break;
		}
		vAPC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VApc tr = new VApc(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ToaBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ToaRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton arty = new JButton("6000");
		arty.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			arty.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ArtilleryBLUE.png")));
			break;
		default:
			arty.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ArtilleryRED.png")));
			break;
		}
		arty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Arty tr = new Arty(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ArtilleryBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ArtilleryRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton tankL = new JButton("6000");
		tankL.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			tankL.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/LTankBLUE.png")));
			break;
		default:
			tankL.setIcon(new ImageIcon(getClass().getResource("img/troop/red/LTankRED.png")));
			break;
		}
		tankL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TankL tr = new TankL(0);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/LTankBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/LTankRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton tankM = new JButton("12000");
		tankM.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			tankM.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/MTankBLUE.png")));
			break;
		default:
			tankM.setIcon(new ImageIcon(getClass().getResource("img/troop/red/MTankRED.png")));
			break;
		}
		tankM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TankM tr = new TankM(2);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/MTankBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/MTankRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		JButton tankH = new JButton("16000");
		tankH.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			tankH.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/HTankBLUE.png")));
			break;
		default:
			tankH.setIcon(new ImageIcon(getClass().getResource("img/troop/red/HTankRED.png")));
			break;
		}
		tankH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TankH tr = new TankH(1);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/HTankBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/HTankRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
		
		
		
		JButton vRecon = new JButton("4000");
		vRecon.setVerticalTextPosition(JButton.BOTTOM);
		switch (turn%2) {
		case 0:
			vRecon.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ReconBLUE.png")));
			break;
		default:
			vRecon.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ReconRED.png")));
			break;
		}
		vRecon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VRecon tr = new VRecon(1);
				switch (turn%2){
					case 0:
						tr.setTeam(1);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/blue/ReconBLUE.png")));
						break;
					default:
						tr.setTeam(2);
						jm.setIcon(new ImageIcon(getClass().getResource("img/troop/red/ReconRED.png")));
						break;
				}		
				ArrayList<Object> troopsList = new ArrayList<>();
				jm.setBounds((int) pos.getX(), (int) pos.getY(), 32, 32);
				troopsList.add(jm);
				troopsList.add(tr);
				mapGrid.get(casilla).add(troopsList);
				troopPanel.add(jm);
				jif.dispose();
			}
		});
				
		jifCP.setLayout(new GridLayout(4, 3));
		
		jifCP.add(infFoot);
		jifCP.add(infMech);
		jifCP.add(infBike);
		jifCP.add(vRecon);
		jifCP.add(antiA);
		jifCP.add(arty);
		jifCP.add(rocl);
		jifCP.add(tankL);
		jifCP.add(tankM);
		jifCP.add(tankH);
		jifCP.add(vAPC);
		
		jif.pack();		//Se asegura de que todos los componentes estÃ¡n por lo menos a su tamaÃ±o preferido
		jif.setSize(new Dimension(336, 336));		//Se cambia el tamaÃ±o de la ventana
		lp.add(jif, 4, 0);
	}
	
	public synchronized HashMap<Point, ArrayList<ArrayList<Object>>> reloadHMap(){
		return this.mapGrid;
	}
	
	public void moverTropa(Point pos, HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid, JLayeredPane lp, JPanel troopPanel, int turn, Point casilla, Point og) {
		Tropa t = (Tropa) mapGrid.get(og).get(1).get(1);
		JLabel tl = (JLabel) mapGrid.get(og).get(1).get(0);
		ArrayList<Object> al = new ArrayList<>();
		al.add(t); al.add(tl);
		mapGrid.get(og).remove(1);
		mapGrid.get(casilla).add(al);
		troopPanel.repaint();
	}
	
	public HashMap<Point, ArrayList<ArrayList<Object>>> loadMap() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BeanIsland.dat"));

			mapGrid = (HashMap) ois.readObject();

			ois.close();

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

		return mapGrid;
	}
	
}

/*	
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
	
*/	
	
	


//TODO list
/*
Â·Panel de informaciÃ³n para quien quiera hacerlo
 
Â·Methods (...)
Â·Graph:
	-node positions relative to map
	-positions in map relative to troop



Problems:
·detecting things that are on top of eachother
·movement -> graph detecting what the troop can be on top of and calculate where it cant reach anymore
·








 
 */
