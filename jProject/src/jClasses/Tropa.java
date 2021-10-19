package jClasses;

public abstract class Tropa {

	String nombre;
	String elemento;
	String categoria;
	double salud;
	double golpe;
	double armadura;
	
	public Tropa(String nombre, String elemento, String categoria, double salud, double golpe, double armadura) {
		super();
		this.nombre = nombre;
		this.elemento = elemento;
		this.categoria = categoria;
		this.salud = salud;
		this.golpe = golpe;
		this.armadura = armadura;
	}
	
	public Tropa() {
		this.nombre = "";
		this.elemento = "";
		this.categoria = "";
		this.salud = 0;
		this.golpe = 0;
		this.armadura = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getSalud() {
		return salud;
	}

	public void setSalud(Double salud) {
		this.salud = salud;
	}

	public Double getGolpe() {
		return golpe;
	}

	public void setGolpe(Double golpe) {
		this.golpe = golpe;
	}

	public Double getArmadura() {
		return armadura;
	}

	public void setArmadura(Double armadura) {
		this.armadura = armadura;
	}

	
	
	@Override
	public String toString() {
		return "Tropa [nombre=" + nombre + ", elemento=" + elemento + ", categoria=" + categoria + ", salud=" + salud
				+ "]";
	}
	
	
	
	
}
