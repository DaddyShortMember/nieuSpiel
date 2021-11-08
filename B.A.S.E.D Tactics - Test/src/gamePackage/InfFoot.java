package gamePackage;

public class InfFoot implements Tropa {
	
	int posX = 0; //Posicion en eje X
	int posY = 0; //Posicion en eje Y
	String imagen = ""; //Direccion de imagen

	@Override
	public void setTropa(int posX, int posY, String imagen) {
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
		return pos;
	}

	@Override
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		
	}

	@Override
	public void setImagen(String imagen) {
		// TODO Auto-generated method stub
		this.imagen = imagen;
		
	}
	
}

