package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;
import es.deusto.ingenieria.sd.auctions.server.db.DBManager;
import es.deusto.ingenieria.sd.auctions.server.services.EntityDataService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;
	public Usuario state;

	private RemoteFacade() throws RemoteException {
		super();		
	}
	
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	public boolean login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFaçade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	@Override
	public boolean register(String email, String username, String pass) throws RemoteException {
		System.out.println(" * RemoteFaçade register: " + email + " / " + pass);
		Usuario user = new Usuario(email, null, username, pass);
		DBManager.getInstance().storeUsuario(user);	
		return true;
	}
	
	public List<VueloDTO> buscarVuelos() throws RemoteException{
		System.out.println(" * RemoteFaçade buscar vuelos");
		return EntityDataService.getInstance().buscarVuelos();
	}
	
	public List<VueloDTO> buscarVuelo(String origen, String destino) throws RemoteException{
		System.out.println(" * RemoteFaçade buscar vuelos por origen y destino:" + origen + ", " +  destino);
		return EntityDataService.getInstance().buscarVuelo(origen, destino);
	}


	
	

//	public List<AeropuertoDTO> getCategories() {
//		System.out.println(" * RemoteFaçade getCategories");
//		return EntityDataService.getInstance().getCategories();
//	}
//
//	public List<AerolineaDTO> getArticles(String category) {
//		System.out.println(" * RemoteFaçade getArticles of a Category: " + category);
//		return EntityDataService.getInstance().getArticles(category);
//	}
//
//	public boolean makeBid(long article, float bid) {
//		if (state != null) {
//			System.out.println(" * RemoteFaçade makeBid article : " + article + " / " + bid);
//			return BidService.getInstance().makeBid(state, article, bid);
//		} else {
//			return false;
//		}
//	}	
	
	
}