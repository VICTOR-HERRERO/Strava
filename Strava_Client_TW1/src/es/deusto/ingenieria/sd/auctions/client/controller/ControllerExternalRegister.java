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
	
	//NOT SURE HOW TO DO THE ENUM
	public void ExternalRegister(String email/*, Enum Facebook_Google*/) {
		try {
			this.token = this.serviceLocator.getService().ExternalRegister(email);
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
