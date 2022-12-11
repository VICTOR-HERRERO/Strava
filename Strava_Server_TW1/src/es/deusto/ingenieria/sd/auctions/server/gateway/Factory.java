package es.deusto.ingenieria.sd.auctions.server.gateway;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Provider;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;

public class Factory {
	private static Factory instance;
	
	private Factory() {}
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	public IGateway createGateway(Provider t) {
		if(t.equals(Provider.GOOGLE)) {
			return GoogleServiceGateway.getInstance();
		} else if(t.equals(Provider.FACEBOOK)) {
			return FacebookServiceGateway.getInstance();
		}
		return LoginAppService.getInstance();
	}

}
