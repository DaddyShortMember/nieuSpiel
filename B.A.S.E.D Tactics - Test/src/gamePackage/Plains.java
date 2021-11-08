package gamePackage;

public class Plains implements Terreno {
	
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
	public int getPos() {
		int[] pos = new int[2];
		pos[0] = posX;
		pos[1] = posY;
		// TODO Auto-generated method stub
		return 0;
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
	public int getPeaje() {
		int peaje = 0;
		//Switch en vez de if-else if-else
		return peaje;
	}

}
