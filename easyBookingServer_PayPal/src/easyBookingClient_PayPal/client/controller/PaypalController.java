package easyBookingClient_PayPal.client.controller;

import java.rmi.RemoteException;


import easyBookingClient_PayPal.client.gui.SwitchServerGUI;
import easyBookingClient_PayPal.client.remote.RMIServiceLocator;

public class PaypalController {

private RMIServiceLocator rsl;
	
	public PaypalController(String[] args) {
		//Create RMI Service Locator
		this.rsl = new RMIServiceLocator();
		//Invoque 'setService' to lookup Remote Service
		this.rsl.setService(args[0], args[1], args[2]);

		
		new SwitchServerGUI(this);
	}
	
    public void newPayment(String Concepto, double pay ){
    	try {
    		//Invoque 'newPayment' using RMI Service Locator
    		this.rsl.getService().newPayMent(Concepto, pay);    		
    	} catch (Exception e){
    		System.err.println("$ Error sending new payment: " + e.getMessage());
    	}
    }
    
    public void sendPayment(String Concepto, double	 pay){
    	try{
    		//Invoque 'receivePayment' using RMI Service Locator
    		this.rsl.getService().sendPayment(Concepto, pay);    		
    	} catch(Exception e){
    		System.out.println("$ Error receiving: " + e.getMessage());
    	}
    }	
	
	public void switchServer(String ip, String port, String name) {
		//Invoque 'setService' to lookup Remote Service
		this.rsl.setService(ip, port, name);
		System.out.println("- Switching to server: //" + ip + ":" + port + "/" + name);
	}
	  
    public void closeTVProgram() {
    	//This method will be use in other Labs.
    }
    
    public void addMaximumNumberMessagesRestriction() {
    	//This method will be use in other Labs.
    }
    
    public void addPermittedOptionsRestriction() {
    	//This method will be use in other Labs.
    }

    public void addForbiddenWordsRestriction() {
    	//This method will be use in other Labs.
    }

    public void generateReport() {
    	//This method will be use in other Labs.
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new PaypalController(args);
    }
}
