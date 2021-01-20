package easyBookingClient_AmericanAirlines.client.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import easyBookingClient_AmericanAirlines.client.gui.SwitchServerGUI;
import easyBookingClient_AmericanAirlines.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;



public class AmeAirlinesController {

private RMIServiceLocator rsl;
	
	public AmeAirlinesController(String[] args) {
		//Create RMI Service Locator
		this.rsl = new RMIServiceLocator();
		//Invoque 'setService' to lookup Remote Service
		this.rsl.setService(args[0], args[1], args[2]);

		
		new SwitchServerGUI(this);
	}
	
	 public void buscarVuelos(String origen,String destino ){
	    	try {
	    		//Invoque 'buscarVuelos' using RMI Service Locator
	    		this.rsl.getService().buscarVuelos(origen,destino);    		
	    	} catch (Exception e){
	    		System.err.println("$ Error con la busqueda: " + e.getMessage());
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
    	new AmeAirlinesController(args);
    }
}
