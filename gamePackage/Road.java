package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Road extends Terreno{
	
	public Road() {
		this.idTerreno = IdentidadTerreno.ROAD;
		this.nombre = "Carretera";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
