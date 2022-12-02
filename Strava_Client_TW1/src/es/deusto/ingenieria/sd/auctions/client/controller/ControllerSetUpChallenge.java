package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;


public class ControllerSetUpChallenge {
	private ServiceLocator serviceLocator;
	private long token = -1;
	
	public ControllerSetUpChallenge(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public boolean setUpChallenge(long token, String name, Date startDate, Date endDate, Date startTime, long duration) {
    	try {
			this.serviceLocator.getService().setUpChallenge(token, startDate, endDate, startTime, duration);
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
