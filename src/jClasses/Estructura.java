package jClasses;

public abstract class Estructura extends Terreno{

	boolean capturable; //Si es capturable o no.
	boolean fabrica; //Si es capaz de producir tropas.
	boolean visibleEncontrado; //Si es visible a primera vista, se puede integrar con un metodo un rango de casillas minimas hasta que sea visible
	int ingresos; //Cantidad de dinero que te dan por tener esta estructura
	
	public Estructura(String nombre, int peaje, int defensa, String imagen, int posX, int posY, boolean capturable,
			boolean fabrica, boolean visibleEncontrado, int ingresos) {
		super(nombre, peaje, defensa, imagen, posX, posY);
		this.capturable = capturable;
		this.fabrica = fabrica;
		this.visibleEncontrado = visibleEncontrado;
		this.ingresos = ingresos;
		
	}
		
		public Estructura() {
			this.capturable = false;
			this.fabrica = false;
			this.visibleEncontrado = false;
			this.ingresos = 0;
			this.nombre = "";
			this.peaje = 0;
			this.defensa = 0;
			this.imagen = "";
			this.posX = 0;
			this.posY = 0;
	}
	
}
