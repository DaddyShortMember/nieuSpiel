package gamePackage;

public class Hq implements Estructura {
	
	int posX = 0;
	int posY = 0;
	String imagen = "";
	int ingresos = 0;

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

	@Override
	public boolean getCapturable() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getFabrica() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getCG() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIngresos(int ingresos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIngresos() {
		return ingresos;
		// TODO Auto-generated method stub
		
	}

}
