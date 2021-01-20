package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public class ReservaDTO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fecha;
    private double importe;
    private Vuelo vuelo;


    public int getFecha() {
        return fecha;
    }
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }



}