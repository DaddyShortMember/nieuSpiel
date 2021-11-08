package gamePackage;

public enum ListaTipos {
	
	//Existe un tipo (Infanteria) que se aplica para ambos tropa y tipo de movimiento. Esto solo ocurre con infanteria basica.
	//TERRESTRE
	INFANTERIA, //Ambos tipo movimiento Y tipo tropa.
	MECH, //Tipo tropa
	TERRESTRE, //Tipo movimiento
	V_LIGERO, //Tipo tropa
	V_PESADO, //Tipo tropa
	ACORAZADO, //Tipo tropa
	//AEREO
	AEREA, //Tipo tropa
	AEREO, //Tipo movimiento
	//NAVAL
	MARINA, //Tipo tropa
	ACUATICO, //Tipo movimiento
	SUBMARINA, //Tipo tropa
	SUBACUATICO, //Tipo movimiento
	
	//DEBUG
	NADA
}
