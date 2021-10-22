package jClasses;

public abstract class InfLigera extends Infanteria {

	public InfLigera() {
		super();
		this.nombre = "";
		this.tipoMov = TipoMovimiento.RODRIGODESCRIBEMEJORLOSPERROSATRIBUTOS;
		this.categoria = "";
		this.salud = (this.salud - 30) * 30;
		this.golpe = 0;
		this.armadura = 0;
		this.armaPrincipal = "";
		this.armaSecundaria = "";
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcance = 0;
		this.municionesPrim = 0;
		this.municionesSec = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}
	
	
	
}
