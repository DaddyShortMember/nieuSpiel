package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Mountain extends Terreno{
	
	public Mountain() {
		super();
		this.idTerreno = IdentidadTerreno.MOUNTAIN;
		this.nombre = "Monte";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 4;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
