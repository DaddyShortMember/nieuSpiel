package jClasses;

public class Raso extends InfLigera {


	public Raso(String nombre, String elemento, String categoria, Double salud, Double golpe, Double armadura,
			String tipo, String especialidad, String efectivo, String nemesis, String mediocre) {
		super(nombre, elemento, categoria, salud, golpe, armadura, tipo, especialidad, efectivo, nemesis, mediocre);
		this.nombre = "Soldado Raso";
		this.elemento = "Tierra";
		this.categoria = "Infanteria";
		this.especialidad = "Ataque";
		this.tipo = "Infanteria";
		this.salud = 100.0;
		this.armadura = 50.0;
		this.golpe = 50.0;
		// TODO Auto-generated constructor stub
	}

	public Raso() {
		this.nombre = "Soldado Raso";
		this.elemento = "Tierra";
		this.categoria = "Infanteria";
		this.especialidad = "Ataque";
		this.tipo = "Infanteria";
		this.salud = 100.0;
		this.armadura = 50.0;
		this.golpe = 50.0;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Raso [efectivo=" + efectivo + ", nemesis=" + nemesis + ", mediocre=" + mediocre + ", tipo=" + tipo
				+ ", especialidad=" + especialidad + ", nombre=" + nombre + ", elemento=" + elemento + ", categoria="
				+ categoria + ", salud=" + salud + ", golpe=" + golpe + ", armadura=" + armadura + "]";
	}
	
}
