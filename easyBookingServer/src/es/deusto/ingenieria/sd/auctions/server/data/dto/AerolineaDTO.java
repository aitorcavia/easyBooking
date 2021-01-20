package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

public class AerolineaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}