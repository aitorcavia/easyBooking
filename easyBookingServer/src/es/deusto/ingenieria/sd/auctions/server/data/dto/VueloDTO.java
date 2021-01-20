package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

import es.deusto.ingenieria.sd.auctions.server.data.Aerolinea;
import es.deusto.ingenieria.sd.auctions.server.data.Aeropuerto;

public class VueloDTO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fechaSalida;
    private int fechaLlegada;
    private double precio;
    private Aeropuerto aeropuerto_destino;
    private Aeropuerto aeropuerto_origen;
    private Aerolinea aerolinea;

    public int getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public int getFechaLlegada() {
        return fechaLlegada;
    }
    public void setFechaLlegada(int fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Aeropuerto getAeropuerto_destino() {
        return aeropuerto_destino;
    }
    public void setAeropuerto_destino(Aeropuerto aeropuerto_destino) {
        this.aeropuerto_destino = aeropuerto_destino;
    }
    public Aeropuerto getAeropuerto_origen() {
        return aeropuerto_origen;
    }
    public void setAeropuerto_origen(Aeropuerto aeropuerto_origen) {
        this.aeropuerto_origen = aeropuerto_origen;
    }
    public Aerolinea getAerolinea() {
        return aerolinea;
    }
    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }



}
