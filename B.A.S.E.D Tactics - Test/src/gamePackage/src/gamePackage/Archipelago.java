package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Archipelago extends Terreno{
	
	public Archipelago() {
		super();
		this.idTerreno = IdentidadTerreno.ARCHIPELAGO;
		this.nombre = "Archipielago";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 2;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
