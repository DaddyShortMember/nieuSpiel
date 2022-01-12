package gamePackage.entidades.terrestres;

import java.awt.Point;

import gamePackage.entidades.Tropa;
import gamePackage.logica.*;

public class Rocl implements Tropa {

	// ATRIBUTOS LOGICOS
	int team;
	ListaIDTropa idTropa = ListaIDTropa.ROCL;
	ListaTipos tipoTropa = ListaTipos.TERRESTRE;
	ListaTipos tipoMov = ListaTipos.V_PESADO;
	ListaBlindaje tipoBlindage = ListaBlindaje.VH_L;
	boolean captura = false;
	boolean construye = false;
	int saludMaxima = 140;
	float salud = this.saludMaxima;
	int golpePrim = 185;
	int golpeSec = 0;
	ListaArmas armaPrincipal = ListaArmas.COHETE;
	ListaArmas armaSecundaria = ListaArmas.NADA;
	int precio = 15000;
	int nivel = 0;
	int vision = 3;
	int alcanceMin = 3;
	int alcanceMax = 5;
	int municionesMax = 5;
	int municionesPrim = this.municionesMax;
	int energiaMaxima = 50;
	int energia = this.energiaMaxima;
	int distanciaMaxima = 5;

	// ATRIBUTOS FISICOS
	String nombre = "Tiracohetes";
	Point pos = new Point(0, 0); // Posicion
	String imagen = ""; // Dirección de imagen

	// Constructor
	public Rocl(int team) {
		super();
		this.team = team;
	}

	// ToString
	@Override
	public String toString() {
		return "Rocl [idTropa=" + idTropa + ", tipoTropa=" + tipoTropa + ", tipoMov=" + tipoMov + ", captura=" + captura
				+ ", construye=" + construye + ", saludMaxima=" + saludMaxima + ", salud=" + salud + ", golpePrim="
				+ golpePrim + ", golpeSec=" + golpeSec + ", armaPrincipal=" + armaPrincipal + ", armaSecundaria="
				+ armaSecundaria + ", precio=" + precio + ", nivel=" + nivel + ", vision=" + vision + ", alcanceMin="
				+ alcanceMin + ", alcanceMax=" + alcanceMax + ", municionesMax=" + municionesMax + ", municionesPrim="
				+ municionesPrim + ", energiaMaxima=" + energiaMaxima + ", energia=" + energia + ", distanciaMaxima="
				+ distanciaMaxima + ", nombre=" + nombre + ", pos=" + pos + ", imagen=" + imagen + "]";
	}

	// Metodos Heredados
	public float getHP() {
		float percent = (getSalud()*getSaludMax())/(100);
		return percent;
		 
	}
	// Setters
	@Override
	public void setTropa() {
		// TODO Auto-generated method stub
	}

	@Override
	public Point getPos() {
		return pos;
	}

	@Override
	public void setPos() {
		// If(posY <= limYsup && posX <= limXsup || posY >= limYinf && posX >= limXinf)
		// else{ Logger? }
	}

	@Override
	public void setImagen() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSalud(int salud) {
		// TODO Auto-generated method stub
		if (salud <= saludMaxima)
			this.salud = salud;
		else {
			// Logger?
		}
	}

	@Override
	public void setEnergia(int energia) {
		// TODO Auto-generated method stub
		if (energia <= energiaMaxima)
			this.energia = energia;
		else {
			// Logger?
		}
	}

	@Override
	public void setMuniciones(int municiones) {
		// TODO Auto-generated method stub
		if (municiones <= municionesMax)
			this.municionesPrim = municiones;
		else {
			// Logger?
		}
	}

	@Override
	public void setNivel(int nivel) {
		// TODO Auto-generated method stub
		this.nivel = nivel;
	}

	// Getters
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
	public float getSalud() {
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

	// Metodos Logicos
	@Override
	public boolean atacaA(ListaTipos tipoTropa) {
		// TODO Auto-generated method stub
		boolean target;
		switch (tipoTropa) {
		case AEREO:
			target = true;
			break;
		case ACORAZADO:
			target = true;
			break;
		case V_LIGERO:
			target = true;
			break;
		case V_PESADO:
			target = true;
			break;
		case ACUATICO:
			target = false;
			break;
		case SUBACUATICO:
			target = false;
			break;
		case INFANTERIA:
			target = true;
			break;
		default:
			target = false;
		}

		return target;
	}

	// Metodos Inutiles Para Esta Tropa
	@Override
	public void setTipoMov(ListaTipos tipoMov) {
		// TODO Auto-generated method stub
		// Nada
	}

	@Override
	public void setTipoTropa(ListaTipos tipoTropa) {
		// TODO Auto-generated method stub
		// Nada
	}

	// Metodos Unicos Para Esta Tropa
	// Setters
	public void setVision(int vis) {
		this.vision = vis;
	}
	// Getters

	@Override
	public int getSaludMax() {
		// TODO Auto-generated method stub
		return saludMaxima;
	}

	@Override
	public int getEnergiaMax() {
		// TODO Auto-generated method stub
		return energiaMaxima;
	}

	@Override
	public int getMunicionesMax() {
		// TODO Auto-generated method stub
		return municionesMax;
	}

	@Override
	public boolean necesitaSuministro() {
		if (this.municionesPrim < this.municionesMax || this.salud < this.saludMaxima
				|| this.energia < this.energiaMaxima) {
			return true;
		} else
			return false;
	}

	@Override
	public void setTeam(int team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTeam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListaBlindaje getBlindaje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSalud(float f) {
		// TODO Auto-generated method stub
		
	}

}
