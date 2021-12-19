package gamePackage.entidades;
//By Dalajan
import java.awt.Point;

import gamePackage.logica.ListaArmas;
import gamePackage.logica.ListaIDTropa;
import gamePackage.logica.ListaTipos;

public class EntidadAlternativa {
	private String nombre;
	private Point pos;
	private String img;
	private ListaIDTropa idTropa;
	private ListaTipos tipoMov;
	private ListaTipos tipoTropa;
	private boolean captura;
	private boolean construye;
	private int saludMaxima;
	private int salud;
	private int golpePrim;
	private int golpeSec;
	private ListaArmas armaPrincipal;
	private ListaArmas armaSecundaria;
	private int precio;
	private int nivel;
	private int vision;
	private int alcanceMin;
	private int alcanceMax;
	private int municionesMax;
	private int municionesPrim;
	private int energiaMaxima;
	private int energia;
	private int distanciaMaxima;

	public EntidadAlternativa(String nombre, Point pos, String img, ListaIDTropa idTropa, ListaTipos tipoTropa, ListaTipos tipoMov, boolean captura, boolean construye, int saludMaxima, int salud, int golpePrim, int golpeSec, ListaArmas armaPrincipal, ListaArmas armaSecundaria, int precio, int nivel, int vision, int alcanceMin, int alcanceMax, int municionesMax, int municionesPrim, int energiaMaxima, int energia, int distanciaMaxima) {
		this.nombre = nombre;
		this.pos = pos;
		this.img = img;
		this.idTropa = idTropa;
		this.tipoTropa = tipoTropa;
		this.tipoMov = tipoMov;
		this.captura = captura;
		this.construye = construye;
		this.saludMaxima = saludMaxima;
		this.salud = salud;
		this.golpePrim = golpePrim;
		this.golpeSec = golpeSec;
		this.armaPrincipal = armaPrincipal;
		this.armaSecundaria = armaSecundaria;
		this.precio = precio;
		this.nivel = nivel;
		this.vision = vision;
		this.alcanceMin = alcanceMin;
		this.alcanceMax = alcanceMax;
		this.municionesMax = municionesMax;
		this.municionesPrim = municionesPrim;
		this.energiaMaxima = energiaMaxima;
		this.energia = energia;
		this.distanciaMaxima = distanciaMaxima;
	}

	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Point getPos() {
		return pos;
	}



	public void setPos(Point pos) {
		this.pos = pos;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public ListaIDTropa getIdTropa() {
		return idTropa;
	}



	public void setIdTropa(ListaIDTropa idTropa) {
		this.idTropa = idTropa;
	}



	public ListaTipos getTipoMov() {
		return tipoMov;
	}



	public void setTipoMov(ListaTipos tipoMov) {
		this.tipoMov = tipoMov;
	}



	public ListaTipos getTipoTropa() {
		return tipoTropa;
	}



	public void setTipoTropa(ListaTipos tipoTropa) {
		this.tipoTropa = tipoTropa;
	}



	public boolean isCaptura() {
		return captura;
	}



	public void setCaptura(boolean captura) {
		this.captura = captura;
	}



	public boolean isConstruye() {
		return construye;
	}



	public void setConstruye(boolean construye) {
		this.construye = construye;
	}



	public int getSaludMaxima() {
		return saludMaxima;
	}



	public void setSaludMaxima(int saludMaxima) {
		this.saludMaxima = saludMaxima;
	}



	public int getSalud() {
		return salud;
	}



	public void setSalud(int salud) {
		this.salud = salud;
	}



	public int getGolpePrim() {
		return golpePrim;
	}



	public void setGolpePrim(int golpePrim) {
		this.golpePrim = golpePrim;
	}



	public int getGolpeSec() {
		return golpeSec;
	}



	public void setGolpeSec(int golpeSec) {
		this.golpeSec = golpeSec;
	}



	public ListaArmas getArmaPrincipal() {
		return armaPrincipal;
	}



	public void setArmaPrincipal(ListaArmas armaPrincipal) {
		this.armaPrincipal = armaPrincipal;
	}



	public ListaArmas getArmaSecundaria() {
		return armaSecundaria;
	}



	public void setArmaSecundaria(ListaArmas armaSecundaria) {
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



	public int getAlcanceMin() {
		return alcanceMin;
	}



	public void setAlcanceMin(int alcanceMin) {
		this.alcanceMin = alcanceMin;
	}



	public int getAlcanceMax() {
		return alcanceMax;
	}



	public void setAlcanceMax(int alcanceMax) {
		this.alcanceMax = alcanceMax;
	}



	public int getMunicionesMax() {
		return municionesMax;
	}



	public void setMunicionesMax(int municionesMax) {
		this.municionesMax = municionesMax;
	}



	public int getMunicionesPrim() {
		return municionesPrim;
	}



	public void setMunicionesPrim(int municionesPrim) {
		this.municionesPrim = municionesPrim;
	}



	public int getEnergiaMaxima() {
		return energiaMaxima;
	}



	public void setEnergiaMaxima(int energiaMaxima) {
		this.energiaMaxima = energiaMaxima;
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



	public boolean atacaA(ListaTipos tipoTropa) {
		boolean target;
		switch (this.idTropa) {
		case INF_FOOT:
		case INF_MECH: 
		case INF_BIKE:
		case V_RECON:
			switch (tipoTropa) {
			case AEREAA:
			case MARINA:
			case SUBMARINA:
				target = false;
				break;
			default:
				target = true;
				break;
			}
			break;
			
		case ANTI_A:
			switch (tipoTropa) {
			case MARINA:
			case SUBMARINA:
				target = false;
				break;
			default:
				target = true;
				break;
			}
		case TANK_L:
		case TANK_M:
		case TANK_H:
			switch (tipoTropa) {
			case AEREAA:
			case SUBMARINA:
				target = false;
				break;
			default:
				target = true;
				break;
			}
		case ARTY:
		case ROCL:
			switch (tipoTropa) {
			case SUBMARINA:
			case AEREAA:
			case AEREAH:
				target = false;
				break;
			default:
				target = true;
				break;
			}
		case MISL:
			switch (tipoTropa) {
			case AEREAH:
			case AEREAA:
				target = true;
				break;
			default:
				target = false;
				break;
			}
		case V_APC:
			switch (tipoTropa) {
			default:
				target = false;
				break;
				}
		default:
			target = false;
		}
	return target;
	}

	@Override
	public String toString() {
		return "Entidad [nombre=" + nombre + ", pos=" + pos + ", img=" + img + ", idTropa=" + idTropa + ", tipoMov="
				+ tipoMov + ", tipoTropa=" + tipoTropa + ", captura=" + captura + ", construye=" + construye
				+ ", saludMaxima=" + saludMaxima + ", salud=" + salud + ", golpePrim=" + golpePrim + ", golpeSec="
				+ golpeSec + ", armaPrincipal=" + armaPrincipal + ", armaSecundaria=" + armaSecundaria + ", precio="
				+ precio + ", nivel=" + nivel + ", vision=" + vision + ", alcanceMin=" + alcanceMin + ", alcanceMax="
				+ alcanceMax + ", municionesMax=" + municionesMax + ", municionesPrim=" + municionesPrim
				+ ", energiaMaxima=" + energiaMaxima + ", energia=" + energia + ", distanciaMaxima=" + distanciaMaxima
				+ "]";
	}
	

	
	
}
