package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class Rocl extends Vehiculo {

public Rocl() {
		
		this.nombre = "Lanzacohetes";
		this.idTropa = IdentidadTropa.ROCL;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.V_PESADO;
		this.captura = false;
		this.construye = false;
		this.salud = 185;
		this.golpePrim = 450;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.COHETE;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 15000;
		this.nivel = 0;
		this.vision = 3;
		this.alcanceMin = 3;
		this.alcanceMax = 5;
		this.municionesPrim = 5;
		this.energiaMaxima = 50;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 5;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}
	
}
