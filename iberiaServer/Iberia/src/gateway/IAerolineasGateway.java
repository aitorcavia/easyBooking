package gateway;

import java.util.ArrayList;

import data.Vuelo;

public interface IAerolineasGateway {

	public ArrayList<Vuelo> buscarVuelos(String origrn, String destino);
	
}