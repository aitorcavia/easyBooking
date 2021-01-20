package gateway;


import java.rmi.Naming;

import remote.IRemoteFacebook;


public class FacebookGateway {
	
	private IRemoteFacebook service;

	public void setService() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//127.0.0.1:1099/Facebook";
			this.service = (IRemoteFacebook) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facaade: " + ex);
		}		
	}

	public IRemoteFacebook getService() {
		return this.service;
	}
}
