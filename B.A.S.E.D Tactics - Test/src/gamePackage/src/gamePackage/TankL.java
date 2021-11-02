package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class TankL extends Vehiculo {
	
public TankL()  {
		
		this.nombre = "Tanque Ligero";
		this.idTropa = IdentidadTropa.TANK_L;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.ACORAZADO;
		this.captura = false;
		this.construye = false;
		this.salud = 200;
		this.golpePrim = 110;
		this.golpeSec = 75;
		this.armaPrincipal = Armamento.TCANNON;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 7000;
		this.nivel = 0;
		this.vision = 3;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 6;
		this.energiaMaxima = 70;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 6;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
