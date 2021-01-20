package server;

import java.rmi.Naming;

import remote.IPaypalManager;
import remote.PaypalManager;

public class PaypalManagerServer {
	public static void main(String[] args) {
		if (args.length != 7) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IPaypalManager PayPalServer = new PaypalManager(args);
			
			Naming.rebind(name, PayPalServer);
			System.out.println("- PaypalManager '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ PaypalManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
