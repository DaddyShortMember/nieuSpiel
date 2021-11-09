package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class Arty extends Vehiculo{
	
public Arty()  {
		
		this.nombre = "Artilleria";
		this.idTropa = IdentidadTropa.ARTY;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.ACORAZADO;
		this.captura = false;
		this.construye = false;
		this.salud = 150;
		this.golpePrim = 150;	
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.CANNON;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 6000;
		this.nivel = 0;
		this.vision = 5;
		this.alcanceMin = 2;
		this.alcanceMax = 3;
		this.municionesPrim = 6;
		this.energiaMaxima = 50;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 5;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
