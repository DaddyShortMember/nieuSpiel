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
	 * Ectb
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
	TipoMovimiento tipoMov;
	String categoria;
	int salud;
	int golpe;
	//ARMOR MUST BE PLANNED BETTER
	int armadura;
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
	//DATOS VISUALES
	int posX;
	int posY;
	String imagen;
	
	//HERE MAY BEGIN THE PURGE
	
	public Tropa(String nombre, String tipoTropa, TipoMovimiento tipoMov, String categoria, int salud, int golpe,
			int armadura, String armaPrincipal, String armaSecundaria, int precio, int nivel, int vision,
			int alcance, int municionesPrim, int municionesSec, int energia, int distanciaMaxima,
			int posX, int posY, String imagen) {
		super();
		this.nombre = nombre;
		this.tipoTropa = tipoTropa;
		this.tipoMov = tipoMov;
		this.categoria = categoria;
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
		this.nombre = "";
		this.tipoTropa = "";
		this.tipoMov = TipoMovimiento.RODRIGODESCRIBEMEJORLOSPERROSATRIBUTOS;
		this.categoria = "";
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoTropa() {
		return tipoTropa;
	}

	public void setTipoTropa(String tipoTropa) {
		this.tipoTropa = tipoTropa;
	}

	public TipoMovimiento getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(TipoMovimiento tipoMov) {
		this.tipoMov = tipoMov;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getArmaPrincipal() {
		return armaPrincipal;
	}

	public void setArmaPrincipal(String armaPrincipal) {
		this.armaPrincipal = armaPrincipal;
	}

	public String getArmaSecundaria() {
		return armaSecundaria;
	}

	public void setArmaSecundaria(String armaSecundaria) {
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

	public int getMunicionesSec() {
		return municionesSec;
	}

	public void setMunicionesSec(int municionesSec) {
		this.municionesSec = municionesSec;
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
