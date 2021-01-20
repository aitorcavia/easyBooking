package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;

public class VueloController {

	public ServiceLocator serviceLocator;

	public VueloController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public List<VueloDTO> listaVuelos () {			
		try {
			return this.serviceLocator.getService().buscarVuelos();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<VueloDTO> buscarVuelo(String origen, String destino) throws RemoteException {
		return this.serviceLocator.getService().buscarVuelo(origen, destino);
	}
}
