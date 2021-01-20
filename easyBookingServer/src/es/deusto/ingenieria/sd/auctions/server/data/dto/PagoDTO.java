package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

import es.deusto.ingenieria.sd.auctions.server.data.Metodo_pago;
public class PagoDTO implements Serializable{
	
	private static final long serialVersionUID =1L;
	private Metodo_pago metodoPago;
	private double importe;
	
	public Metodo_pago getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(Metodo_pago metodoPago) {
		this.metodoPago = metodoPago;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	

}
