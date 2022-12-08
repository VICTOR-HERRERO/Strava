package es.deusto.ingenieria.sd.auctions.client;

import java.awt.EventQueue;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerRegularRegister;
import es.deusto.ingenieria.sd.auctions.client.gui.WindowLogins;
import es.deusto.ingenieria.sd.auctions.client.gui.WindowRegularRegister;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						WindowLogins window = new WindowLogins(serviceLocator);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}