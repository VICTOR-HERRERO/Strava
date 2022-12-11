package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.auctions.server.data.domain.LocalUser;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ChallengeAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TrainingSessionAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;
import es.deusto.ingenieria.sd.auctions.server.services.StravaAppService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	private LoginAppService loginAppService = LoginAppService.getInstance();
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

	public synchronized void stravaRegister(UserDTO dto) throws RemoteException {
			
		System.out.println(" * RemoteFacade regist(): " + dto.getEmail() + " / " + dto.getPassword());
		
		User u;
		if(dto.getProvider() == 0) {
			u = new LocalUser(dto.getName(), dto.getPassword(), dto.getEmail(), dto.getBirthdate(), dto.getWeight(), dto.getHeight(), 
				dto.getMaxHeartRate(), dto.getHeartRateAtRest(), dto.getProvider());
		} else {
			u = new User(dto.getName(), dto.getEmail(), dto.getBirthdate(), dto.getWeight(), dto.getHeight(), 
				dto.getMaxHeartRate(), dto.getHeartRateAtRest(), dto.getProvider());
		}
		if(!loginAppService.stravaRegister(u)) {
			throw new RemoteException("User is already logged in!");
		}
		
	}

	@Override
	public void createTrainingSession(TrainingSessionDTO dto, long token) throws RemoteException {
		System.out.println(" * Making Sesion: " + dto.getTitle() + " " + dto.getSport().toString());
		TrainingSession trainingSession = new TrainingSession(dto.getTitle(), dto.getSport(), dto.getDistance(), dto.getStartDate(), dto.getStartTime(), dto.getDuration());
		User user = serverState.get(token);
		stravaAppService.createTrainingSession(trainingSession, user);
	}


	public void createChallenge(ChallengeDTO dto, long token) throws RemoteException {
		System.out.println(" * Making challenge: " + dto.getName() + " " + dto.getSport().toString());
		Challenge challenge = new Challenge(dto.getName(), dto.getStartDate(), dto.getEndDate(), dto.getTargetType(), dto.getTargetTime(), dto.getSport());
		User user = serverState.get(token);
		stravaAppService.createChallenge(challenge, user);
		
	}
	
	public List<ChallengeDTO> getChallenge(long token) throws RemoteException {
		List<ChallengeDTO> challenges = new ArrayList<>();
		for(Challenge c: LoginAppService.getUserMap().get(serverState.get(token).getEmail()).getChallenges()) {
			challenges.add(ChallengeAssembler.challengeToDTO(c));
		}
		return challenges;
	}

	public List<ChallengeDTO> getActivateChallenge(long token) throws RemoteException {
		List<ChallengeDTO> challenges = new ArrayList<>();
		for(Challenge c: LoginAppService.getUserMap().get(serverState.get(token).getEmail()).getActiveChallenge()) {
			challenges.add(ChallengeAssembler.challengeToDTO(c));
		}
		return challenges;
	}
	
	public List<TrainingSessionDTO> getTrainingSession(long token) throws RemoteException {
		List<TrainingSessionDTO> challenges = new ArrayList<>();
		for(TrainingSession trainingSession: LoginAppService.getUserMap().get(serverState.get(token).getEmail()).getTrainingSessions()) {
			challenges.add(TrainingSessionAssembler.trainingSessionToDTO(trainingSession));
		}
		return challenges;
	}
	
	@Override
	public void activateChallenge(String nombre, long token) throws RemoteException {
		System.out.println(" * Activating Reto: " + nombre);
		User user = serverState.get(token);
		Challenge challenge = null;
		for(Challenge c: LoginAppService.getUserMap().get(serverState.get(token).getEmail()).getChallenges()) {
			if(c.toString().equals(nombre)) {
				challenge = c;
			}
		}
		if(challenge != null) {
			stravaAppService.activateChallenge(challenge, user);
		}
	}
}