package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;

public interface IRemoteFacade extends Remote {	
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public boolean register(String email, String username, String pass) throws RemoteException;
	public List<VueloDTO> buscarVuelos() throws RemoteException;
	public List<VueloDTO> buscarVuelo(String origen, String destino) throws RemoteException;

}