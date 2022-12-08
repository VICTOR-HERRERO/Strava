package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import domain.TipoDeporte;
import dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class ControllerChallenge {
	private ServiceLocator serviceLocator;
	private long token = -1; //-1 = login has not been done or fails
	
	
	
	public boolean setUpChallenge(long token, String name, Date startDate, Date endDate, Date startTime, long duration, boolean targetType, int targetTime) {
    	try {
    		RetoDTO dto = new RetoDTO();
    		
    		dto.setNombre(name);
    		dto.setStartDate(startDate);
    		dto.setEndDate(endDate);
			dto.setTargetType(targetType);
			dto.setTargetTime(targetTime);
			dto.setDeporte(Sport.values()[sport]);
			
			dto.setObjetivo(objetivo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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

	public long getToken(){
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}