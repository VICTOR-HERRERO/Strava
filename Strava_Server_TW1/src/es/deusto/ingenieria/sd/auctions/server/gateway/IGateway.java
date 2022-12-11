package es.deusto.ingenieria.sd.auctions.server.gateway;

import java.rmi.RemoteException;

public interface IGateway {
	public boolean login(String email, String pass) throws RemoteException;
}
