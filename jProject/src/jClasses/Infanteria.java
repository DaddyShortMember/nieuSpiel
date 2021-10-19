package jClasses;

public abstract class Infanteria extends Tropa {
	
	String tipo;
	String especialidad;
	
	
	public Infanteria(String nombre, String elemento, String categoria, Double salud, Double golpe, Double armadura,
			String tipo, String especialidad) {
		super(nombre, elemento, categoria, salud, golpe, armadura);
		this.tipo = tipo;
		this.especialidad = especialidad;
	}
	
	public Infanteria() {
		this.tipo = "";
		this.especialidad = "";
	}



	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public String toString() {
		return "Infanteria [tipo=" + tipo + ", especialidad=" + especialidad + "]";
	}
	
	
	
	

}
