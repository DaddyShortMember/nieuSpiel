package clasesEntidades;

public abstract class Tropa {
	
		public enum IdentidadTropa{
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
	
	
	public enum TipoTropa{
		INFANTERIA, //Tropa barata y ligera, poco golpe, siempre tierra
		TERRESTRE, //Tropa vehicular/mecanizada, mucho golpe, siempre tierra
		AEREA, //Tropa aerea, mucho golpe?, siempre aire
		MARINA, //Tropa maritina, mucho golpe, siempre agua
		SUBMARINA //Se hace un metodo que alterne entre acua/subacua para submarinos, si se implementan
	}
	
	public enum TipoMov{
		INFANTERIA, //Infanteria comun, va por monte y toaspartes no se
		MECH, //Basicamente, infanteria con otros atributos.
		V_LIGERO, //Vehiculo ligero, diferente manera de movimiento
		V_PESADO, //VEhiculo pesado, mas peso == diferente movimiento
		ACORAZADO, //Con orugas y mucha armadura. Much more heavy
		AEREO, //Va por aire.
		ACUATICO, //Va por mar.
		SUBACUATICO //Se hace un metodo que alterne entre acua/subacua para submarinos, si se implementan
	}
	
	public enum Armamento{
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
	
	public Tropa(String nombre, IdentidadTropa idTropa, TipoTropa tipoTropa, TipoMov tipoMov, boolean captura,
			boolean construye, int salud, int golpePrim, int golpeSec, Armamento armaPrincipal,
			Armamento armaSecundaria, int precio, int nivel, int vision, int alcanceMin, int alcanceMax,
			int municionesPrim, int energiaMaxima, int energia, int distanciaMaxima, int posX, int posY,
			String imagen) {
		super();
		this.nombre = nombre;
		this.idTropa = idTropa;
		this.tipoTropa = tipoTropa;
		this.tipoMov = tipoMov;
		this.captura = captura;
		this.construye = construye;
		this.salud = salud;
		this.golpePrim = golpePrim;
		this.golpeSec = golpeSec;
		this.armaPrincipal = armaPrincipal;
		this.armaSecundaria = armaSecundaria;
		this.precio = precio;
		this.nivel = nivel;
		this.vision = vision;
		this.alcanceMin = alcanceMin;
		this.alcanceMax = alcanceMax;
		this.municionesPrim = municionesPrim;
		this.energiaMaxima = energiaMaxima;
		this.energia = energia;
		this.distanciaMaxima = distanciaMaxima;
		this.posX = posX;
		this.posY = posY;
		this.imagen = imagen;
	}
	
	public Tropa() {
	
		this.nombre = "";
		this.idTropa = IdentidadTropa.INF_FOOT;
		this.tipoTropa = TipoTropa.INFANTERIA;
		this.tipoMov = TipoMov.INFANTERIA;
		this.captura = false;
		this.construye = false;
		this.salud = 0;
		this.golpePrim = 0;
		this.golpeSec = 0;
		this.armaPrincipal = Armamento.NADA;
		this.armaSecundaria = Armamento.NADA;
		this.precio = 0;
		this.nivel = 0;
		this.vision = 0;
		this.alcanceMin = 0;
		this.alcanceMax = 0;
		this.municionesPrim = 0;
		this.energiaMaxima = 0;
		this.energia = 0;
		this.distanciaMaxima = 0;
		this.posX = 0;
		this.posY = 0;
		this.imagen = "";
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public IdentidadTropa getIdTropa() {
		return idTropa;
	}

	public void setIdTropa(IdentidadTropa idTropa) {
		this.idTropa = idTropa;
	}

	public TipoTropa getTipoTropa() {
		return tipoTropa;
	}

	public void setTipoTropa(TipoTropa tipoTropa) {
		this.tipoTropa = tipoTropa;
	}

	public TipoMov getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(TipoMov tipoMov) {
		this.tipoMov = tipoMov;
	}

	public boolean isCaptura() {
		return captura;
	}

	public void setCaptura(boolean captura) {
		this.captura = captura;
	}

	public boolean isConstruye() {
		return construye;
	}

	public void setConstruye(boolean construye) {
		this.construye = construye;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getGolpePrim() {
		return golpePrim;
	}

	public void setGolpePrim(int golpePrim) {
		this.golpePrim = golpePrim;
	}

	public int getGolpeSec() {
		return golpeSec;
	}

	public void setGolpeSec(int golpeSec) {
		this.golpeSec = golpeSec;
	}

	public Armamento getArmaPrincipal() {
		return armaPrincipal;
	}

	public void setArmaPrincipal(Armamento armaPrincipal) {
		this.armaPrincipal = armaPrincipal;
	}

	public Armamento getArmaSecundaria() {
		return armaSecundaria;
	}

	public void setArmaSecundaria(Armamento armaSecundaria) {
		this.armaSecundaria = armaSecundaria;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getAlcanceMin() {
		return alcanceMin;
	}

	public void setAlcanceMin(int alcanceMin) {
		this.alcanceMin = alcanceMin;
	}

	public int getAlcanceMax() {
		return alcanceMax;
	}

	public void setAlcanceMax(int alcanceMax) {
		this.alcanceMax = alcanceMax;
	}

	public int getMunicionesPrim() {
		return municionesPrim;
	}

	public void setMunicionesPrim(int municionesPrim) {
		this.municionesPrim = municionesPrim;
	}

	public int getEnergiaMaxima() {
		return energiaMaxima;
	}

	public void setEnergiaMaxima(int energiaMaxima) {
		this.energiaMaxima = energiaMaxima;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public void setDistanciaMaxima(int distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
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
