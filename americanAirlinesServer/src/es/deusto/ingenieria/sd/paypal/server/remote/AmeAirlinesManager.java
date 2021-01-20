package es.deusto.ingenieria.sd.paypal.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import easyBookingClient_AmericanAirlines.client.data.AmeAirlines;
import es.deusto.ingenieria.sd.auctions.server.services.EntityDataService;

public class AmeAirlinesManager extends UnicastRemoteObject implements IAmeAirlinesManager{

	private static final long serialVersionUID = 1L;
	private String serverName;
	
	public AmeAirlinesManager(String[] args) throws RemoteException {
		this.serverName = args[2];

	}
	 public void buscarVuelos(String origen,String destino ){
	System.out.println(" * buscar vuelos por origen y destino:" + origen + ", " +  destino);
			return EntityDataService.getInstance().buscarVuelo(origen, destino);
		
	}
	
	public String getName() {
		return serverName;
	}
	
}
