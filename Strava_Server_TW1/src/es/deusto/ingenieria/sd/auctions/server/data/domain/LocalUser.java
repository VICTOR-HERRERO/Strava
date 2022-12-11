package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.Date;

public class LocalUser extends User {
	private String password;
	
	public LocalUser(String name, String password, String email, Date birthdate, float weight, 
			float height, int maxHeartRate, int heartRateAtRest, int provider) {
		super(name, email, birthdate, weight, height, maxHeartRate, heartRateAtRest, provider);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}