package jClasses;

import jClasses.Tropa.Armamento;
import jClasses.Tropa.TipoMov;
import jClasses.Tropa.TipoTropa;

public abstract class Infanteria extends Tropa {

	public Infanteria() {
		super();
		this.nombre = "";
		this.tipoTropa = TipoTropa.INFANTERIA;
		this.tipoMov = TipoMov.INFANTERIA;
		this.captura = true;
		this.salud = 0;
		this.golpe = 0;
		this.armadura = 0;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcance = 0;
		this.municionesPrim = 0;
		this.energiaMaxima = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

}
