package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Coast extends Terreno{
	
	public Coast() {
		super();
		this.idTerreno = IdentidadTerreno.COAST;
		this.nombre = "Costa";
		this.construibleSobre = true;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
