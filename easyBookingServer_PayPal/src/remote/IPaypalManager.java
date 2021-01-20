package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPaypalManager extends Remote{
	public void pay(double pay) throws RemoteException;
  
}
