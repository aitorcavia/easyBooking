package es.deusto.ingenieria.sd.auctions.server.data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public abstract class  Metodo_pago {
	private String tipo;
	
	public Metodo_pago(String tipo) {
		super();
		this.tipo = tipo;
		
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return "Metodo_pago [tipo=" + tipo + "]";
	}
	
	
	
	
}
