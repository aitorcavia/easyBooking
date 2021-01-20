package es.deusto.ingenieria.sd.auctions.server.data.dto;


import es.deusto.ingenieria.sd.auctions.server.data.Aerolinea;


public class AerolineaAssembler {
    private static AerolineaAssembler instance;

    private AerolineaAssembler() { }

    public static AerolineaAssembler getInstance() {
        if (instance == null) {
            instance = new AerolineaAssembler();
        }

        return instance;
    }


    public AerolineaDTO entityToDTO(Aerolinea article) {
		AerolineaDTO dto = new AerolineaDTO();
		
		dto.setNombre(article.getNombre());	
		return dto;
	}

}