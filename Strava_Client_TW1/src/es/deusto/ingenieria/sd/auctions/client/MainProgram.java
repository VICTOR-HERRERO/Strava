package es.deusto.ingenieria.sd.auctions.client;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.controller.BidController;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerRegularLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerRegularRegister;
import es.deusto.ingenieria.sd.auctions.client.controller.LoginController;
import es.deusto.ingenieria.sd.auctions.client.gui.BidWindow;
import es.deusto.ingenieria.sd.auctions.client.gui.LoginDialog;
import es.deusto.ingenieria.sd.auctions.client.gui.WindowRegularLogin;
import es.deusto.ingenieria.sd.auctions.client.gui.WindowRegularRegister;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		ControllerRegularLogin crl = new ControllerRegularLogin(serviceLocator);
		WindowRegularLogin wrl = new WindowRegularLogin(crl);			
		ControllerRegularRegister crr = new ControllerRegularRegister(serviceLocator);			
		WindowRegularRegister wrr = new WindowRegularRegister(crr);
		
		//Login
		wrl.regularLogin();		
		
		//Here we should add the actions that will be performed
	}
}