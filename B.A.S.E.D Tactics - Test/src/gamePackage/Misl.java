package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class Misl extends Vehiculo{
	
public Misl() {
		
		this.nombre = "Lanzamisiles";
		this.idTropa = IdentidadTropa.MISL;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.V_PESADO;
		this.captura = false;
		this.construye = false;
		this.salud = 160;
		this.golpePrim = 450;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.MISIL_AA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 11000;
		this.nivel = 0;
		this.vision = 5;
		this.alcanceMin = 3;
		this.alcanceMax = 6;
		this.municionesPrim = 5;
		this.energiaMaxima = 50;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 5;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
