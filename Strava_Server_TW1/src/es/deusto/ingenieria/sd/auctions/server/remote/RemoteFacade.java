package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ChallengeAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;
import es.deusto.ingenieria.sd.auctions.server.services.StravaAppService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	private LoginAppService loginAppService = new LoginAppService();
	private StravaAppService stravaAppService = StravaAppService.getInstance();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}
	

	@Override
	public synchronized long stravaLogin(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		
		//Perform login() using LoginAppService
		User user = loginAppService.stravaLogin(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				//the token is created with the current time of this Calendar in Milliseconds.
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}

	@Override
	public long stravaRegister(String email, String name, Date birthDate, int weight, int height, int maxRate,
			int restRate, String password) throws RemoteException {
			
		User user = loginAppService.stravaRegister(email, birthDate, weight, height, maxRate, restRate, password);
				
		
				if(user != null && !this.serverState.values().contains(user)) {
					//the token is created with the current time of this Calendar in Milliseconds.
					Long token = Calendar.getInstance().getTimeInMillis();		
					this.serverState.put(token, user);		
					return(token);
				} else {
					
					//TODO change
					
					throw new RemoteException("Register failed");
			}
	}

	@Override
	public List<ChallengeDTO> getActiveChallenges() throws RemoteException {
		
		//Get Categories using BidAppService
		List<Challenge> challenges = stravaAppService.getActiveChallenges();
		
		if (challenges != null) {
			//Convert domain object to DTO
			return ChallengeAssembler.getInstance().challengeToDTO(challenges);
		} else {
			throw new RemoteException("getCategories() fails!");
		}
		
	}

	@Override
	public boolean acceptChallenge(long token, Challenge challenge) throws RemoteException {
		System.out.println(" * RemoteFacade acceptChallenge: " + challenge.getID());
		
		if (this.serverState.containsKey(token)) {						
			//accept the challenge
			if (stravaAppService.acceptChallenge(this.serverState.get(token), challenge)) {
				return true;
			} else {
				throw new RemoteException("acceptChallenge() fails!");
			}
		} else {
			throw new RemoteException("To accept a challenge you must first log in");
		}
	}

	@Override
	public boolean setUpChallenge(long token, String name, Date startDate, Date endDate, Date startTime, long duration) throws RemoteException {
		if (this.serverState.containsKey(token)) {						
			//Make the bid using Bid Application Service
			if (stravaAppService.setUpChallenge(this.serverState.get(token), name, startDate, endDate, startTime, duration)) {
				return true;
			} else {
				throw new RemoteException("setUpChallenge() fails!");
			}
		} else {
			throw new RemoteException("To set up a challenge you must first log in");
		}
	}

	@Override
	public boolean createTrainingSession(long token, String title, float distance, long duration) throws RemoteException {
		
		if (this.serverState.containsKey(token)) {						
			//Make the bid using Bid Application Service
			if (stravaAppService.createTrainingSession(this.serverState.get(token), title, distance, duration)) {
				return true;
			} else {
				throw new RemoteException("createTrainingSession() fails!");
			}
		} else {
			throw new RemoteException("To create a training session you must first log in");
		}
	}


	
}