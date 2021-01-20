package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Metodo_pago;
import es.deusto.ingenieria.sd.auctions.server.data.Usuario;

public class Metodo_pagoAssembler {
	private static Metodo_pagoAssembler instance;

	private Metodo_pagoAssembler() { }
	
	public static Metodo_pagoAssembler getInstance() {
		if (instance == null) {
			instance = new Metodo_pagoAssembler();
		}

		return instance;
	}


public Metodo_pagoDTO entityToDTO(Metodo_pago metodoPago) {
	Metodo_pagoDTO dto = new Metodo_pagoDTO();
	
	dto.setTipo(metodoPago.getTipo());
	

	return dto;
}
}
