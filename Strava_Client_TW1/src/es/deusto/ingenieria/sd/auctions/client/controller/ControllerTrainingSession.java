package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class ControllerTrainingSession {

	private ServiceLocator serviceLocator;
	private long token = -1;
	
	public ControllerTrainingSession(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public boolean createTrainingSession(long token, String title, float distance, long duration) {
    	try {
			this.serviceLocator.getService().createTrainingSession(token, title, distance, duration);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
