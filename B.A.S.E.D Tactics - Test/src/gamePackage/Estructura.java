package gamePackage;

public interface Estructura extends Terreno{
	
	/*
	[Datos Logicos]
	suministraA — Para saber a que tipo de tropas suministra.
	cuartelGeneral — Si es el cuartel general o no
	construible — Si se puede construir o no; usado por aeropuerto y puerto temporal
	capturable — Si es capturable o no.
	fabrica — Si es capaz de producir tropas.
	visibleEncontrado — Si es visible a primera vista, se puede integrar con un metodo un rango de casillas minimas hasta que sea visible
	ingresos — Cantidad de dinero que te dan por tener esta estructura 
	
	 */
	
	/*Atributos a copiar a clases:
	
	boolean suministra = true;
	boolean cuartelGeneral = false;
	boolean construible = false;
	boolean capturable = false;
	boolean fabrica = false;
	boolean visibleEncontrado = true;
	int ingresos = 0;
	
	*/
	
	//Metodos Logicos
		//Setters
	//Nada. No hacen falta los Setters.
		//Getters
	public boolean getCapturable();
	public boolean getFabrica();
	public boolean getCG();
	public boolean getConstruible();
	public int getIngresos();
	public boolean suministra(Tropa trop);
}
