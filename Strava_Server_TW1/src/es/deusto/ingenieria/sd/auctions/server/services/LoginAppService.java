package es.deusto.ingenieria.sd.auctions.server.services;


import java.util.Date;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class LoginAppService {
	
	private static LoginAppService instance;
	
	public LoginAppService() {}
	
	//We dont know how to implement this code
	
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
	
	public User stravaRegister(String email, Date birthDate, int weight, int height, int maxRate, int restRate, String password) {

		return null;
	}
	
}
