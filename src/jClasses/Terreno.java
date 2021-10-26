package jClasses;

public abstract class Terreno {
	
	
	
	String nombre; //Nombre del terreno
	int peaje; //Lo que cuesta pasar por este terreno
	int defensa; //Influye en el golpe total que recibe cada tropa. Mientras mas defensa, menos golpe recibido.
	//Datos Fisicos
	String imagen;
	int posX;
	int posY;
	
	public Terreno(String nombre, int peaje, int defensa, String imagen, int posX, int posY) {
		super();
		this.nombre = nombre;
		this.peaje = peaje;
		this.defensa = defensa;
		this.imagen = imagen;
		this.posX = posX;
		this.posY = posY;
	}
	
	public Terreno() {
		this.nombre = "";
		this.peaje = 0;
		this.defensa = 0;
		this.imagen = "";
		this.posX = 0;
		this.posY = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeaje() {
		return peaje;
	}

	public void setPeaje(int peaje) {
		this.peaje = peaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
	
}
