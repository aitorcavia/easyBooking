package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

public class AeropuertoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String nombre;
	private String localidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
	

	