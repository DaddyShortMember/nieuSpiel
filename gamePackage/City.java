package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class City extends Estructura{
	
	public City() {
		super();
		this.suministraA = ListaTipos.INFANTERIA;
		this.idTerreno = IdentidadTerreno.CITY;
		this.nombre = "Ciudad";
		this.construibleSobre = false;
		this.peaje = 0; //Si tiene peaje, culpar a Rodrigo por no incluirlo en la lista.
		this.defensa = 2;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		this.cuartelGeneral = false;
		this.construible = false;
		this.capturable = true;
		this.fabrica = false;
		this.visibleEncontrado = true;
		this.ingresos = 1000;
	}

}
