package es.deusto.ingenieria.sd.auctions.server.services;


import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.LocalUser;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.gateway.Factory;
import es.deusto.ingenieria.sd.auctions.server.gateway.IGateway;

public class LoginAppService implements IGateway{
	
	private static Map<String, User> userMap = new HashMap<>();
	private static LoginAppService instance;

	public LoginAppService() {}
	
	public static synchronized LoginAppService getInstance() {	
		if(instance == null) {
			instance = new LoginAppService();
			return instance;
		}
		else return instance;
	}
	
	public User stravaLogin(String email, String password) {

		return null;
	}
	
	public boolean stravaRegister(User user) {
		if(userMap.containsKey(user.getEmail())) {
			return false;
		} 
		userMap.put(user.getEmail(), user);
		return true;
	}
	
	public static Map<String, User> getUserMap() {
		return userMap;
	}

	public boolean login(String email, String pass) throws RemoteException {
		if(userMap.containsKey(email)) {
			LocalUser uL = (LocalUser) userMap.get(email);
			if(uL.checkPassword(pass)) {
				return true;
			} 
		}
		return false;
	}
	
	public User logIn(String email, String password) {
		try {
			if(userMap.containsKey(email)) {
				User u = userMap.get(email);
				if(Factory.getInstance().createGateway(u.getProvider()).login(email, password)){
					return u;
				}
			}
		} catch(Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	
}
