package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.List;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ReservaAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;
import es.deusto.ingenieria.sd.auctions.server.db.DBManager;

public class EntityDataService {
	
	private static EntityDataService instance;

	private EntityDataService() { }
	
	public static EntityDataService getInstance() {
		if (instance == null) {
			instance = new EntityDataService();
		}

		return instance;
	}

	
	public List <VueloDTO> buscarVuelos(){
		return VueloAssembler.getInstance().entityToDTO(DBManager.getInstance().buscarVuelos());
	}
	
	public List <VueloDTO> buscarVuelo(String origen, String destino){
		return VueloAssembler.getInstance().entityToDTO(DBManager.getInstance().buscarVuelo(origen, destino));
	}
	
	public ReservaDTO buscarReserva(int idUsuario){
		return ReservaAssembler.getInstance().entityToDTO(DBManager.getInstance().buscarReserva(idUsuario));
	}
	
	public List<ReservaDTO> buscarReservas(){
		return ReservaAssembler.getInstance().entityToDTOs(DBManager.getInstance().buscarReservas());
	}
	
}