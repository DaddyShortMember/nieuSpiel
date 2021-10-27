package clasesEntidades;

import clasesEntidades.Terreno.IdentidadTerreno;

public abstract class Estructura extends Terreno{

	ListaTipos suministraA;
	boolean cuartelGeneral; //Si es el cuartel general o no
	boolean construible; //Si se puede construir o no; usado por aeropuerto y puerto temporal
	boolean capturable; //Si es capturable o no.
	boolean fabrica; //Si es capaz de producir tropas.
	boolean visibleEncontrado; //Si es visible a primera vista, se puede integrar con un metodo un rango de casillas minimas hasta que sea visible
	int ingresos; //Cantidad de dinero que te dan por tener esta estructura
	
	public Estructura(ListaTipos suministraA,IdentidadTerreno idTerreno, String nombre, boolean construibleSobre, int peaje, int defensa,
			String imagen, int posX, int posY, boolean cuartelGeneral, boolean construible, boolean capturable,
			boolean fabrica, boolean visibleEncontrado, int ingresos) {
		super(idTerreno, nombre, construibleSobre, peaje, defensa, imagen, posX, posY);
		this.suministraA = suministraA;
		this.cuartelGeneral = cuartelGeneral;
		this.construible = construible;
		this.capturable = capturable;
		this.fabrica = fabrica;
		this.visibleEncontrado = visibleEncontrado;
		this.ingresos = ingresos;
	}
	
	public Estructura() {
		super();
		this.suministraA = ListaTipos.TERRESTRE; //Implementar mediante algun metodo, @Godriro
		this.idTerreno = IdentidadTerreno.CITY;
		this.nombre = "Cuarteles Generales";
		this.construibleSobre = false;
		this.peaje = 0;
		this.defensa = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		this.cuartelGeneral = false;
		this.construible = false;
		this.capturable = false;
		this.fabrica = false;
		this.visibleEncontrado = true;
		this.ingresos = 0;
	}

	public ListaTipos getSuministraA() {
		return suministraA;
	}

	public void setSuministraA(ListaTipos suministraA) {
		this.suministraA = suministraA;
	}

	public boolean isCuartelGeneral() {
		return cuartelGeneral;
	}

	public void setCuartelGeneral(boolean cuartelGeneral) {
		this.cuartelGeneral = cuartelGeneral;
	}

	public boolean isConstruible() {
		return construible;
	}

	public void setConstruible(boolean construible) {
		this.construible = construible;
	}

	public boolean isCapturable() {
		return capturable;
	}

	public void setCapturable(boolean capturable) {
		this.capturable = capturable;
	}

	public boolean isFabrica() {
		return fabrica;
	}

	public void setFabrica(boolean fabrica) {
		this.fabrica = fabrica;
	}

	public boolean isVisibleEncontrado() {
		return visibleEncontrado;
	}

	public void setVisibleEncontrado(boolean visibleEncontrado) {
		this.visibleEncontrado = visibleEncontrado;
	}

	public int getIngresos() {
		return ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}
	
	//Hay que hacer constructores again
	
	
}
