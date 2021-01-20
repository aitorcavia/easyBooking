package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Aeropuerto;

public class AeropuertoAssembler {
	
	private static AeropuertoAssembler instance;

	private AeropuertoAssembler() { }
	
	public static AeropuertoAssembler getInstance() {
		if (instance == null) {
			instance = new AeropuertoAssembler();
		}

		return instance;
	}
	
	public AeropuertoDTO entityToDTO(Aeropuerto aeropuerto) {
        AeropuertoDTO dto = new AeropuertoDTO();

        dto.setNombre(aeropuerto.getNombre());
        dto.setLocalidad(aeropuerto.getLocalidad());

        return dto;
        
   }
	
	
}