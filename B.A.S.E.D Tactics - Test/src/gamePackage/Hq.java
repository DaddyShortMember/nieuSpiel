package gamePackage;

import clasesEntidades.Terreno.IdentidadTerreno;

public class Hq extends Estructura{
	
	public Hq() {
		super();
		this.suministraA = ListaTipos.INFANTERIA;
		this.idTerreno = IdentidadTerreno.HQ;
		this.nombre = "Cuarteles Generales";
		this.construibleSobre = false;
		this.peaje = 0; //Si tiene peaje, culpar a Rodrigo por no incluirlo en la lista.
		this.defensa = 4;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		this.cuartelGeneral = true;
		this.construible = false;
		this.capturable = true;
		this.fabrica = true;
		this.visibleEncontrado = true;
		this.ingresos = 1000;
	}

}
