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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTipoMov(ListaTipos tipoMov) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTipoTropa(ListaTipos tipoTropa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSalud(int salud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnergia(int energia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMuniciones(int municiones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNivel(int nivel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaIDTropa getIDTropa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaTipos getTipoTropa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaTipos getTipoMov() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaArmas[] getArmas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCaptura() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getConstruye() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGolpePrim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGolpeSec() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDistMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getAlcance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMuniciones() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVision() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNivel() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

