package jClasses;

public abstract class Tropa {
	
	//Declaracion ENUM para TipoMovimiento
	enum TipoMov{
		INFANTERIA,
		MECH, //Basicamente, infanteria con otros atributos.
		VEHICULOLIGERO,
		VEHICULOPESADO,
		ACORAZADO,
		AEREO,
		ACUATICO,
	}
	
	enum TipoTropa{
		INFANTERIA,
		TERRESTRE,
		AEREA,
		MARINA,
	}

	String nombre; //Nombre de la tropa
	TipoTropa tipoTropa; //
	TipoMov tipoMov;
	boolean captura;
	int salud; //Defensa en AW, teoricamente. Numero de gente en tropa. Usualmente 10.
	int golpe; //Cuanto duele cuando da. Se debe pasar a decimal por un metodo.
	int armadura; //Reduce el golpe recibido. Se debe pasar a decimal por un metodo, y devuelta a int para simplificar calculos.
	//NEWLY ADDED, UNIMPLEMENTED
	String armaPrincipal; //Arma principal, la que siempre llevaria
	String armaSecundaria; //Arma secundaria, un arma opcional que se dispara contra ciertos enemigos, o en ciertos escenarios
	int precio; //Cuanto cuesta
	int nivel; //Se obtiene por victoria en combate. Incrementa el golpe o algo.
	int vision; //Numero de casillas que puede ver
	int alcance; //Numero de casillas en las que puede ataquar
	int municionesPrim; //Numero de municiones que tiene el arma primaria.
	int municionesSec; //Numero de municiones que tiene el arma secundaria.
	int energia; //Numero de casillas que se puede mover la tropa cada momento. Sistema TBD, @Rodrigo
	int distanciaMaxima; //Numero de casillas total que la tropa puede moverse
	//DATOS VISUALES
	int posX; //Posicion en eje X
	int posY; //Posicion en eje Y
	String imagen; //Fichero de imagen
	
	//Constructor Normal
	public Tropa(String nombre, TipoTropa tipoTropa, TipoMov tipoMov, boolean captura, int salud, int golpe,
			int armadura, String armaPrincipal, String armaSecundaria, int precio, int nivel, int vision, int alcance,
			int municionesPrim, int municionesSec, int energia, int distanciaMaxima, int posX, int posY,
			String imagen) {
		super();
		this.nombre = nombre;
		this.tipoTropa = tipoTropa;
		this.tipoMov = tipoMov;
		this.captura = captura;
		this.salud = salud;
		this.golpe = golpe;
		this.armadura = armadura;
		this.armaPrincipal = armaPrincipal;
		this.armaSecundaria = armaSecundaria;
		this.precio = precio;
		this.nivel = nivel;
		this.vision = vision;
		this.alcance = alcance;
		this.municionesPrim = municionesPrim;
		this.municionesSec = municionesSec;
		this.energia = energia;
		this.distanciaMaxima = distanciaMaxima;
		this.posX = posX;
		this.posY = posY;
		this.imagen = imagen;
	}
	
	public Tropa() {
		super();
		this.nombre = "";
		this.tipoTropa = TipoTropa.INFANTERIA;
		this.tipoMov = TipoMov.INFANTERIA;
		this.captura = false;
		this.salud = 0;
		this.golpe = 0;
		this.armadura = 0;
		this.armaPrincipal = "";
		this.armaSecundaria = "";
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcance = 0;
		this.municionesPrim = 0;
		this.municionesSec = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}
	
	
	
}
