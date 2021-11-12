package gamePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTests {

	@Test
	public void testGetEnergia() {
		System.out.println("INICIO TEST GETENERGIA");
		InfFoot x = new InfFoot();
		int energy = x.getEnergia();
		System.out.println("FIN TEST GETENERGIA");
		assertEquals(x.energiaMaxima, energy);
	}
	
	@Test
	public void testGetPeaje() {
		System.out.println("INICIO TEST GETPEAJE");
		InfFoot x = new InfFoot();
		Plains y = new Plains();
		int peaj = y.getPeaje(x);
		System.out.println("FIN TEST GETPEAJE");
		assertEquals(1, peaj);

	}
	
	@Test //Test para ver si furrula el setEnergia();
	public void testSetEnergia() {
		System.out.println("INICIO TEST SETENERGIA");
		InfFoot x = new InfFoot();
		Mountain y = new Mountain();
		System.out.println(x.getEnergia());
		x.setEnergia(x.energia - y.getPeaje(x));
		System.out.println(x.getEnergia());
		System.out.println("FIN TEST SETENERGIA");
		assertEquals(x.getEnergiaMax() - y.getPeaje(x), x.getEnergia());
	}
	
	@Test //Test para ver si 
	public void testSetSalud() {
		InfFoot x = new InfFoot();
		InfMech y = new InfMech();
		Mountain z = new Mountain();
		int xG = x.getGolpeSec();
		//Sistema de combate primitivo.
		if(x.idTropa == y.idTropa) {
			if(z.getDefensa() == 0) {		
			}
			else
				xG = xG/(z.getDefensa() * 2);
		}
		if(z.getDefensa() == 0) {
		}
		else
			xG = (xG + x.getSalud())/(z.getDefensa());
		System.out.println("DMG == " + xG);
		while(y.salud > 0) {
			System.out.println("Was " + y.getSalud() + " HP");
			y.setSalud(y.salud - xG);
			System.out.println("Is " + y.getSalud() + " HP");
		}
		boolean itworks;
		if(y.salud <= 0)
			itworks = true;
		else
			itworks = false;
		assertEquals(true, itworks);
	}
	
	@Test
	public void testSuministra() {
		System.out.println("INICIO TEST DE SUMINISTRO");
		boolean itworks = false;
		InfMech x = new InfMech();
		Hq y = new Hq();
		
		x.setSalud(20);
		x.setMuniciones(1);
		System.out.println(x.getEnergia() + " " + x.getSalud() + " " + x.getMuniciones());
		System.out.println(y.suministra(x));
		System.out.println(x.necesitaSuministro());
		if(y.suministra(x) == true && x.necesitaSuministro() == true) {
			
			itworks = true;
			
		}
		
		System.out.println("FIN TEST DE SUMINISTRO");
		assertEquals(true, itworks);
	}

}
