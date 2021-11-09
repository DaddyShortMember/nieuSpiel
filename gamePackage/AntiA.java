package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class AntiA extends Vehiculo {

public AntiA()  {
		
		this.nombre = "Anti-Aereo";
		this.idTropa = IdentidadTropa.ANTI_A;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.ACORAZADO;
		this.captura = false;
		this.construye = false;
		this.salud = 200;
		this.golpePrim = 120;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.CANNON;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 8000;
		this.nivel = 0;
		this.vision = 3;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 6;
		this.energiaMaxima = 50;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 6;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

	
}
