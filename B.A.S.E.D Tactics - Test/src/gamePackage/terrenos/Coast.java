package gamePackage;

public class Coast implements Terreno {
	
	// Atributos Logicos
		ListaIDTerreno idTerreno = ListaIDTerreno.COAST;
		boolean construibleSobre = true;
		int defensa = 0;
		// Atributos Fisicos
		String nombre = "Costa";
		int posX = 0;
		int posY = 0;
		String imagen = "";
		
		//Constructor
		public Coast(int posX, int posY) {
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
				peaje = 1;
				break;
			case V_LIGERO:
				peaje = 1;
				break;
			case V_PESADO:
				peaje = 2;
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
