package gamePackage.terrenos;
import gamePackage.entidades.Tropa;
import gamePackage.logica.*;


public interface Terreno {
	
	/*
	[Datos Logicos]
	idTerreno — Identidad del terreno.
	nombre — Nombre del terreno
	construibleSobre — Si se puede construir sobre este terreno. Implementado por cada grano de tierra y mar.
	peaje — Lo que cuesta pasar por este terreno. Depende del tipo de tropa, por lo que se debe implementar arlgun metodo.
	defensa — Influye en el golpe total que recibe cada tropa. Mientras mas defensa, menos golpe recibido.
	
	[Datos Fisicos]
	int posX;
	int posY;
	String imagen;
	
	 */
	
	/*Atributos a copiar en clases
	
	ListaIDTerreno idTerreno = null;
	String nombre = "";
	boolean construibleSobre = false;
	int peaje = 0;
	int defensa = 0;
	int posX = 0;
	int posY = 0;
	String imagen = "";
	
	*/
	//Metodos Fisicos
		//Setters
	public String getNombre();
	public void setPos(int posX, int posY);
	public void setImagen(String imagen);
		//Getters
	public int[] getPos();
	
	//Metodos Logicos
		//Setters
	public void setTerreno(String imagen, int posX, int posY);	
		//Getters
	public ListaIDTerreno getIDTerreno();
	public int getPeaje(Tropa trop);
	public int getDefensa();
	public boolean getConstSobre();

	

}


