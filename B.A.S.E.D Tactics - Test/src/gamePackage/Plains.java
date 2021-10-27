package clasesEntidades;

import gamePackage.Terreno.IdentidadTerreno;

public class Plains extends Terreno {
	
	public Plains() {
		super();
		this.idTerreno = IdentidadTerreno.PLAINS;
		this.nombre = "Llano";
		this.construibleSobre = true;
		this.peaje = 1; //Implementar metodo. Trabajo de Rodrigo.
		this.defensa = 1;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
