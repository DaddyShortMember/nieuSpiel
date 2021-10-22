package jClasses;

public abstract class Estructura {

	/*TODO:
	 * 1. Nombre
	 * 2. Imagen
	 * 3. Defensa
	 * 4. Coste de Combustible
	 * 5. Posicion en Mapa
	 * 6. Capturable
	 * 7. Visible
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	String nombre;
	String imagen;
	int defensa;
	int peaje;
	int posX;
	int posY;
	boolean capturable;
	boolean visibleEncontrado;
	
	public Estructura(String nombre, String imagen, int defensa, int peaje, int posX, int posY, boolean capturable,
			boolean visibleEncontrado) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.defensa = defensa;
		this.peaje = peaje;
		this.posX = posX;
		this.posY = posY;
		this.capturable = capturable;
		this.visibleEncontrado = visibleEncontrado;
	}
	
	public Estructura() {
		this.nombre = "";
		this.imagen = "";
		this.defensa = 0;
		this.peaje = 0;
		this.posX = 0;
		this.posY = 0;
		this.capturable = false;
		this.visibleEncontrado = false;
	}
	
	
}
