package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class ControllerActiveChallenge {
	private ServiceLocator serviceLocator;
	private long token = -1; //-1 = login has not been done or fails
	
	public ControllerActiveChallenge(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public List<ChallengeDTO> getActiveChallenges(){
		
		try {
			return this.serviceLocator.getService().getActiveChallenges();
		} catch (RemoteException e) {
			System.out.println("# Error getting all categories: " + e);
			return null;
		}
	}
	
	public boolean acceptChallenge(long token, int challenge) {
		try {
			this.serviceLocator.getService().acceptChallenge(token, challenge);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error getting all categories: " + e);
			return false;
		}
	}
	
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(token);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getToken(){
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}