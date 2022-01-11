package gamePackage.entidades.aereas;

import java.awt.Point;

import gamePackage.entidades.Tropa;
import gamePackage.logica.ListaArmas;
import gamePackage.logica.ListaIDTropa;
import gamePackage.logica.ListaTipos;

public class ABomber implements Tropa{
	//ATRIBUTOS LÃ“GICOS
	int team;
	ListaIDTropa idTropa = ListaIDTropa.A_BOMBER;
	ListaTipos tipoTropa = ListaTipos.AEREAH;
	ListaTipos tipoMov = ListaTipos.AEREO;
	boolean captura = false;
	boolean construye = false;
	int saludMaxima = 350;
	int salud = this.saludMaxima;
	int golpePrim = 300;
	int golpeSec = 0;
	ListaArmas armaPrincipal = ListaArmas.BOMBA;
	ListaArmas armaSecundaria = ListaArmas.NADA;
	int precio = 20000;
	int nivel = 0;
	int vision = 3;
	int alcanceMin = 1;
	int alcanceMax = this.alcanceMin;
	int municionesMax = 6;
	int municionesPrim = this.municionesMax;
	int energiaMaxima = 99;
	int energia = this.energiaMaxima;
	int distanciaMaxima = 8;
	
	//ATRIBUTOS FÃ�SICOS
	String nombre = "Bombardero";
	Point pos = new Point(0,0); //Posicion
	String imagen = ""; //DirecciÃ³n de imagen
	
	//Constructor
	public ABomber(int team) {
		super();
		this.team = team;
	}
	
	//ToString
	@Override
	public String toString() {
		return "ABomber [idTropa=" + idTropa + ", tipoTropa=" + tipoTropa + ", tipoMov=" + tipoMov + ", captura="
				+ captura + ", construye=" + construye + ", saludMaxima=" + saludMaxima + ", salud=" + salud
				+ ", golpePrim=" + golpePrim + ", golpeSec=" + golpeSec + ", armaPrincipal=" + armaPrincipal
				+ ", armaSecundaria=" + armaSecundaria + ", precio=" + precio + ", nivel=" + nivel + ", vision="
				+ vision + ", alcanceMin=" + alcanceMin + ", alcanceMax=" + alcanceMax + ", municionesMax="
				+ municionesMax + ", municionesPrim=" + municionesPrim + ", energiaMaxima=" + energiaMaxima
				+ ", energia=" + energia + ", distanciaMaxima=" + distanciaMaxima + ", nombre=" + nombre + ", pos="
				+ pos  + ", imagen=" + imagen + "]";
	}
	
	//Metodos Heredados
	public void setTropa(Point pos, String imagen) {
		// TODO Auto-generated method stub
		this.pos = pos;
		this.imagen = imagen;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		//If(posY <= limYsup && posX <= limXsup || posY >= limYinf && posX >= limXinf)
		this.pos = pos;
		//else{ Logger? }
	}

	public void setImagen(String imagen) {
		// TODO Auto-generated method stub
		this.imagen = imagen;
	}

	public void setSalud(int salud) {
		// TODO Auto-generated method stub
		if(salud <= saludMaxima)
			this.salud = salud;
		else {
			//Logger?
		}
	}

	public void setEnergia(int energia) {
		// TODO Auto-generated method stub
		if(energia <= energiaMaxima)
			this.energia = energia;
		else {
			//Logger?
		}
	}

	public void setMuniciones(int municiones) {
		// TODO Auto-generated method stub
		if(municiones <= municionesMax)
			this.municionesPrim = municiones;
		else {
			//Logger?
		}
	}

	public void setNivel(int nivel) {
		// TODO Auto-generated method stub
		this.nivel = nivel;
	}
		//Getters
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public ListaIDTropa getIDTropa() {
		// TODO Auto-generated method stub
		return idTropa;
	}

	public ListaTipos getTipoTropa() {
		// TODO Auto-generated method stub
		return tipoTropa;
	}

	public ListaTipos getTipoMov() {
		// TODO Auto-generated method stub
		return tipoMov;
	}

	public ListaArmas[] getArmas() {
		ListaArmas[] armas = new ListaArmas[2];
		armas[0] = armaPrincipal;
		armas[1] = armaSecundaria;
		// TODO Auto-generated method stub
		return armas;
	}

	public boolean getCaptura() {
		// TODO Auto-generated method stub
		return captura;
	}

	public int getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	public boolean getConstruye() {
		// TODO Auto-generated method stub
		return construye;
	}

	public int getSalud() {
		// TODO Auto-generated method stub
		return salud;
	}

	public int getGolpePrim() {
		// TODO Auto-generated method stub
		return golpePrim;
	}

	public int getGolpeSec() {
		// TODO Auto-generated method stub
		return golpeSec;
	}

	public int getDistMax() {
		// TODO Auto-generated method stub
		return distanciaMaxima;
	}

	public int getEnergia() {
		// TODO Auto-generated method stub
		return energia;
	}

	public int[] getAlcance() {
		int[] alc = new int[2];
		alc[0] = alcanceMin;
		alc[1] = alcanceMax;
		// TODO Auto-generated method stub
		return alc;
	}

	public int getMuniciones() {
		// TODO Auto-generated method stub
		return municionesPrim;
	}

	public int getVision() {
		// TODO Auto-generated method stub
		return vision;
	}

	public int getNivel() {
		// TODO Auto-generated method stub
		return nivel;
	}

		//Metodos Logicos
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

	//Metodos Inutiles Para Esta Tropa
	public void setTipoMov(ListaTipos tipoMov) {
		// TODO Auto-generated method stub
		//Nada
	}
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

	public int getSaludMax() {
		// TODO Auto-generated method stub
		return saludMaxima;
	}

	public int getEnergiaMax() {
		// TODO Auto-generated method stub
		return energiaMaxima;
	}

	public int getMunicionesMax() {
		// TODO Auto-generated method stub
		return municionesMax;
	}
	public boolean necesitaSuministro() {
		if(this.municionesPrim < this.municionesMax || this.salud < this.saludMaxima || this.energia < this.energiaMaxima) {
			return true;
		}else
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
	public void setTropa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImagen() {
		// TODO Auto-generated method stub
		
	}

}
