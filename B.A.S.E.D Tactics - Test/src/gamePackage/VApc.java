package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class VApc extends Vehiculo {
	
public VApc() {
		
		this.nombre = "TOA";
		this.idTropa = IdentidadTropa.V_APC;
		this.tipoTropa = TipoTropa.TERRESTRE;
		this.tipoMov = TipoMov.ACORAZADO;
		this.captura = false;
		this.construye = true;
		this.salud = 300;
		this.golpePrim = 0;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 5000;
		this.nivel = 0;
		this.vision = 1;
		this.alcanceMin = 0;
		this.alcanceMax = 0;
		this.municionesPrim = 0;
		this.energiaMaxima = 99;
		this.energia = this.energiaMaxima;
		this.distanciaMaxima = 6;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

}
