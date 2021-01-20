package easyBookingClient_AmericanAirlines.client.remote;

import es.deusto.ingenieria.sd.paypal.server.remote.IAmeAirlinesManager;

public class RMIServiceLocator {
	private IAmeAirlinesManager service = null;

    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator() {
    	//This code enables RMI Security Manager
    	if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
    }

    public void setService(String ip, String port, String serviceName) {
		//Name for looking for the server using RMIRegistry
    	String name = "//" + ip + ":" + port + "/" + serviceName;
		
		try {
			//Lookup remote server reference
			this.service = (IAmeAirlinesManager) java.rmi.Naming.lookup(name);
		} catch (Exception e) {
			System.out.println("# Error during Remote Service Lookup: " + e);
		}
    }
    
    public IAmeAirlinesManager getService() {    	
    	return service;
    }
}
