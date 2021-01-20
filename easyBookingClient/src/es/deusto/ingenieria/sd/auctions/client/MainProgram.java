package es.deusto.ingenieria.sd.auctions.client;

import es.deusto.ingenieria.sd.auctions.client.controller.LoginController;
import es.deusto.ingenieria.sd.auctions.client.controller.VueloController;
import es.deusto.ingenieria.sd.auctions.client.gui.LoginWindow;
import es.deusto.ingenieria.sd.auctions.client.gui.MenuWindow;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		LoginWindow venatanaLogin = new LoginWindow(loginController);
		venatanaLogin.setVisible(true);
	
		
//		VueloController vueloController = new VueloController(serviceLocator);			
//		MenuWindow menuWindow = new MenuWindow(vueloController);
//		menuWindow.setVisible(true);
		
	}
}
