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
	//NOT SURE IF THIS IS CORRECT
	public boolean ExternalLogin(String email, Boolean F_G) {
		if(F_G == false) {
			try {
				this.token = this.serviceLocator.getService().ExternalLogin(email, false);
				return true;
			} catch (RemoteException e) {
				System.out.println("# Error at login: " + e);
				this.token = -1;
				return false;
			}
		}else {
			try {
				this.token = this.serviceLocator.getService().ExternalLogin(email, true);
				return true;
			} catch (RemoteException e) {
				System.out.println("# Error at login: " + e);
				this.token = -1;
				return false;
			}
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
