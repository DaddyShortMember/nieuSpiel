package gamePackage.terrenos.terrenos;

import java.awt.Point;

import gamePackage.entidades.Tropa;
import gamePackage.logica.*;
import gamePackage.terrenos.Terreno;

public class Bridge implements Terreno {

	// Atributos Logicos
	ListaIDTerreno idTerreno = ListaIDTerreno.BRIDGE;
	boolean construibleSobre = false;
	int defensa = 0;
	// Atributos Fisicos
	String nombre = "Puente";
	Point pos = new Point(0, 0);
	String imagen = ""; //Imagen cambia en base a direccion.

	// Constructor
	public Bridge(Point pos, String imagen) {
		super();
		this.pos = pos;
		this.imagen = imagen;
	}

	@Override
	public Point getPos() {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public int getPeaje(Tropa trop) {
		int peaje = 0;
		switch (trop.getTipoMov()) {
		case INFANTERIA:
			peaje = 1;
			break;
		case V_LIGERO:
			peaje = 1;
			break;
		case V_PESADO:
			peaje = 1;
			break;
		case ACORAZADO:
			peaje = 1;
			break;
		case AEREO:
			peaje = 1;
			break;
		case MECH:
			peaje = 1;
			break;
		case ACUATICO:
			peaje = 1;
			break;
		case SUBACUATICO:
			peaje = 1;
			break;
		default:
			peaje = 0;
			break;

		}
		// Switch en vez de if-else if-else
		return peaje;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public ListaIDTerreno getIDTerreno() {
		// TODO Auto-generated method stub
		return idTerreno;
	}

	@Override
	public int getDefensa() {
		// TODO Auto-generated method stub
		return defensa;
	}

	@Override
	public boolean getConstSobre() {
		// TODO Auto-generated method stub
		return construibleSobre;
	}

}
