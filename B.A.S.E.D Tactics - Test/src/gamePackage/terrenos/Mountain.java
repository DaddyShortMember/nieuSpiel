package gamePackage.terrenos;
import gamePackage.entidades.Tropa;
import gamePackage.logica.*;


public class Mountain implements Terreno {
	
	//Atributos Logicos
			ListaIDTerreno idTerreno = ListaIDTerreno.MOUNTAIN;
			boolean construibleSobre = false;
			int defensa = 4;
			//Atributos Fisicos
			String nombre = "Monte";
			int posX = 0;
			int posY = 0;
			String imagen = "";
			
			//Constructor
			public Mountain(int posX, int posY) {
				super();
				this.posX = posX;
				this.posY = posY;
			}
			
			@Override
			public void setTerreno(String imagen, int posX, int posY) {
				// TODO Auto-generated method stub
				this.posX = posX;
				this.posY = posY;
				this.imagen = imagen;
				
			}

			@Override
			public int[] getPos() {
				int[] pos = new int[2];
				pos[0] = posX;
				pos[1] = posY;
				// TODO Auto-generated method stub
				return pos;
			}

			@Override
			public void setPos(int posX, int posY) {
				// TODO Auto-generated method stub
				this.posX = posX;
				this.posY = posY;
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
				case INFANTERIA:
					peaje = 2;
					break;
				case AEREO:
					peaje = 1;
					break;
				case MECH:
					peaje = 1;
					break;
				default:
					peaje = 0;
					break;
					
				}
				//Switch en vez de if-else if-else
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
