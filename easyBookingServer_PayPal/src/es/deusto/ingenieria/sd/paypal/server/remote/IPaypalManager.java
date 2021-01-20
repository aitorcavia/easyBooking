package es.deusto.ingenieria.sd.paypal.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPaypalManager extends Remote{
	public void newPayMent(String Concepto, double pay) throws RemoteException;
    public void sendPayment(String Concepto, double pay) throws RemoteException;   
}
