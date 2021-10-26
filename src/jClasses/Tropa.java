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
		
		
		//Naval
		N_SHIP, //Battleship
		N_CRUS, //Cruiser
		N_SUBM, //Submarino
		N_CARR, //Aircraft Carrier
		N_LAND, //Lander
		
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getGolpe() {
		return golpe;
	}

	public void setGolpe(int golpe) {
		this.golpe = golpe;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
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

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
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
