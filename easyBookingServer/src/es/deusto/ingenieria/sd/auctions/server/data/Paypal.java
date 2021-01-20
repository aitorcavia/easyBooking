package es.deusto.ingenieria.sd.auctions.server.data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Paypal extends Metodo_pago {
	
	private String email;
	private Usuario usuario;
	
	public Paypal(String tipo, String email, Usuario usuario) {
		super(tipo);
		this.email = email;
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Paypal [email=" + email + ", usuario=" + usuario + "]";
	}
	
	
	
	
	
	
	
	
	
}
