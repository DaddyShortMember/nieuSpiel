package jClasses;

import jClasses.Tropa.Armamento;
import jClasses.Tropa.TipoMov;
import jClasses.Tropa.TipoTropa;

public class Rifleman extends Tropa {
	
	public Rifleman() {
		super();
		this.nombre = "SOLDADO";
		this.tipoTropa = TipoTropa.INFANTERIA;
		this.tipoMov = TipoMov.INFANTERIA;
		this.captura = true;
		this.salud = 10;
		this.golpe = 10;
		this.armadura = 0;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 1500;
		this.nivel = 0;
		this.vision = 3;
		this.alcance = 1;
		this.municionesPrim = 0;
		this.energiaMaxima = 99;
		this.energia = 99;
		this.distanciaMaxima = 3;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";

	}
	
}
