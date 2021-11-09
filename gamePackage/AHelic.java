package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class AHelic extends Aereo{
	
public AHelic() {
		
		this.nombre = "Helicoptero de Combate";
		this.idTropa = IdentidadTropa.A_HELIC;
		this.tipoTropa = TipoTropa.AEREA;
		this.tipoMov = TipoMov.AEREO;
		this.captura = false;
		this.construye = false;
		this.salud = 250;
		this.golpePrim = 130;
		this.golpeSec = 90;
		this.armaPrincipal = Armamento.MISIL;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 9000;
		this.nivel = 0;
		this.vision = 2;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 6;
		this.energiaMaxima = 99;
		this.energia =  this.energiaMaxima;
		this.distanciaMaxima = 6;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
