package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Bridge extends Terreno{
	
	public Bridge() {
		super();
		this.idTerreno = IdentidadTerreno.BRIDGE;
		this.nombre = "Puente";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
