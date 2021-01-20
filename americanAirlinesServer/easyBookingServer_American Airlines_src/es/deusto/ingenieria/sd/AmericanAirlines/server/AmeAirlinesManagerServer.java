package es.deusto.ingenieria.sd.AmericanAirlines.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.paypal.server.remote.IAmeAirlinesManager;
import es.deusto.ingenieria.sd.paypal.server.remote.AmeAirlinesManager;

public class AmeAirlinesManagerServer {
	public static void main(String[] args) {
		if (args.length != 7) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IAmeAirlinesManager PayPalServer = new AmeAirlinesManager(args);
			
			Naming.rebind(name, PayPalServer);
			System.out.println("- PaypalManager '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ PaypalManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
