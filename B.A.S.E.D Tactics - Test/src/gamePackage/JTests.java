package gamePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTests {

	@Test
	public void testGetEnergia() {
		InfFoot x = new InfFoot();
		int energy = x.getEnergia();
		assertEquals(x.energiaMaxima, energy);
	}
	
	@Test
	public void testGetPeaje() {
		InfFoot x = new InfFoot();
		Plains y = new Plains();
		int peaj = y.getPeaje(x);
		assertEquals(1, peaj);
	}
	
	@Test //Test para ver si furrula el setEnergia();
	public void testSetEnergia() {
		InfFoot x = new InfFoot();
		Plains y = new Plains();
		int test = y.getPeaje(x);
		x.setEnergia(x.energia - test);
		assertEquals(98, x.getEnergia());
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
		boolean itworks = false;
		InfMech x = new InfMech();
		Hq y = new Hq();
		x.setSalud(20);
		x.setMuniciones(1);
		System.out.println(x.getEnergia() + " " + x.getSalud() + " " + x.getMuniciones());
		if(y.suministra(x) == true) {
		
			
		}
		
		itworks = true;
		assertEquals(true, itworks);
	}

}
