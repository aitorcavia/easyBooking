package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Reserva;
import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public class ReservaAssembler {
    private static ReservaAssembler instance;

    private ReservaAssembler() { }

    public static ReservaAssembler getInstance() {
        if (instance == null) {
            instance = new ReservaAssembler();
        }

        return instance;
    }
    public ReservaDTO entityToDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();

        dto.setFecha(reserva.getFecha());
        dto.setImporte(reserva.getImporte());
        dto.setVuelo(reserva.getVuelo());


        return dto;
    }
    
    public List<ReservaDTO> entityToDTOs(List<Reserva> list) {
    	List <ReservaDTO> vuelos = new ArrayList<ReservaDTO>();
    	for (Reserva r : list) {
    		ReservaDTO dto = new ReservaDTO();
    		
    		dto.setFecha(r.getFecha());
            dto.setImporte(r.getImporte());
            dto.setVuelo(r.getVuelo());
            
            vuelos.add(dto);
    	}
        
        return vuelos;
    }
}