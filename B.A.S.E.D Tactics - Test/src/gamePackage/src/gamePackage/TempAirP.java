package gamePackage;

import gamePackage.Terreno.IdentidadTerreno;

public class TempAirP extends Estructura{
	
	public TempAirP() {
		super();
		this.suministraA = ListaTipos.AEREO;
		this.idTerreno = IdentidadTerreno.TEMP_AIRP;
		this.nombre = "Pista de Aterrizaje";
		this.construibleSobre = false;
		this.peaje = 0; //Si tiene peaje, culpar a Rodrigo por no incluirlo en la lista.
		this.defensa = 1;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		this.cuartelGeneral = false;
		this.construible = true;
		this.capturable = true;
		this.fabrica = false;
		this.visibleEncontrado = true;
		this.ingresos = 0;
	}

}
