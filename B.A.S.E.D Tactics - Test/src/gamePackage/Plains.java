package gamePackage;

public class Plains implements Terreno {
	
	//Atributos Logicos
	ListaIDTerreno idTerreno = ListaIDTerreno.PLAINS;
	boolean construibleSobre = true;
	int peaje = 0;
	int defensa = 1;
	//Atributos Fisicos
	String nombre = "Llanuras";
	int posX = 0;
	int posY = 0;
	String imagen = "";
	
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
	public int getPeaje(ListaTipos trop) {
		int peaje = 0;
		switch (trop) {
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
		default:
			peaje = 9999;
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
		return null;
	}

	@Override
	public int getDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getConstSobre() {
		// TODO Auto-generated method stub
		return false;
	}

}
