package gamePackage.ventanas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends JFrame{
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.setLocationRelativeTo(null);
		menu.setResizable(false);
		menu.setVisible(true);
	}
	public MainMenu() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		JLayeredPane layeredMenuPanel = new JLayeredPane();
		layeredMenuPanel.setBackground(Color.green);
		
		//JLabel filter, playSingle, playMulti, settings, exit = new JLabel();
		JLabel background = new JLabel();
		JLabel title = new JLabel();
		JLabel playSingle = new JLabel();
		//JLabel playMulti = new JLabel();
		JLabel settings = new JLabel();
		JLabel exit = new JLabel();
		
		background.setBackground(Color.magenta);
		title.setBackground(Color.cyan);
		playSingle.setBackground(Color.yellow);
		
		
		//background.setIcon(new ImageIcon(getClass().getResource("img/mapa1.png")));
		
		
		this.setTitle("B.A.S.E.D Tactics");
		this.setIconImage(new ImageIcon(getClass().getResource("img/tankicon.png")).getImage());
		this.setSize(new Dimension(1088, 672));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void exitProgram() {
		System.exit(0);
	}
}

