package gamePackage;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

import javax.swing.*;


@SuppressWarnings("serial")
public class Game extends JFrame{
	
	public static void main(String[] args){
		//creación de la instancia de la ventana y modificacion de algunos de sus atributos para que sea visible 
		Game juego = new Game();
		juego.pack();
		juego.setLocationRelativeTo(null);
		juego.setResizable(false);
		juego.setVisible(true);
		Logger logger = Logger.getLogger(Game.class.getName());
		System.out.println("vert: " + grafoVert(3));
		System.out.println("arist: " + grafoArist(3));
	}
	//public static int tiles = 17;  <-- Viejo tamaño de las casillas
	public static int mov = 32;		//Tamaño de las casillas y valor por el que se multiplica el valor de x e y de los labels
	
	
	public Game() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al contenedor de la ventana en el eje X que coloca los componentes en serie horizontalmente
		JLayeredPane layeredGamePanel = new JLayeredPane();		//Creación de un panel que permite colocar unos componentes por encima de otros
		//layeredGamePanel.setBackground(Color.green);		//for testing
		layeredGamePanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del juego
		layeredGamePanel.setPreferredSize(new Dimension(672, 672));		//Tamaño preferido para el panel que hace que alguna instrucción no ignore este valor
		
		JLabel mapLabel = new JLabel();		//Label temporal que contiene todo el mapa en una sola imagen
		
		JLabel troopLabel1 = new JLabel();		//Label de prueba que contiene una imagen de tropa
		
		JLabel cursor = new JLabel();		//Label que contiene el cursor
		
		//Instrucciones para colocar las imagenes en los labels
		mapLabel.setIcon(new ImageIcon(getClass().getResource("img/mapa1.png")));		
		troopLabel1.setIcon(new ImageIcon(getClass().getResource("img/inft.png")));
		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor.gif")));
		
		mapLabel.setPreferredSize(new Dimension(672, 672));		//De nuevo se coloca el tamaño preferido para que las instrucciones tiendan a usar este valor
		
		JPanel mapPanel = new JPanel();		//Creación del panel en el que está el label del mapa (más tarde serán muchos componentes que forman un mapa)
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));		//Se le pone un BoxLayout al panel del mapa en el eje X que coloca los componentes en serie horizontalmente
		mapPanel.add(mapLabel);		//Añadir el label que contiene el mapa
		mapPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel del mapa
		mapPanel.setOpaque(false);		//Hace que se pueda ver lo que haya detrás del panel
		
		troopLabel1.setPreferredSize(new Dimension(32, 32));		//Tamaño preferido del label que contiene la imagen de la tropa
		troopLabel1.setBounds(mov*6, mov*7, 32, 32);		//Posición y tamaño  del label siendo la posición la multiplicación del tamaño de las casillas por la casilla en la queremos que esté
		
		cursor.setPreferredSize(new Dimension(32, 32));		//Tamaño preferido del label que contiene el gif del cursor
		cursor.setBounds(mov*8, mov*8, 32, 32);		//Lo mismo de antes pero siendo la posición el centro del mapa
		
		JLayeredPane entityPanel = new JLayeredPane();		//Creación del panel que contiene las entidades como tropas o edificios
		entityPanel.setLayout(null);		//Se le pone layout nulo para que deje poner componentes mediante posiciones absolutas
		entityPanel.setBounds(0, 0, 672, 672);		//Posición y tamaño del panel de entidades
		entityPanel.add(troopLabel1, 0, 0);		//Se añade el label de una tropa con un valor que define su prioridad para presentarse por encima o por debajo de otro label
		entityPanel.add(cursor, 1, 0);		//Se añade el label del cursor con una prioridad mayor que hace que esté sobre las tropas y entidades
		
		entityPanel.setOpaque(false);		//Se cambia el atributo del panel para hacer que se pueda ver lo que tiene debajo (otro panel)
		
		layeredGamePanel.add(mapPanel, 0, 0);		//Se añade el panel que contiene el mapa con prioridad baja para que esté por debajo del resto de cosas que se añadan
		layeredGamePanel.add(entityPanel, 1, 0);		//Se añade el panel de entidades con mayor prioridad que el del mapa para que se vean por encima de este
		
		
		
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
		
		JPanel troopInfo = new JPanel();		//Creación del panel inferior con información de tropas
		troopInfo.setBackground(Color.white);		//Instrucción de prueba para diferenciar los paneles mientras no estén programados
		troopInfo.setPreferredSize(new Dimension(256, 256));		//Tamaño preferido del panel de información de tropas
		
		abajo.add(movData);			//Se añade el panel de información de movimiento al panel que contiene toda la parte inferior
		abajo.add(troopInfo);		//Se añade el panel de información de tropas al panel que contiene toda la parte inferior
		
		derecha.add(info);		//Se añade el panel superior que contiene información general de la partida al panel que contiene toda la parte derecha (informacion)
		derecha.add(abajo);		//Se añade el panel inferior que contiene los paneles movData y troopInfo al panel que contiene toda la parte derecha (informacion)
		
		cp.add(layeredGamePanel);		//Se añade el panel del juego al contenedor de la ventana
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
	
	
	
	
}

//TODO list
/*
·Panel de información para quien quiera hacerlo
 
·Methods (...)
·Graph:
	-node positions relative to map
	-positions in map relative to troop

 
 */
