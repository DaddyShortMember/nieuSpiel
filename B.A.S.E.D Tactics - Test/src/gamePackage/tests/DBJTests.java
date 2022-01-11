package gamePackage.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gamePackage.baseDatos.DataBase;

public class DBJTests {

	@Test
	public void testConnect() {
		DataBase x = new DataBase();
		x.getDate();
		x.iniciaDB();
		x.creaTablas();
		x.actualizaGlobal(false, false, false, false, false);
		x.actualizaGlobal(true, false, false, false, true);
		x.actualizaTEquipos(0, 0, 0, 0);
		x.actualizaTEquipos(20, 220, 2220, 22220);
		x.eliminaDB();
		x.finalizaDB();
		assertEquals(null, x.getConn());
	}

}
