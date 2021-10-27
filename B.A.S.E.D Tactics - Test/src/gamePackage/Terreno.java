package gamePackage;

public abstract class Terreno {
	
		enum IdentidadTerreno{
		//TERRENO INDOMABLE
		PLAINS, //Llanos y praderas
		ROAD, //Carreteras
		BRIDGE, //Puentes? En serio, Rodrigo?
		MOUNTAIN, //Montanas y montes altos
		SEA, //El mar azul tan bello
		ARCHIPELAGO, //Conjunto de islas cercanas
		COAST, //Costas, donde se pueden construir
		FOREST, //Bosques
		//ESTRUCTURAS CAPTURABLES
		HQ, //Cuarteles generales
		CITY, //Ciudad
		FACTORY, //Fabricas
		AIRPORT, //Aeropuerto
		PORT, //Puerto
		//Construibles
		TEMP_SEAP, //Puerto Temporal
		TEMP_AIRP //Aeropuerto Temporal, 
	}
	
	
	IdentidadTerreno idTerreno; //Identidad del terreno.
	String nombre; //Nombre del terreno
	boolean construibleSobre; //Si se puede construir sobre este terreno. Implementado por cada grano de tierra y mar.
	int peaje; //Lo que cuesta pasar por este terreno. Depende del tipo de tropa, por lo que se debe implementar arlgun metodo.
	int defensa; //Influye en el golpe total que recibe cada tropa. Mientras mas defensa, menos golpe recibido.
	//Datos Fisicos
	int posX;
	int posY;
	String imagen;
	//Imprescindible realizar constructores otra vez
	
	public Terreno(IdentidadTerreno idTerreno, String nombre, boolean construibleSobre, int peaje, int defensa,
			String imagen, int posX, int posY) {
		super();
		this.idTerreno = idTerreno;
		this.nombre = nombre;
		this.construibleSobre = construibleSobre;
		this.peaje = peaje;
		this.defensa = defensa;
		this.imagen = imagen;
		this.posX = posX;
		this.posY = posY;
	}
	
	public Terreno() {
		super();
		this.idTerreno = IdentidadTerreno.PLAINS;
		this.nombre = "";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}

	public IdentidadTerreno getIdTerreno() {
		return idTerreno;
	}

	public void setIdTerreno(IdentidadTerreno idTerreno) {
		this.idTerreno = idTerreno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isConstruibleSobre() {
		return construibleSobre;
	}

	public void setConstruibleSobre(boolean construibleSobre) {
		this.construibleSobre = construibleSobre;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
