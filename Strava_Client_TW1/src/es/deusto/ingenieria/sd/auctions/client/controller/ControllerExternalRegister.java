






//HAY QUE CAMBIAR MOVIDAS




package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;


public class ControllerExternalRegister {

	private ServiceLocator serviceLocator;
	private long token = -1L;
	
	public ControllerExternalRegister(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public void RegularRegister(String email, Date birthDate, int weight, int height, int maxRate, int restRate, String password) {
		try {
			this.token = this.serviceLocator.getService().RegularRegister(email, birthDate, weight, height, maxRate, restRate, password);
		} catch (RemoteException e) {
			System.out.println("# Error at login: " + e);
		}
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
	public long getToken() {
		return this.token;
	}
	
}
