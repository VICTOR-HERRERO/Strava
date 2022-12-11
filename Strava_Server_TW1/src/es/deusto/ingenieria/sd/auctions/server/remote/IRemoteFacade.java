package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public void stravaRegister(UserDTO dto) throws RemoteException;

	public long stravaLogin(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<ChallengeDTO> getChallenge(long token) throws RemoteException;
	
	public List<ChallengeDTO> getActivateChallenge(long token) throws RemoteException;
	
	public List<TrainingSessionDTO> getTrainingSession(long token) throws RemoteException;
	
	public void createTrainingSession(TrainingSessionDTO dto, long token) throws RemoteException;
	
	public void createChallenge(ChallengeDTO dto, long token) throws RemoteException;
	
	public void activateChallenge(String nombre, long token) throws RemoteException;

}