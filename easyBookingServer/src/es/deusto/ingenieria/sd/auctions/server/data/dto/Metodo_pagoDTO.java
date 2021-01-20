package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

public class Metodo_pagoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
