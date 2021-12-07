package gamePackage.entidades;

import gamePackage.logica.*;

public class AHelit implements Tropa{
	
	//ATRIBUTOS LÃ“GICOS
		ListaIDTropa idTropa = ListaIDTropa.A_HELIT;
		ListaTipos tipoTropa = ListaTipos.AEREA;
		ListaTipos tipoMov = ListaTipos.AEREO;
		boolean captura = false;
		boolean construye = false;
		int saludMaxima = 200;
		int salud = this.saludMaxima;
		int golpePrim = 0;
		int golpeSec = 0;
		ListaArmas armaPrincipal = ListaArmas.NADA;
		ListaArmas armaSecundaria = ListaArmas.NADA;
		int precio = 5000;
		int nivel = 0;
		int vision = 1;
		int alcanceMin = 0;
		int alcanceMax = this.alcanceMin;
		int municionesMax = 0;
		int municionesPrim = this.municionesMax;
		int energiaMaxima = 99;
		int energia = this.energiaMaxima;
		int distanciaMaxima = 6;
		
		//ATRIBUTOS FÃ�SICOS
		String nombre = "Helicoptero Transporte";
		int posX = 0; //PosiciÃ³n en eje X
		int posY = 0; //PosiciÃ³n en eje y
		String imagen = ""; //DirecciÃ³n de imagen
		
		//Constructor
		public AHelit(String nombre, int posX, int posY, String imagen) {
			super();
			this.nombre = nombre;
			this.posX = posX;
			this.posY = posY;
			this.imagen = imagen;
		}
		
		//ToString
		@Override
		public String toString() {
			return "AHelit [idTropa=" + idTropa + ", tipoTropa=" + tipoTropa + ", tipoMov=" + tipoMov + ", captura="
					+ captura + ", construye=" + construye + ", saludMaxima=" + saludMaxima + ", salud=" + salud
					+ ", golpePrim=" + golpePrim + ", golpeSec=" + golpeSec + ", armaPrincipal=" + armaPrincipal
					+ ", armaSecundaria=" + armaSecundaria + ", precio=" + precio + ", nivel=" + nivel + ", vision="
					+ vision + ", alcanceMin=" + alcanceMin + ", alcanceMax=" + alcanceMax + ", municionesMax="
					+ municionesMax + ", municionesPrim=" + municionesPrim + ", energiaMaxima=" + energiaMaxima
					+ ", energia=" + energia + ", distanciaMaxima=" + distanciaMaxima + ", nombre=" + nombre + ", posX="
					+ posX + ", posY=" + posY + ", imagen=" + imagen + "]";
		}
		
		//Metodos Heredados
		//Setters
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
			//If(posY <= limYsup && posX <= limXsup || posY >= limYinf && posX >= limXinf)
			this.posX = posX;
			this.posY = posY;
			//else{ Logger? }
		}

		@Override
		public void setImagen(String imagen) {
			// TODO Auto-generated method stub
			this.imagen = imagen;
		}

		@Override
		public void setSalud(int salud) {
			// TODO Auto-generated method stub
			if(salud <= saludMaxima)
				this.salud = salud;
			else {
				//Logger?
			}
		}

		@Override
		public void setEnergia(int energia) {
			// TODO Auto-generated method stub
			if(energia <= energiaMaxima)
				this.energia = energia;
			else {
				//Logger?
			}
		}

		@Override
		public void setMuniciones(int municiones) {
			// TODO Auto-generated method stub
			if(municiones <= municionesMax)
				this.municionesPrim = municiones;
			else {
				//Logger?
			}
		}

		@Override
		public void setNivel(int nivel) {
			// TODO Auto-generated method stub
			this.nivel = nivel;
		}
			//Getters
		@Override
		public String getNombre() {
			// TODO Auto-generated method stub
			return nombre;
		}

		@Override
		public ListaIDTropa getIDTropa() {
			// TODO Auto-generated method stub
			return idTropa;
		}

		@Override
		public ListaTipos getTipoTropa() {
			// TODO Auto-generated method stub
			return tipoTropa;
		}

		@Override
		public ListaTipos getTipoMov() {
			// TODO Auto-generated method stub
			return tipoMov;
		}

		@Override
		public ListaArmas[] getArmas() {
			ListaArmas[] armas = new ListaArmas[2];
			armas[0] = armaPrincipal;
			armas[1] = armaSecundaria;
			// TODO Auto-generated method stub
			return armas;
		}

		@Override
		public boolean getCaptura() {
			// TODO Auto-generated method stub
			return captura;
		}

		@Override
		public int getPrecio() {
			// TODO Auto-generated method stub
			return precio;
		}

		@Override
		public boolean getConstruye() {
			// TODO Auto-generated method stub
			return construye;
		}

		@Override
		public int getSalud() {
			// TODO Auto-generated method stub
			return salud;
		}

		@Override
		public int getGolpePrim() {
			// TODO Auto-generated method stub
			return golpePrim;
		}

		@Override
		public int getGolpeSec() {
			// TODO Auto-generated method stub
			return golpeSec;
		}

		@Override
		public int getDistMax() {
			// TODO Auto-generated method stub
			return distanciaMaxima;
		}

		@Override
		public int getEnergia() {
			// TODO Auto-generated method stub
			return energia;
		}

		@Override
		public int[] getAlcance() {
			int[] alc = new int[2];
			alc[0] = alcanceMin;
			alc[1] = alcanceMax;
			// TODO Auto-generated method stub
			return alc;
		}

		@Override
		public int getMuniciones() {
			// TODO Auto-generated method stub
			return municionesPrim;
		}

		@Override
		public int getVision() {
			// TODO Auto-generated method stub
			return vision;
		}

		@Override
		public int getNivel() {
			// TODO Auto-generated method stub
			return nivel;
		}

			//Metodos Logicos
		@Override
		public boolean atacaA(ListaTipos tipoTropa) {
			// TODO Auto-generated method stub
			boolean target;
			switch (tipoTropa) {
			case AEREO:
				target = true;
				break;
			case ACORAZADO:
				target = true;
				break;
			case V_LIGERO:
				target = true;
				break;
			case V_PESADO:
				target = true;
				break;
			case ACUATICO:
				target = false;
				break;
			case SUBACUATICO:
				target = false;
				break;
			case INFANTERIA:
				target = true;
				break;
			default:
				target = false;
			}
			
			return target;
		}

		//Metodos Inutiles Para Esta Tropa
		@Override
		public void setTipoMov(ListaTipos tipoMov) {
			// TODO Auto-generated method stub
			//Nada
		}
		@Override
		public void setTipoTropa(ListaTipos tipoTropa) {
			// TODO Auto-generated method stub
			//Nada
		}

		//Metodos Unicos Para Esta Tropa
			//Setters
		public void setVision(int vis) {
			this.vision = vis;
		}
			//Getters

		@Override
		public int getSaludMax() {
			// TODO Auto-generated method stub
			return saludMaxima;
		}

		@Override
		public int getEnergiaMax() {
			// TODO Auto-generated method stub
			return energiaMaxima;
		}

		@Override
		public int getMunicionesMax() {
			// TODO Auto-generated method stub
			return municionesMax;
		}
		@Override
		public boolean necesitaSuministro() {
			if(this.municionesPrim < this.municionesMax || this.salud < this.saludMaxima || this.energia < this.energiaMaxima) {
				return true;
			}else
			return false;
		}

}
