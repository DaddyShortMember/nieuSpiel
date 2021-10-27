package jClasses;

public abstract class Tropa {
	
		enum IdentidadTropa{
		//Presiento que esto sera util en algun momento
		//Para algun metodo, o solucionar algun problema a futuro
		
		//Infanteria
		INF_FOOT, //Infanteria normal
		INF_MECH, //Mech
		INF_BIKE, //MOTO
		
		//Vehiculos
		V_RECON, //Reconocimiento
		ANTI_A, //Anti-aereo
		TANK_L, //Tanque ligero
		TANK_M, //Tanque mediano
		TANK_H, //Tanque pesado
		ARTY, //Artilleria
		MISL, //Missile Launcher == Lanzamisiles
		ROCL, //Rocket Launcher == Tiracohetes
		ANTI_T, //Anti-tanque
		V_APC, //TOA
		V_FLARE, //FLARE
		
		//Aereo
		A_HELIT, //Helicoptero de TRansporte
		A_HELIC, //Helicoptero de COMbate
		A_FIGHTJET, //Caza
		A_LIGHTJET, //Caza ligero
		A_SEAJET, //Naval
		A_BOMBER, //Bombardero
		
		
		//Naval
		N_SHIP, //Buque de Guerra
		N_CRUS, //Fragata
		N_SUBM, //Submarino
		N_CARR, //Portaviones
		N_LAND, //Lancha de Desembarco
		N_MBOAT, //Buque de Misiles
		
	}
	
	
	enum TipoTropa{
		INFANTERIA, //Tropa barata y ligera, poco golpe, siempre tierra
		TERRESTRE, //Tropa vehicular/mecanizada, mucho golpe, siempre tierra
		AEREA, //Tropa aerea, mucho golpe?, siempre aire
		MARINA, //Tropa maritina, mucho golpe, siempre agua
		SUBMARINA //Se hace un metodo que alterne entre acua/subacua para submarinos, si se implementan
	}
	
	enum TipoMov{
		INFANTERIA, //Infanteria comun, va por monte y toaspartes no se
		MECH, //Basicamente, infanteria con otros atributos.
		V_LIGERO, //Vehiculo ligero, diferente manera de movimiento
		V_PESADO, //VEhiculo pesado, mas peso == diferente movimiento
		ACORAZADO, //Con orugas y mucha armadura. Much more heavy
		AEREO, //Va por aire.
		ACUATICO, //Va por mar.
		SUBACUATICO //Se hace un metodo que alterne entre acua/subacua para submarinos, si se implementan
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

	String nombre; //Nombre de la tropa. Esto es lo que se muestra
	IdentidadTropa idTropa; //Identidad de la tropa. Esto para metodos a futuro
	TipoTropa tipoTropa; //Identidad de tipo de tropa. Esto para metodos a futuro
	TipoMov tipoMov; //Identidad de tipo de movimiento. Esto para metodos a futuro
	boolean captura; //Si puede capturar o no
	boolean construye; //Si puede construir estructuras o no. Usado solo por una tropa de momento, pero implementable a futuro para mas.
	int salud; //Cuanto golpe puede absorver
	int golpePrim;//Cuanto duele cuando da con arma primaria.
	int golpeSec;//Cuanto duele cuando da con arma secundaria.
	//int armadura; //Despreciado de momento, igual surje algo y se reimplementa.
	Armamento armaPrincipal; //Arma principal, la que siempre llevaria. Municiones limitadas.
	Armamento armaSecundaria; //Arma secundaria, un arma opcional que se dispara contra ciertos enemigos, o en ciertos escenarios. Municiones infinitas.
	int precio; //Cuanto cuesta
	int nivel; //Se obtiene por victoria en combate. Incrementa el golpe o algo.
	int vision; //Numero de casillas que puede ver
	int alcanceMin; //Limite minimo de casillas en las que puede ataquar
	int alcanceMax; //Limite maximo de casillas en las que puede ataquar
	int municionesPrim; //Numero de municiones que tiene el arma primaria.
	int energiaMaxima; //Numero de movimientos maximos
	int energia; //Numero de casillas que se puede mover la tropa cada momento. Sistema TBD, @Rodrigo
	int distanciaMaxima; //Numero de casillas total que la tropa puede moverse en un turno
	//DATOS VISUALES
	int posX; //Posicion en eje X
	int posY; //Posicion en eje Y
	String imagen; //Fichero de imagen
	
	//Hay que volver a hacer el constructor
	
}
