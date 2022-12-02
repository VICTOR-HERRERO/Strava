package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;


public class ControllerRegularLogin {
	private ServiceLocator serviceLocator;
	private long token = -1;
	
	
	public ControllerRegularLogin(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean RegularLogin(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().RegularLogin(email, password);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error at login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public long getToken() {
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
