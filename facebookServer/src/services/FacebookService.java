package services;

public class FacebookService {
	
	private static FacebookService instance;
	
	private FacebookService() { }
	
	public static FacebookService getInstance() {
		if (instance == null) {
			instance = new FacebookService();
		}
		
		return instance;
	}

	public boolean conectar(String email, String password) {
		return true;
		}
	}

