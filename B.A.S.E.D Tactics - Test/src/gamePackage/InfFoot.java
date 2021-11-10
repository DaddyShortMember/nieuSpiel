package gamePackage;

public class InfFoot implements Tropa {
	
	//ATRIBUTOS LOGICOS
	ListaIDTropa idTropa = ListaIDTropa.INF_FOOT;
	ListaTipos tipoTropa = ListaTipos.INFANTERIA;
	ListaTipos tipoMov = ListaTipos.INFANTERIA;
	boolean captura = true;
	boolean construye = false;
	int saludMaxima = 100;
	int salud = this.saludMaxima;
	int golpePrim = 0;
	int golpeSec = 55;
	ListaArmas armaPrincipal = ListaArmas.NADA;
	ListaArmas armaSecundaria = ListaArmas.AMETRALLADORA;
	int precio = 1500;
	int nivel = 0;
	int vision = 2;
	int alcanceMin = 1;
	int alcanceMax = this.alcanceMin;
	int municionesPrim = 0;
	int energiaMaxima = 99;
	int energia = this.energiaMaxima;
	int distanciaMaxima = 3;
	
	//ATRIBUTOS FISICOS
	String nombre = "Infanteria";
	int posX = 0; //Posicion en eje X
	int posY = 0; //Posicion en eje Y
	String imagen = ""; //Direccion de imagen
	
	//Metodos Heredados
		//Setters
	@Override
	public void setTropa(int posX, int posY, String imagen) {
		// TODO Auto-generated method stub
		this.posX = posX;
		this.posY = posY;
		this.imagen = imagen;
	}

	@Override
	public int[] getPos() {
		int[] pos = new int[2];
		pos[0] = posX;
		pos[1] = posY;
		return pos;
	}

	@Override
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void setImagen(String imagen) {
		// TODO Auto-generated method stub
		this.imagen = imagen;
	}

	@Override
	public void setSalud(int salud) {
		// TODO Auto-generated method stub
		this.salud = salud;
	}

	@Override
	public void setEnergia(int energia) {
		// TODO Auto-generated method stub
		this.energia = energia;
	}

	@Override
	public void setMuniciones(int municiones) {
		// TODO Auto-generated method stub
		this.municionesPrim = municiones;
	}

	@Override
	public void setNivel(int nivel) {
		// TODO Auto-generated method stub
		this.nivel = nivel;
	}
		//Getters
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public ListaIDTropa getIDTropa() {
		// TODO Auto-generated method stub
		return idTropa;
	}

	@Override
	public ListaTipos getTipoTropa() {
		// TODO Auto-generated method stub
		return tipoTropa;
	}

	@Override
	public ListaTipos getTipoMov() {
		// TODO Auto-generated method stub
		return tipoMov;
	}

	@Override
	public ListaArmas[] getArmas() {
		ListaArmas[] armas = new ListaArmas[2];
		armas[0] = armaPrincipal;
		armas[1] = armaSecundaria;
		// TODO Auto-generated method stub
		return armas;
	}

	@Override
	public boolean getCaptura() {
		// TODO Auto-generated method stub
		return captura;
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	@Override
	public boolean getConstruye() {
		// TODO Auto-generated method stub
		return construye;
	}

	@Override
	public int getSalud() {
		// TODO Auto-generated method stub
		return salud;
	}

	@Override
	public int getGolpePrim() {
		// TODO Auto-generated method stub
		return golpePrim;
	}

	@Override
	public int getGolpeSec() {
		// TODO Auto-generated method stub
		return golpeSec;
	}

	@Override
	public int getDistMax() {
		// TODO Auto-generated method stub
		return distanciaMaxima;
	}

	@Override
	public int getEnergia() {
		// TODO Auto-generated method stub
		return energia;
	}

	@Override
	public int[] getAlcance() {
		int[] alc = new int[2];
		alc[0] = alcanceMin;
		alc[1] = alcanceMax;
		// TODO Auto-generated method stub
		return alc;
	}

	@Override
	public int getMuniciones() {
		// TODO Auto-generated method stub
		return municionesPrim;
	}

	@Override
	public int getVision() {
		// TODO Auto-generated method stub
		return vision;
	}

	@Override
	public int getNivel() {
		// TODO Auto-generated method stub
		return nivel;
	}
	
	//Metodos Inutiles Para Esta Tropa
	@Override
	public void setTipoMov(ListaTipos tipoMov) {
		// TODO Auto-generated method stub
		//Nada
	}
	@Override
	public void setTipoTropa(ListaTipos tipoTropa) {
		// TODO Auto-generated method stub
		//Nada
	}
	
	//Metodos Unicos Para Esta Tropa
		//Setters
	public void setVision(int vis) {
		this.vision = vis;
	}
		//Getters
	
}

