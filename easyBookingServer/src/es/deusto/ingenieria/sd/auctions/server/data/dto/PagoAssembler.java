package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Pago;
import es.deusto.ingenieria.sd.auctions.server.data.Usuario;

public class PagoAssembler {
	private static PagoAssembler instance;

	private PagoAssembler() {} 
	
	public static PagoAssembler getInstance() {
		if (instance == null) {
			instance = new PagoAssembler();
		}

		return instance;
}
	public PagoDTO entityToDTO(Pago pago) {
		PagoDTO dto = new PagoDTO();
		
		dto.setMetodoPago(pago.getMetodoPago());
		dto.setImporte(pago.getImporte());
		
		return dto;
	}
}
