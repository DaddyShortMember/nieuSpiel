package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Port extends Estructura{
	
	public Port() {
		super();
		this.suministraA = ListaTipos.ACUATICO;
		this.idTerreno = IdentidadTerreno.PORT;
		this.nombre = "Puerto Marino";
		this.construibleSobre = false;
		this.peaje = 0; //Si tiene peaje, culpar a Rodrigo por no incluirlo en la lista.
		this.defensa = 3;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		this.cuartelGeneral = false;
		this.construible = false;
		this.capturable = true;
		this.fabrica = true;
		this.visibleEncontrado = true;
		this.ingresos = 1000;
	}

}
