package jClasses;

public abstract class Terreno {
	
		enum IdentidadTerreno{
		//TERRENO INDOMABLE
		PLAINS, //Llanos y praderas
		ROAD, //Carreteras
		BRIDGE, //Puentes? En serio, Rodrigo?
		MOUNTAIN, //Montanas y montes altos
		SEA, //El mar azul tan bello
		ARCHIPELAGO, //Conjunto de islas cercanas
		COAST, //Costas, donde se pueden construir
		FOREST, //Bosques
		//ESTRUCTURAS CAPTURABLES
		HQ, //Cuarteles generales
		CITY, //Ciudad
		FACTORY, //Fabricas
		AIRPORT, //Aeropuerto
		PORT, //Puerto
		//Construibles
		TEMP_SEAP, //Puerto Temporal
		TEMP_AIRP //Aeropuerto Temporal, 
	}
	
	
	IdentidadTerreno idTerreno; //Identidad del terreno.
	String nombre; //Nombre del terreno
	boolean construibleSobre; //Si se puede construir sobre este terreno. Implementado por cada grano de tierra y mar.
	int peaje; //Lo que cuesta pasar por este terreno. Depende del tipo de tropa, por lo que se debe implementar arlgun metodo.
	int defensa; //Influye en el golpe total que recibe cada tropa. Mientras mas defensa, menos golpe recibido.
	//Datos Fisicos
	String imagen;
	int posX;
	int posY;
	//Imprescindible realizar constructores otra vez
}
