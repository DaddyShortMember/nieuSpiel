package jClasses;


public class Rifleman extends InfLigera{

	public Rifleman() {
		super();
		this.nombre = "Soldado Raso";
		this.tipoMov = TipoMovimiento.RODRIGODESCRIBEMEJORLOSPERROSATRIBUTOS;
		this.categoria = "Inf. Ligera";
		this.salud = this.salud + 30;
		this.golpe = 40;
		this.armadura = 10;
		this.armaPrincipal = "Rifle";
		this.armaSecundaria = null;
		this.precio = 200;
		this.nivel = 0;
		this.vision = 5;
		this.alcance = 2;
		this.municionesPrim = 120;
		this.municionesSec = 0;
		this.energia = 10;
		this.distanciaMaxima = 5;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

	@Override
	public String toString() {
		return "Rifleman [nombre=" + nombre + ", tipoTropa=" + tipoTropa + ", tipoMov=" + tipoMov + ", categoria="
				+ categoria + ", salud=" + salud + ", golpe=" + golpe + ", armadura=" + armadura + ", armaPrincipal="
				+ armaPrincipal + ", armaSecundaria=" + armaSecundaria + ", precio=" + precio + ", nivel=" + nivel
				+ ", vision=" + vision + ", alcance=" + alcance + ", municionesPrim=" + municionesPrim
				+ ", municionesSec=" + municionesSec + ", energia=" + energia + ", distanciaMaxima=" + distanciaMaxima
				+ ", posX=" + posX + ", posY=" + posY + ", imagen=" + imagen + "]";
	}
	
	

}
