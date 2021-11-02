package gamePackage;

public class Sea extends Terreno{
	
	public Sea(){
		this.idTerreno = IdentidadTerreno.SEA;
		this.nombre = "Mar";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}
	

}
