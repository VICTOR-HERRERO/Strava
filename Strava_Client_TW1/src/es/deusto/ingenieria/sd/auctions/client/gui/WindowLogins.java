







//HAY QUE HACERLA BIEN, FALTAN MOVIDAS, MIRAR EN EL DRIVE








package es.deusto.ingenieria.sd.auctions.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerActiveChallenge;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerRegularRegister;

public class WindowLogins {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textFieldPassword;
	private ControllerLogin controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowRegularLogin window = new WindowRegularLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public WindowLogins(ControllerLogin controllerRegularLogin) {
		this.controller = controllerRegularLogin;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogIn.setBounds(88, 26, 150, 30);
		frame.getContentPane().add(lblLogIn);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(89, 100, 45, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(89, 140, 80, 13);
		frame.getContentPane().add(lblPassword);
		
		textEmail = new JTextField();
		textEmail.setBounds(211, 97, 96, 19);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(211, 137, 96, 19);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(88, 191, 85, 21);
		frame.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				if(regularLogin()) {
					ControllerActiveChallenge cac = new ControllerActiveChallenge(controller.getServiceLocator(), controller.getToken());
					WindowActiveChallenge wac = new WindowActiveChallenge(cac);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error while logging in");
				}
			}
			
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(218, 190, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] registrationWay = {
						"Register with mail",
						"Register with google/fecebook account"
					};
				String resp = (String) JOptionPane.showInputDialog( null, "How do you want to register?", "Registration", JOptionPane.QUESTION_MESSAGE, null, registrationWay, "" );
				if (resp != null) {
					if (resp.equals(registrationWay[0])) {

						ControllerRegularRegister crr = new ControllerRegularRegister(controller.getServiceLocator());
						WindowRegularRegister wrr = new WindowRegularRegister(crr);
						frame.dispose();

					} else if (resp.equals(registrationWay[1])) {
						//frame.dispose();
						//it will be the same as registrationWay[0] but for another type of reegistration
						
					}
				}
				
				
				
			}
		});
	}
	public boolean regularLogin() {
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(textFieldPassword.getText());
		return this.controller.RegularLogin(textEmail.getText(), sha1);
	}
	
}
