package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class VRecon extends Vehiculo {
	
public VRecon() {
		
		this.nombre = "Reconocimiento";
		this.idTropa = IdentidadTropa.V_RECON;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.V_PESADO;
		this.captura = false;
		this.construye = false;
		this.salud = 130;
		this.golpePrim = 0;
		this.golpeSec = 75;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 4000;
		this.nivel = 0;
		this.vision = 5;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 0;
		this.energiaMaxima = 99;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 8;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
