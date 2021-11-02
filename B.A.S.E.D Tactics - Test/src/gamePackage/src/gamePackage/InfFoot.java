package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class InfFoot extends Infanteria {
	
public InfFoot() {
		super();
		this.nombre = "Infanteria";
		this.captura = true;
		this.construye = false;
		this.salud = 100;
		this.golpeSec = 0;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 1500;
		this.nivel = 0;
		this.vision = 2; //5 en montes, se debe implementar algun metodo que lo cambie.
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.energiaMaxima = 99;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 3;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";

	}

}
