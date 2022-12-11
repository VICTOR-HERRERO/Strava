package es.deusto.ingenieria.sd.auctions.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class FacebookServiceGateway implements IGateway {
	private static FacebookServiceGateway instance;
	private String[] args = {"", ""};
	
	//Ni idea de lo de la ip
	private FacebookServiceGateway() {
		args[0] = "127.0.0.1";
		args[1] = "8001";
	}
	
	public static FacebookServiceGateway getInstance() {
		if(instance == null) {
			instance = new FacebookServiceGateway();
		}
		return instance;
	}
	public boolean login(String email, String password) throws RemoteException {
		if (args.length < 2) {
			System.err.println(" # Usage: TCPSocketClient [SERVER IP] [PORT] [MESSAGE]");
			System.exit(1);
		}
		
		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//Send request (a Srting) to the server
			out.writeUTF(email);
			out.writeUTF(password);
			System.out.println("- StravaClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + " : " + password + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();	
			System.out.println("- StravaClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			if(data.equals("1")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("# StravaClient: Error: " + e.getMessage());
		}
		return false;
	}
}
