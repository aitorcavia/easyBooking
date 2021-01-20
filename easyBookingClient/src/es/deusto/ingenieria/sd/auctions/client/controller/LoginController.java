package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;


public class LoginController {
	
	public ServiceLocator serviceLocator;

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password) throws RemoteException{
		try {
			return this.serviceLocator.getService().login(email, password);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}
	
	public boolean register(String email, String username, String pass) throws RemoteException {
		try {
			
//			Usuario user = new Usuario(email, null, username, pass);
//					
//			DBManager.getInstance().store(null);
			return this.serviceLocator.getService().register(email, username, pass);
			
		} catch (RemoteException e) {
			System.err.println("# Error during register: " + e);
			return false;
		}
		
	}
	

}