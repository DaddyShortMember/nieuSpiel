package jClasses;

public abstract class Tropa {
	
	//Declaracion ENUM para TipoMovimiento
	
	enum TipoTropa{
		INFANTERIA,
		TERRESTRE,
		AEREA,
		MARINA,
	}
	
	enum TipoMov{
		INFANTERIA,
		MECH, //Basicamente, infanteria con otros atributos.
		VEHICULOLIGERO,
		VEHICULOPESADO,
		ACORAZADO,
		AEREO,
		ACUATICO,
	}
	
	enum Armamento{
		NADA,
		AMETRALLADORA,
		LANZACOHETES,
		BOMBA,
		COHETE,
		TORPEDO,
		MISIL,
		MISIL_AA, //Anti-aereos
		MISIL_AB, //Anti-barcos
		ARMA_AA, //Arma anti-aerea 
		ARMA_AB, //Arma anti-barcos 
		CANNON,
		TCANNON_LETAL, //Cannons de tanques. Es el mas pesado.
		TCANNON_MED, //Cannons de tanques. Intermedio
		TCANNON //Cannons de tanques. Normal
		//SE AGREGARAN MAS MIENTRAS CREZCA LA LISTA DE TROPAS
	}

	String nombre; //Nombre de la tropa
	TipoTropa tipoTropa; //
	TipoMov tipoMov;
	boolean captura;
	int salud; //Defensa en AW, teoricamente. Numero de gente en tropa. Usualmente 10.
	int golpe; //Cuanto duele cuando da. Se debe pasar a decimal por un metodo.
	int armadura; //Reduce el golpe recibido. Se debe pasar a decimal por un metodo, y devuelta a int para simplificar calculos.
	//NEWLY ADDED, UNIMPLEMENTED
	Armamento armaPrincipal; //Arma principal, la que siempre llevaria
	Armamento armaSecundaria; //Arma secundaria, un arma opcional que se dispara contra ciertos enemigos, o en ciertos escenarios
	int precio; //Cuanto cuesta
	int nivel; //Se obtiene por victoria en combate. Incrementa el golpe o algo.
	int vision; //Numero de casillas que puede ver
	int alcance; //Numero de casillas en las que puede ataquar
	int municionesPrim; //Numero de municiones que tiene el arma primaria.
	int energiaMaxima; //Numero de movimientos maximos
	int energia; //Numero de casillas que se puede mover la tropa cada momento. Sistema TBD, @Rodrigo
	int distanciaMaxima; //Numero de casillas total que la tropa puede moverse en un turno
	//DATOS VISUALES
	int posX; //Posicion en eje X
	int posY; //Posicion en eje Y
	String imagen; //Fichero de imagen
	
	//Constructor Normal
	
	
	public Tropa(String nombre, TipoTropa tipoTropa, TipoMov tipoMov, boolean captura, int salud, int golpe,
			int armadura, Armamento armaPrincipal, Armamento armaSecundaria, int precio, int nivel, int vision,
			int alcance, int municionesPrim, int energiaMaxima, int energia, int distanciaMaxima, int posX, int posY,
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
		this.energiaMaxima = energiaMaxima;
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
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcance = 0;
		this.municionesPrim = 0;
		this.energiaMaxima = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
	}
	
	
	
}
