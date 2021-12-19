package gamePackage.terrenos.terrenos;

import java.awt.Point;

import gamePackage.entidades.Tropa;
import gamePackage.logica.*;
import gamePackage.terrenos.Terreno;

public class Archipelago implements Terreno {

	// Atributos Logicos
	ListaIDTerreno idTerreno = ListaIDTerreno.ARCHIPELAGO;
	boolean construibleSobre = false;
	int defensa = 2;
	// Atributos Fisicos
	String nombre = "Archipielago";
	Point pos = new Point(0, 0);
	String imagen = ""; //Imagen predeterminada

	// Constructor
	public Archipelago(Point pos) {
		super();
		this.pos = pos;
	}

	@Override
	public void setTerreno(Point pos, String imagen) {
		// TODO Auto-generated method stub
		this.pos = pos;
		this.imagen = imagen;

	}

	@Override
	public Point getPos() {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public void setPos(Point pos) {
		// TODO Auto-generated method stub
		this.pos = pos;
	}

	@Override
	public void setImagen(String imagen) {
		// TODO Auto-generated method stub
		this.imagen = imagen;
	}

	@Override
	public int getPeaje(Tropa trop) {
		int peaje = 0;
		switch (trop.getTipoMov()) {
		case AEREO:
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
