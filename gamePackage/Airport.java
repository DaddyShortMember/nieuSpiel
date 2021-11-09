package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class Airport extends Estructura{
	
	public Airport() {
		super();
		this.suministraA = ListaTipos.AEREO;
		this.idTerreno = IdentidadTerreno.AIRPORT;
		this.nombre = "Aeropuerto";
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
