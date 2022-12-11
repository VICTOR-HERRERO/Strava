package es.deusto.ingenieria.sd.auctions.server.gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GoogleServiceGateway implements IGateway {
	private static GoogleServiceGateway instance;
	private IGoogle googleServer;
	
	private GoogleServiceGateway() {
		try {
			String URL = "//127.0.0.1:1099/GoogleServer";
			this.googleServer = (IGoogle) Naming.lookup(URL);
		} catch(Exception e) {
			System.err.println("# Error locating remote services: " + e);
		}
	}
	
	public static GoogleServiceGateway getInstance() {
		if(instance == null) {
			instance = new GoogleServiceGateway();
		}
		
		return instance;
	}
	
	public boolean login(String email, String pass) throws RemoteException {
		System.out.println("   - LogIn from Google Servers");
		
		try {
			return this.googleServer.login(email, pass);
		} catch(Exception e) {
			System.out.println(" $ Error LogIn with Google: " + e);
			return false;
		}
	}
}
