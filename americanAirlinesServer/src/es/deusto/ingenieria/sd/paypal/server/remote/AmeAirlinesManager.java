package es.deusto.ingenieria.sd.paypal.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AmeAirlinesManager extends UnicastRemoteObject implements IAmeAirlinesManager{

	private static final long serialVersionUID = 1L;
	private String serverName;
	
	public AmeAirlinesManager(String[] args) throws RemoteException {
		this.serverName = args[2];

	}
	@Override
	public void newPayMent(String Concepto, double pay)  {
		System.out.println("  * Details for paypal on the server ... '" + Concepto + "' and '" + pay + "'");
		
	}
	@Override
	public void sendPayment(String Concepto, double pay)  {
		System.out.println("  * New message on the server ... '" + Concepto + "' and '" + pay + "'");
		
	}
	
	public String getName() {
		return serverName;
	}
	
}
