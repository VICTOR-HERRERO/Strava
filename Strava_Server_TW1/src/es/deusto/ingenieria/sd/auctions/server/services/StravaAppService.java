package es.deusto.ingenieria.sd.auctions.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;


public class StravaAppService {

	private static StravaAppService instance;
	private List<Challenge> challenges;
	private List<TrainingSession> trainingSessions;
	
	private StravaAppService() {
		this.initializeData();
	}
	
	public static synchronized StravaAppService getInstance() {	
		if(instance == null) {
			instance = new StravaAppService();
			return instance;
		}
		else return instance;
	}
	
	private void initializeData() {
		
	}

	
	public boolean setUpChallenge(User user, String name, Date startDate, Date endDate, Date startTime, long duration) {
		
		return false;
	}
	
	public boolean createTrainingSession(User user, String title, float distance, long duration) {
		
		return false;
	}
	
	public List<Challenge> getActiveChallenges(){
		return this.challenges;
	}
	
	public boolean acceptChallenge(User user, Challenge challenge) {
		System.out.print("challenge accepted");
		return true;
	}
	
}