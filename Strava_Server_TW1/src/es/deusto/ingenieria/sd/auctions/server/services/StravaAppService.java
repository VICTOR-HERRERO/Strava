package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;


public class StravaAppService {

	private static StravaAppService instance;
	
	private StravaAppService() {}
	
	public static synchronized StravaAppService getInstance() {	
		if(instance == null) {
			instance = new StravaAppService();
			return instance;
		}
		else return instance;
	}
	
	//Me pide que lo ponga static??
	public void createTrainingSession(TrainingSession sesion, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getTrainingSessions().add(sesion);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
	
	public void createChallenge(Challenge challenge, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getChallenges().add(challenge);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
	
	public void activateChallenge(Challenge challenge, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getActiveChallenge().add(challenge);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
	
}