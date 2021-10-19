package jClasses;

public abstract class InfPesada extends Infanteria{

	String efectivo;
	String nemesis;
	String mediocre;
	
	public InfPesada(String nombre, String elemento, String categoria, Double salud, Double golpe, Double armadura,
			String tipo, String especialidad, String efectivo, String nemesis, String mediocre) {
		super(nombre, elemento, categoria, salud, golpe, armadura, tipo, especialidad);
		this.efectivo = efectivo;
		this.nemesis = nemesis;
		this.mediocre = mediocre;
	}
	
	public InfPesada() {
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

	@Override
	public String toString() {
		return "InfPesada [efectivo=" + efectivo + ", nemesis=" + nemesis + ", mediocre=" + mediocre + "]";
	}
	
	
	

}
