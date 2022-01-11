package gamePackage.baseDatos;

import java.sql.*; //Import all related to SQL
import java.util.logging.Level; //Logger Level import, so we can designate what is critical
import java.util.logging.Logger; //Logger Logger import, so we can log what critical is
import java.util.Date;

/*FOR THIS
 * SECTION
 * MUST DOWNLOAD
 * SQLite
 * FROM MAVEN REPOSITORIES
 *  LINK: https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
 */

public class DataBase {
	static Date date = new Date();

	public static Date getDate() {
		return date;
	}

	private static Logger logDB = Logger.getLogger("Scoreboard");
	private static Connection connect = null;

	public static Connection iniciaDB() {
		try {
			Class.forName("org.sqlite.JDBC"); // Carga de BD para SQLite
			connect = DriverManager.getConnection("jdbc:sqlite:" + "Scoreboard.db");
			logDB.log(Level.INFO, "Successfully connected to Scoreboard");
		} catch (ClassNotFoundException e1) {
			logDB.log(Level.SEVERE, e1.toString());
		} catch (SQLException e2) {
			logDB.log(Level.SEVERE, e2.toString());
		}
		if (connect == null) {
			logDB.log(Level.WARNING, "CONNECTION NULL; ATTEMPTING CREATION");
			try {
				Statement stat = connect.createStatement();
				String stt = "create table gamestats(todat date not null, redwin integer(3) default 0, bluwin integer(3) default 0, amberwin integer(3) default 0, greenwin integer(3) default 0, gamesplayed integer(3), primary key(todat));";
				stat.execute(stt);
				logDB.log(Level.INFO, "Executed " + stt);
				stt = "create table teamstats(tdate date not null, rfunds integer(9) default 0, bfunds integer(9) default 0, afunds integer(9) default 0, gfunds integer(9) default 0, primary key(tdate));";
				stat.execute(stt);
				logDB.log(Level.INFO, "Executed " + stt);
				stat.close();
				stt = null;
				logDB.log(Level.INFO, "Successfully created tables");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logDB.log(Level.SEVERE, e.toString());
			}
		}
		return connect;
	}

	public static void creaTablas() {
		try {
			Statement stat = connect.createStatement();
			String stt = "create table if not exists gamestats(todat date not null primary key, redwin integer(3) default 0, bluwin integer(3) default 0, amberwin integer(3) default 0, greenwin integer(3) default 0, gamesplayed integer(3) default 0);";
			stat.execute(stt);
			logDB.log(Level.INFO, "Executed " + stt);
			stt = "create table if not exists teamstats(tdate date not null primary key, rfunds integer(9) default 0, bfunds integer(9) default 0, afunds integer(9) default 0, gfunds integer(9) default 0);";
			stat.execute(stt);
			logDB.log(Level.INFO, "Executed " + stt);
			stat.close();
			stt = null;
			logDB.log(Level.INFO, "Successfully created tables");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logDB.log(Level.SEVERE, e.toString());
		}
	}

	public static void eliminaDB() {
		try {
			Statement stat = connect.createStatement();
			String stt = "drop table if exists teamstats;";
			stat.execute(stt);
			stt = "drop table if exists gamestats;";
			stat.execute(stt);
			logDB.log(Level.INFO, "Executed " + stt);
			logDB.log(Level.WARNING, "The Database's living status has been revoked");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logDB.log(Level.SEVERE, e.toString());
		}
	}

	public static void finalizaDB() {
		try {
			if (connect != null) {
				connect.close();
				logDB.log(Level.INFO, "Successfully ended connection");
			}
		} catch (SQLException e) {
			logDB.log(Level.SEVERE, e.toString());
		}
		connect = null;
	}

	public static void actualizaGlobal(boolean rw, boolean bw, boolean aw, boolean gw, boolean played) {
		String stt;
		int plays = 0;
		int red = 0;
		int blue = 0;
		int green = 0;
		int amber = 0;
		if (played == true)
			plays = 1;
		if (rw == true)
			red = 1;
		if (gw == true)
			green = 1;
		if (bw == true)
			blue = 1;
		if (aw == true)
			amber = 1;

		try {
			Statement stat = connect.createStatement();
			try {
				stt = ("update gamestats set redwin = redwin + " + red + ", bluwin = bluwin + " + blue
						+ ", amberwin = amberwin + " + amber + ", greenwin = greenwin + " + green
						+ " where todat = date('now');");
				stat.execute(stt);
				logDB.log(Level.INFO, "Executed " + stt);
			} catch (Exception e) {
				logDB.log(Level.WARNING, e.toString());
				try {
					stt = (";");
					stat.execute(stt);
					logDB.log(Level.INFO, "Executed " + stt);
				} catch (Exception e2) {
					logDB.log(Level.SEVERE, e2.toString());
				}
			}

		} catch (SQLException e) {
			logDB.log(Level.SEVERE, e.toString());
		}

	}

	public static void actualizaTEquipos(int rf, int gf, int bf, int af) {
		String stt;
		try {
			Statement stat = connect.createStatement();
			try {
				stt = ("update teamstats set rfunds = rfunds + " + rf + ",  bfunds = bfunds + " + bf
						+ ",  gfunds = gfunds + " + gf + ",  afunds = afunds + " + af + " where tdate = date('now');");
				stat.execute(stt);
				logDB.log(Level.INFO, "Executed " + stt);
			} catch (Exception e) {
				logDB.log(Level.WARNING, e.toString());
				try {
					stt = ("insert into teamstats values(date('now'), " + rf + ", " + bf + ", " + af + ", " + gf
							+ ");");
					stat.execute(stt);
					logDB.log(Level.INFO, "Executed " + stt);
				} catch (Exception e2) {
					logDB.log(Level.SEVERE, e2.toString());
				}

			}

		} catch (SQLException e) {
			logDB.log(Level.SEVERE, e.toString());
		}

	}

	public Connection getConn() {
		return connect;
	}

}
