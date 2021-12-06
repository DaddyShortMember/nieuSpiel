package gamePackage;

import java.awt.*;
import java.util.ArrayList;

public class Vertice {
	int id;
	ArrayList<Integer> conexiones;
	Dimension pos;
	public Vertice(int id, ArrayList<Integer> conexiones, Dimension pos) {
		super();
		this.id = id;
		this.conexiones = conexiones;
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getConexiones() {
		return conexiones;
	}
	public void setConexiones(ArrayList<Integer> conexiones) {
		this.conexiones = conexiones;
	}
	
}
