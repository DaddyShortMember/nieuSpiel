package jClasses;

public abstract class InfLigera extends Infanteria {

	String efectivo;
	String nemesis;
	String mediocre;
	
	
	public InfLigera(String nombre, String elemento, String categoria, Double salud, Double golpe, Double armadura,
			String tipo, String especialidad, String efectivo, String nemesis, String mediocre) {
		super(nombre, elemento, categoria, salud, golpe, armadura, tipo, especialidad);
		this.efectivo = efectivo;
		this.nemesis = nemesis;
		this.mediocre = mediocre;
	}
	
	public InfLigera() {
		this.efectivo = "";
		this.nemesis = "";
		this.mediocre = "";
	}


	public String getEfectivo() {
		return efectivo;
	}


	public void setEfectivo(String efectivo) {
		this.efectivo = efectivo;
	}


	public String getNemesis() {
		return nemesis;
	}


	public void setNemesis(String nemesis) {
		this.nemesis = nemesis;
	}


	public String getMediocre() {
		return mediocre;
	}


	public void setMediocre(String mediocre) {
		this.mediocre = mediocre;
	}
	
	
	
	
	
}
