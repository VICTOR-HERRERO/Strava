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
	
	
	
	
	
	public void createTrainingSession(String title, float distance, Date startDate, Date startTime, float duration, int sport) {
		try {
			SesionDTO dto = new SesionDTO();
			
			dto.setTitle(title);
			dto.setDistance(distance);
			dto.setfStartDate(startDate);
			dto.setStartTime(startTime);
			dto.setDuration(duration);
			
			
			dto.setSport(Sport.values()[sport]); 
			
			
			
			
			
			this.serviceLocator.getService().makeSesion(dto, token);
		} catch(Exception e) {
			System.out.println("# Error at making session: " + e);
		}
	}
	
	public List<String> getSesion() {
		try {
			List<SesionDTO> list = this.serviceLocator.getService().getSesion(token);
			List<String> sList = new ArrayList<>();
			for(SesionDTO dto: list) {
				sList.add(dto.toString());
			}
			return sList;
		} catch(Exception e) {
			System.out.println(" # Error during get Sesion: " + e);
			return null;
		}
	}
	
	
	
	
	
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
