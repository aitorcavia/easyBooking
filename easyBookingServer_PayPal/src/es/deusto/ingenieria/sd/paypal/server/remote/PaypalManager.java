package es.deusto.ingenieria.sd.paypal.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PaypalManager extends UnicastRemoteObject implements IPaypalManager{

	private static final long serialVersionUID = 1L;
	private String serverName;
	
	public PaypalManager(String[] args) throws RemoteException {
		this.serverName = args[2];

	}

	
	public String getName() {
		return serverName;
	}
	@Override
	public void pay(double pay) throws RemoteException {
		System.out.println("  * Nuevo pago en el servidor ... '" + pay + "€");
		
	}
	
}
