package jClasses;

public abstract class Tropa {
	
	//Declaracion ENUM para TipoMovimiento
	enum TipoMovimiento{
		TIPOA,
		TIPOB,
		TIPOC,
		RODRIGODESCRIBEMEJORLOSPERROSATRIBUTOS
	}

	/*TODO:
	 * YEst
	 * Nombre
	 * Vida
	 * Tipo Tropa
	 * 
	 * 1. Boolean que define si captura o no
	 * 	a. Si no es optimo, algo similar
	 * 2. Distancia Maxina c
	 * 3. Vision c
	 * 4. Alcanze c
	 * 5. Municion c
	 * 6. Arma 1 c
	 * 7. Arma 2 c
	 * 8. Tipo de Movimiento
	 * 9. Tipo de tropa c
	 * 10. Precio c
	 * 11. Energia c
	 * 12. Tipo Mov
	 * 13. Nibel c
	 * 14. Imagen c
	 * 
	 */
	
	String nombre;
	String tipoTropa;
	enum TipoMovimiento;
	String categoria;
	int salud;
	int golpe;
	//ARMOR MUST BE PLANNED BETTER
	double armadura;
	//NEWLY ADDED, UNIMPLEMENTED
	String armaPrincipal;
	String armaSecundaria;
	
	int precio;
	int nivel;
	int vision;
	int alcance;
	int municionesPrim;
	int municionesSec;
	int energia;
	int distanciaMaxima;
	String tipoMovimiento;
	//DATOS VISUALES
	int posX;
	int posY;
	String imagen;
	
	
	
	
}
