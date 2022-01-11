package gamePackage.logica;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
	private static Logger logPlayer = Logger.getLogger("Player");
	private int faction; // What team is player?
	private int funds = 0; // Moola, cash cash money quantity
	private int cityQ = 0; // Quantity of cities == cantidad de ciudades
	private int factoryQ = 0; // Quantity of cities == cantidad de ciudades

	public int getFaction() {
		return faction;
	}

	public void setFaction(int faction) {
		if (faction > 0 && faction < 5)
			this.faction = faction;
		else
			logPlayer.log(Level.SEVERE, "HOW DO YOU MESS UP THIS BADLY?");
	}

	public int getfunds() {
		return funds;
	}

	public void setfunds(int funds) {
		this.funds = funds;
	}

	public int getCityQ() {
		return cityQ;
	}

	public void setCityQ(int cityQ) {
		this.cityQ = cityQ;
	}

	public int getFactoryQ() {
		return factoryQ;
	}

	public void setFactoryQ(int factoryQ) {
		this.factoryQ = factoryQ;
	}

	public Player(int faction) {
		super();
		this.faction = faction;
	}

}
