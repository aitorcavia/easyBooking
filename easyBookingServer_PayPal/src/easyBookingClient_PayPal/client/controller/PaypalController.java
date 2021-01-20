package easyBookingClient_PayPal.client.controller;

import java.rmi.RemoteException;


import easyBookingClient_PayPal.client.gui.SwitchServerGUI;
import easyBookingClient_PayPal.client.remote.GatewayServiceLocator;

public class PaypalController {

private GatewayServiceLocator rsl;
	
	public PaypalController(String[] args) {
		//Create RMI Service Locator
		this.rsl = new GatewayServiceLocator();
		//Invoque 'setService' to lookup Remote Service
		this.rsl.setService(args[0], args[1], args[2]);

		
		new SwitchServerGUI(this);
	}
	
    public void newPayment(double pay ){
    	try {
    		//Invoque 'newPayment' using RMI Service Locator
    		this.rsl.getService().pay(pay);    		
    	} catch (Exception e){
    		System.err.println("$ Error con el pago: " + e.getMessage());
    	}
    }
    
   
	public void switchServer(String ip, String port, String name) {
		//Invoque 'setService' to lookup Remote Service
		this.rsl.setService(ip, port, name);
		System.out.println("- Switching to server: //" + ip + ":" + port + "/" + name);
	}
	  

    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new PaypalController(args);
    }
}
