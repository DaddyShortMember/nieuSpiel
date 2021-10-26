package gamePackage;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;


public class Game extends JFrame{
	
	public static void main(String[] args) throws IOException{
		Game juego = new Game();
		juego.setVisible(true);

	}
	public static int movimiento = 16;
	
	@SuppressWarnings("deprecation")
	public Game() throws IOException{
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		JLayeredPane layeredGamePanel = new JLayeredPane();
		//for testing
		//layeredGamePanel.setBackground(Color.green);
		layeredGamePanel.setBounds(0, 0, 544, 544);
		layeredGamePanel.setPreferredSize(new Dimension(544, 544));
		
		JLabel mapLabel = new JLabel();
		
		JLabel troopLabel1 = new JLabel();
		
		try {
		    BufferedImage map1 = ImageIO.read(new File(getClass().getResource("map1.png").toURI()));
		    BufferedImage troop1 = ImageIO.read(new File(getClass().getResource("troop1.png").toURI()));
		    mapLabel.setIcon(new ImageIcon(map1));
		    
		    troopLabel1.setIcon(new ImageIcon(troop1));
		    
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		
		mapLabel.setPreferredSize(new Dimension(544, 544));
		
		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));
		mapPanel.add(mapLabel);
		mapPanel.setBounds(0, 0, 544, 544);
		mapPanel.setOpaque(false);
		
		troopLabel1.setPreferredSize(new Dimension(16, 16));
		troopLabel1.setBounds(movimiento*6, movimiento*7, 16, 16);
		
		JPanel entityPanel = new JPanel();
		entityPanel.setLayout(null);
		//entityPanel.setLayout(new BoxLayout(entityPanel, BoxLayout.X_AXIS));
		entityPanel.setBounds(0, 0, 544, 544);
		entityPanel.add(troopLabel1);
		
		entityPanel.setOpaque(false);
		
		layeredGamePanel.add(mapPanel, new Integer(0), 0);
		layeredGamePanel.add(entityPanel, new Integer(1), 0);
		
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				try {
					while(!Thread.interrupted()) {
						Point mouse = MouseInfo.getPointerInfo().getLocation();
						SwingUtilities.convertPointFromScreen(mouse, cp);
						System.out.println(mouse);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					
				}
			}
		});
		
		hilo.start();
		
		
		
		
		JPanel derecha = new JPanel();
		derecha.setPreferredSize(new Dimension(336, 544));
		derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
		
		JPanel info = new JPanel();
		//for testing
		info.setBackground(Color.black);
		info.setPreferredSize(new Dimension(336, 336));
		
		JPanel abajo = new JPanel();
		abajo.setLayout(new BoxLayout(abajo, BoxLayout.X_AXIS));
		
		JPanel troopInfo = new JPanel();
		//for testing
		troopInfo.setBackground(Color.white);
		troopInfo.setPreferredSize(new Dimension(128, 208));
		
		JPanel movData = new JPanel();
		//for testing
		movData.setBackground(Color.yellow);
		movData.setPreferredSize(new Dimension(208, 208));
		
		abajo.add(troopInfo);
		abajo.add(movData);
		
		derecha.add(info);
		derecha.add(abajo);
		
		
		
		
		
		//layeredGamePanel.add(mapPanel);
		//layeredGamePanel.add(troopLabel1);
		
		
		
		cp.add(layeredGamePanel);
		cp.add(derecha);
		
		
		
		
		this.setTitle("B.A.S.E.D Tactics");
		this.setSize(new Dimension(880, 544));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		/*
		What the fuck even is this
		
		JLabel picLabel = null;
		try {
			picLabel = new JLabel(new ImageIcon( layeredGamePanel.class.getResource("img/unknown.png").toURI().toURL() ));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		derecha.add(picLabel);
		*/
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
