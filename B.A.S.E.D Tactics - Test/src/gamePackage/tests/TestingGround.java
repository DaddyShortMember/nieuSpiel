//Este archivo es para crear funciones en un entorno separado a la ventana principal

package gamePackage.tests;

import java.awt.*;
import java.util.ArrayList;

import gamePackage.logica.*;

public class TestingGround {
	public static void main(String[] args) {
		ArrayList<Vertice> ver;
		
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
