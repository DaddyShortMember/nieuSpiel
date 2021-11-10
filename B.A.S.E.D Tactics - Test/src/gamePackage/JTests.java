package gamePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTests {
//Tests de getters/setters de clase
	@Test
	public void testGetEnergia() {
		InfFoot x = new InfFoot();
		int rew = x.getEnergia();
		assertEquals(x.energiaMaxima, rew);
	}
	
	@Test
	public void testGetPeaje() {
		InfFoot x = new InfFoot();
		Plains y = new Plains();
		ListaTipos rew = x.getTipoMov();
		int ligma = y.getPeaje(rew);
		assertEquals(1, ligma);
	}
	
	@Test
	public void testSetEnergia() {
		InfFoot x = new InfFoot();
		Plains y = new Plains();
		ListaTipos rew = x.getTipoMov();
		int ligma = y.getPeaje(rew);
		x.setEnergia(x.energia - ligma);
		assertEquals(98, x.getEnergia());
	}
	
	@Test
	public void testSetSalud() {
		InfFoot x = new InfFoot();
		InfFoot y = new InfFoot();
		int xG = x.getGolpeSec();
		if(x.idTropa == y.idTropa)
			xG = xG/(xG/10);
		while(y.salud > 0) {
			System.out.println(y.getSalud() + " PREVIOUS");
			y.setSalud(y.salud - xG);
			System.out.println(y.getSalud() + " HIT");
		}
		boolean exquisite;
		if(y.salud <= 0)
			exquisite = true;
		else
			exquisite = false;
		assertEquals(true, exquisite);
	}

}
