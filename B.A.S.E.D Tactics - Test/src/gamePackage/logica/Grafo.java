//En principio esta clase va a ser clave para mostrar el area en el que se puede mover la tropa
package gamePackage.logica;

import java.util.ArrayList;
import java.util.HashMap;


public class Grafo {
	ArrayList<Vertice> verts;
	HashMap<int[], Integer> aristasP;
	
	public Grafo(ArrayList<Vertice> verts, HashMap<int[], Integer> aristasP) {
		super();
		this.verts = verts;
		this.aristasP = aristasP;
	}

	public ArrayList<Vertice> getVerts() {
		return verts;
	}

	public void setVerts(ArrayList<Vertice> verts) {
		this.verts = verts;
	}

	public HashMap<int[], Integer> getAristasP() {
		return aristasP;
	}

	public void setAristasP(HashMap<int[], Integer> aristasP) {
		this.aristasP = aristasP;
	}
	
	
	
	
	
	
	
	
	
	//I don't get it
	/*
	int vert;
	private int[][] Adyacentes;
	private Object[] Informacion;
	ArrayList<Integer> peso;
	
	public Grafo(int nVert) {
		Adyacentes = new int[nVert][nVert];
		Informacion = new Object[nVert];
		for (int i = 0; i<nVert; i++) {
			for (int j = 0; j<nVert; j++) {
				Adyacentes[i][j]=0;
			}
			vert=nVert;
		}
		
	}
	*/
		
}
