package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public abstract class Naval extends Tropa {

public Naval() {
		
		this.nombre = "";
		this.idTropa = IdentidadTropa.N_SHIP;
		this.tipoTropa = TipoTropa.MARINA;
		this.tipoMov = TipoMov.ACUATICO;
		this.captura = false;
		this.construye = false;
		this.salud = 0;
		this.golpePrim = 0;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcanceMin = 0;
		this.alcanceMax = 0;
		this.municionesPrim = 0;
		this.energiaMaxima = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
