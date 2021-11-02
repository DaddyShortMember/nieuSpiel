package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class TankM extends Vehiculo{
	
public TankM()  {
		
		this.nombre = "Tanque Medio";
		this.idTropa = IdentidadTropa.TANK_M;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.ACORAZADO;
		this.captura = false;
		this.construye = false;
		this.salud = 500;
		this.golpePrim = 185;
		this.golpeSec = 95;
		this.armaPrincipal = Armamento.TCANNON_MED;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 12000;
		this.nivel = 0;
		this.vision = 2;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 5;
		this.energiaMaxima = 50;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 6;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
