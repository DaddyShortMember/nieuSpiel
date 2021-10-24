package jClasses;

import jClasses.Tropa.TipoMov;
import jClasses.Tropa.TipoTropa;

public abstract class Naval extends Tropa {
	
	public Naval() {
		super();
		this.nombre = "";
		this.tipoTropa = TipoTropa.MARINA;
		this.tipoMov = TipoMov.ACUATICO;
		this.captura = false;
		this.salud = 0;
		this.golpe = 0;
		this.armadura = 0;
		this.armaPrincipal = "";
		this.armaSecundaria = "";
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcance = 0;
		this.municionesPrim = 0;
		this.municionesSec = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
