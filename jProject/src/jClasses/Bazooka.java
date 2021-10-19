package jClasses;

public class Bazooka extends InfPesada{

	public Bazooka() {
		super();
		// TODO Auto-generated constructor stub
		this.nombre = "Soldado Cohete";
		this.elemento = "Tierra";
		this.categoria = "Infanteria";
		this.especialidad = "Ataque";
		this.tipo = "Pesada";
		this.salud = 100.0;
		this.armadura = 100.0;
		this.golpe = 100.0;
	}

	public Bazooka(String nombre, String elemento, String categoria, Double salud, Double golpe, Double armadura,
			String tipo, String especialidad, String efectivo, String nemesis, String mediocre) {
		super(nombre, elemento, categoria, salud, golpe, armadura, tipo, especialidad, efectivo, nemesis, mediocre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bazooka [efectivo=" + efectivo + ", nemesis=" + nemesis + ", mediocre=" + mediocre + ", tipo=" + tipo
				+ ", especialidad=" + especialidad + ", nombre=" + nombre + ", elemento=" + elemento + ", categoria="
				+ categoria + ", salud=" + salud + ", golpe=" + golpe + ", armadura=" + armadura + "]";
	}

	
}
