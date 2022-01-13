//Este archivo es para crear funciones en un entorno separado a la ventana principal

package gamePackage.tests;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import gamePackage.logica.*;
import gamePackage.ventanas.*;
import gamePackage.ventanas.*;
import gamePackage.entidades.terrestres.*;
import gamePackage.terrenos.terrenos.*;
import gamePackage.terrenos.estructuras.*;
import gamePackage.terrenos.*;
import gamePackage.entidades.*;


public class TestingGround {
	
	

	


	
	
	public static void main(String[] args) {
		ArrayList<Vertice> ver;
		 HashMap<Point, ArrayList<ArrayList<Object>>> mapGrid = new HashMap<>();
		 ArrayList<ArrayList<Object>> casilla = new ArrayList<>();
		 ArrayList<ArrayList<Object>> casilla2 = new ArrayList<>();
		ArrayList<Object> terreno = new ArrayList<>();
		ArrayList<Object> tropa = new ArrayList<>();
		ArrayList<Object> terreno2 = new ArrayList<>();
		ArrayList<Object> tropa2 = new ArrayList<>();
		Point locate = new Point(5,3);
		Point locate2 = new Point(5,4);
		AntiA a = new AntiA(1);
		Rocl d = new Rocl(2);
		Road carretera = new Road();
		City ciudad = new City(0);
		tropa.add(a);
		terreno.add(carretera);
		tropa2.add(d);
		terreno2.add(ciudad);
		casilla.add(terreno);
		casilla.add(tropa);
		casilla2.add(terreno2);
		casilla2.add(tropa2);
		
		
		
		
		
		mapGrid.put(locate,casilla);
		mapGrid.put(locate2,casilla2);
		Tropa troop1=(Tropa)mapGrid.get(locate).get(1).get(0) ;
		Tropa troop2=(Tropa)mapGrid.get(locate2).get(1).get(0) ;
		Terreno terrein1=(Terreno)mapGrid.get(locate).get(0).get(0) ;
		Terreno terrain2=(Terreno)mapGrid.get(locate2).get(0).get(0) ;
		
		GamePlay.combat(troop1,troop2,terrain2,terrein1);
		System.out.println(troop1);
		System.out.println(troop2);
		System.out.println(troop1.getHP());
		
		
		
		for (int i = 0; i < 5; i++) {
			
			//ver.add(Vertice(1,));
			

			
			
			
		}
	}
	public static ArrayList<Point> grafoVertPos() {
		final int mov = 32;
		int tropaMov = 3;
		int veces = 1;
		Point tropaPosOG = new Point(0,0);
		Point tropaPos = tropaPosOG;					//cambiar por getPosicion de la instancia de la tropa de la que hay que sacar el area de mov
		ArrayList<Point> listaPos = new ArrayList<>();
		tropaPos.y += (tropaMov*mov);
		listaPos.add(tropaPos);
		boolean first = true;
		for (int i = 0; i < ((tropaMov*2)+1); i++) {		//for para todos los pisos (en este caso 7)
			tropaPos.y -= mov;
			tropaPos.x = tropaPosOG.x;
			listaPos.add(tropaPos);
			if (first) {
				for (int j = 0; j < veces; j++) {
					tropaPos.x += mov;
					listaPos.add(tropaPos);
				}
				tropaPos.x = tropaPosOG.x;
				for (int j = 0; j < veces; j++) {
					tropaPos.x -= mov;
					listaPos.add(tropaPos);
				}
				veces++;
			}
			if (tropaPos.y==tropaPosOG.y) first=false;
			if (!first) {
				veces = tropaMov-1;
				for (int j = 0; j < veces; j++) {
					tropaPos.x += mov;
					listaPos.add(tropaPos);
				}
				tropaPos.x = 0;
				for (int j = 0; j < veces; j++) {
					tropaPos.x -= mov;
					listaPos.add(tropaPos);
				}
				veces--;
			}
		}
		return listaPos;
	}
}


/*
Ejemplo de un grafo formado desde una tropa "." con movimiento=3 
L: linea
V: cantidad de vertices (numeros impares)
 
L V
1 1					|
2 3				  + | +
3 5			    + + | + +
4 7			  — — — · — — —
5 5				+ + | + +
6 3				  + | +
7 1					|

*/
