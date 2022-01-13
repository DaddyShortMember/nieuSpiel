package gamePackage;

import gamePackage.ventanas.MainMenu;

public class Main {
	
	static MainMenu menu = new MainMenu();
	
	public static void main(String[] args) {
		
		menu.setLocationRelativeTo(null);
		menu.setResizable(false);
		menu.setVisible(true);
	}
	

}
