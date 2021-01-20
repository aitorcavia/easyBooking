package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public class VueloAssembler {
    private static VueloAssembler instance;

    private VueloAssembler() { }

    public static VueloAssembler getInstance() {
        if (instance == null) {
            instance = new VueloAssembler();
        }

        return instance;
    }
//    public VueloDTO entityToDTO(Vuelo vuelo) {
//        VueloDTO dto = new VueloDTO();
//
//        dto.setFechaSalida(vuelo.getFechaSalida());
//        dto.setFechaLlegada(vuelo.getFechaLlegada());
//        dto.setPrecio(vuelo.getPrecio());
//        dto.setAeropuerto_destino(vuelo.getAeropuerto_destino());
//        dto.setAeropuerto_origen(vuelo.getAeropuerto_origen());
//        dto.setAerolinea(vuelo.getAerolinea());
//
//
//        return dto;
//    }
    
    public List<VueloDTO> entityToDTO(List<Vuelo> list) {
    	List <VueloDTO> vuelos = new ArrayList<VueloDTO>();
    	for (Vuelo v : list) {
    		VueloDTO dto = new VueloDTO();
    		
    		dto.setFechaSalida(v.getFechaSalida());
            dto.setFechaLlegada(v.getFechaLlegada());
            dto.setPrecio(v.getPrecio());
            dto.setAeropuerto_destino(v.getAeropuerto_destino());
            dto.setAeropuerto_origen(v.getAeropuerto_origen());
            dto.setAerolinea(v.getAerolinea());
            
            vuelos.add(dto);
    	}
        
        return vuelos;
    }
}