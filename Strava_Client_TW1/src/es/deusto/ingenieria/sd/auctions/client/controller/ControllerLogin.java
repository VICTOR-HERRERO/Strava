






//HAY QUE HACER CAMBIOS, MIRAD DRIVE (METER LOGOUT Y TAL)







package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;


public class ControllerLogin {
	private ServiceLocator serviceLocator;
	private long token = -1;
	
	
	public ControllerLogin(ServiceLocator serviceLocator) {
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
	//NOT SURE IF THIS WILL BE LIKE THIS OF IF WE HAVE TO DO AN DIFERENTATION BETWEEN EXTERNAL TYPES
	public boolean ExternalLogin(String email) {
		try {
			this.token = this.serviceLocator.getService().ExternalLogin(email);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error at login: " + e);
			this.token = -1;
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
	
	public long getToken() {
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
