package gamePackage;

import gamePackage.Tropa.Armamento;
import gamePackage.Tropa.IdentidadTropa;
import gamePackage.Tropa.TipoMov;
import gamePackage.Tropa.TipoTropa;

public class InfMech extends Infanteria {
	
public InfMech() {
		super();
		this.nombre = "Mech";
		this.idTropa = IdentidadTropa.INF_MECH;
		this.tipoTropa = TipoTropa.INFANTERIA;
		this.tipoMov = TipoMov.MECH;
		this.captura = true;
		this.construye = false;
		this.salud = 120;
		this.golpePrim = 110;
		this.golpeSec = 65;
		this.armaPrincipal = Armamento.LANZACOHETES;
		this.armaSecundaria = Armamento.AMETRALLADORA;
		this.precio = 2500;
		this.nivel = 0;
		this.vision = 2;
		this.alcanceMin = 1;
		this.alcanceMax = 1;
		this.municionesPrim = 3;
		this.energiaMaxima = 70;
		this.energia = 70;
		this.distanciaMaxima = 2;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";

	}

}
