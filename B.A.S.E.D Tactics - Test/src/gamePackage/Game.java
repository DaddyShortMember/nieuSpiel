package gamePackage;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class Game extends JFrame{
	
	public static void main(String[] args){
		Game juego = new Game();
		juego.pack();
		juego.setLocationRelativeTo(null);
		juego.setResizable(false);
		juego.setVisible(true);

	}
	//public static int tiles = 17;
	public static int mov = 32;
	
	@SuppressWarnings("deprecation")
	public Game() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		JLayeredPane layeredGamePanel = new JLayeredPane();
		//for testing
		//layeredGamePanel.setBackground(Color.green);
		layeredGamePanel.setBounds(0, 0, 672, 672);
		layeredGamePanel.setPreferredSize(new Dimension(672, 672));
		
		JLabel mapLabel = new JLabel();
		
		JLabel troopLabel1 = new JLabel();
		
		JLabel cursor = new JLabel();
		
		mapLabel.setIcon(new ImageIcon(getClass().getResource("img/mapa1.png")));
		troopLabel1.setIcon(new ImageIcon(getClass().getResource("img/inft.png")));
		cursor.setIcon(new ImageIcon(getClass().getResource("img/Cursor1.png")));
		
		mapLabel.setPreferredSize(new Dimension(672, 672));
		
		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));
		mapPanel.add(mapLabel);
		mapPanel.setBounds(0, 0, 672, 672);
		mapPanel.setOpaque(false);
		
		troopLabel1.setPreferredSize(new Dimension(32, 32));
		troopLabel1.setBounds(mov*6, mov*7, 32, 32);
		
		cursor.setPreferredSize(new Dimension(32, 32));
		cursor.setBounds(mov*8, mov*8, 32, 32);
		
		JLayeredPane entityPanel = new JLayeredPane();
		entityPanel.setLayout(null);
		entityPanel.setBounds(0, 0, 672, 672);
		entityPanel.add(troopLabel1, new Integer(0), 0);
		entityPanel.add(cursor, new Integer(1), 0);
		
		entityPanel.setOpaque(false);
		
		layeredGamePanel.add(mapPanel, new Integer(0), 0);
		layeredGamePanel.add(entityPanel, new Integer(1), 0);
		
		
		
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
		
		
		
		//KeyListeners
		KeyListener kListener = new KeyListener() {
			boolean released = true;
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
				if (key == KeyEvent.VK_LEFT && x > 0) {
					cursor.setLocation(x - mov, y);
			        //System.out.println("left");
			        released = false;
			    }

			    if (key == KeyEvent.VK_RIGHT && x < 640) {
			    	cursor.setLocation(x + mov, y);
			    	//System.out.println("right");
			    	released = false;
			    }

			    if (key == KeyEvent.VK_UP && y > 0) {
			    	cursor.setLocation(x, y - mov);
			    	//System.out.println("up");
			    	released = false;
			    }

			    if (key == KeyEvent.VK_DOWN && y < 640) {
			    	cursor.setLocation(x, y + mov);
			    	//System.out.println("down");
			    	released = false;
			    }
			}
		};
		
		
		
		
		JPanel derecha = new JPanel();
		derecha.setPreferredSize(new Dimension(416, 672));
		derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
		
		JPanel info = new JPanel();
		//for testing
		info.setBackground(Color.black);
		info.setPreferredSize(new Dimension(416, 416));
		
		JPanel abajo = new JPanel();
		abajo.setLayout(new BoxLayout(abajo, BoxLayout.X_AXIS));
		
		JPanel troopInfo = new JPanel();
		//for testing
		troopInfo.setBackground(Color.white);
		troopInfo.setPreferredSize(new Dimension(256, 256));
		
		JPanel movData = new JPanel();
		//for testing
		movData.setBackground(Color.yellow);
		movData.setPreferredSize(new Dimension(160, 256));
		
		abajo.add(troopInfo);
		abajo.add(movData);
		
		derecha.add(info);
		derecha.add(abajo);
		
		cp.add(layeredGamePanel);
		cp.add(derecha);
		
		//int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		//int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		
		this.pack();
		addKeyListener(kListener);
		this.setTitle("B.A.S.E.D Tactics");
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());
		this.setSize(new Dimension(1088, 672));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		
		
	}
	
}

//TODO list
/*
·troop position management
·object-label relation

Options:
·label position == object (x, y) values ---> juegosetLocation(troop.getPosition()=


 
 */
