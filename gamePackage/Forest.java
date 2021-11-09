package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Forest extends Terreno {
	
	public Forest() {
		super();
		this.idTerreno = IdentidadTerreno.FOREST;
		this.nombre = "Bosque";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 3;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
