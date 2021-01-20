package gateway;

import java.util.ArrayList;

import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public interface IAerolineasGateway {

	public ArrayList<Vuelo> buscarVuelos(String origrn, String destino);
	
}