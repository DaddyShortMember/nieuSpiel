package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class NShip extends Naval{
	
	
public NShip() {
		
		this.nombre = "Buque de Guerra";
		this.idTropa = IdentidadTropa.N_SHIP;
		this.tipoTropa = TipoTropa.MARINA;
		this.tipoMov = TipoMov.ACUATICO;
		this.captura = false;
		this.construye = false;
		this.salud = 400;
		this.golpePrim = 200;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.CANNON;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 24000;
		this.nivel = 0;
		this.vision = 6;
		this.alcanceMin = 3;
		this.alcanceMax = 5;
		this.municionesPrim = 6;
		this.energiaMaxima = 99;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 5;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}
	

}
