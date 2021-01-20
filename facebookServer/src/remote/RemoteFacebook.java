package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
import es.deusto.ingenieria.sd.auctions.server.remote.IRemoteFacade;
import es.deusto.ingenieria.sd.auctions.server.remote.RemoteFacade;
import es.deusto.ingenieria.sd.auctions.server.services.LoginService;
import services.FacebookService;

	
	public class RemoteFacebook extends UnicastRemoteObject implements IRemoteFacebook {	
		private static final long serialVersionUID = 1L;
		private static RemoteFacebook instance;
		public boolean state;

		private RemoteFacebook() throws RemoteException {
			super();		
		}
		
		public static RemoteFacebook getInstance() {
			if (instance == null) {
				try {
					instance = new RemoteFacebook();
				} catch (Exception ex) {
					System.err.println("# Error creating RemoteFacebook: " + ex);
				}
			}
			
			return instance;
		}

		public boolean conectar(String email, String password) throws RemoteException {
			System.out.println(" * RemoteFaçade login facebook: " + email + " / " + password);
			this.state = FacebookService.getInstance().conectar(email, password);
			
			return state != false;
		}
	
	
	}

