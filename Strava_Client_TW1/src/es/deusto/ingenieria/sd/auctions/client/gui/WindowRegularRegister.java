package es.deusto.ingenieria.sd.auctions.client.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerRegularRegister;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WindowRegularRegister {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldName;
	private JTextField textFieldBirthDay;
	private JTextField textFieldWeight;
	private JTextField textFieldHeight;
	private JTextField textFieldMHR;
	private JTextField textFieldHRR;
	private ControllerRegularRegister controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowRegularRegister window = new WindowRegularRegister();
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
	public WindowRegularRegister(ControllerRegularRegister controllerRegularRegister) {
		this.controller = controllerRegularRegister;
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
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(79, 40, 155, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(79, 63, 155, 13);
		frame.getContentPane().add(lblName);
		
		JLabel lblBirth_date = new JLabel("Birth date (dd/MM/yyyy)");
		lblBirth_date.setBounds(79, 86, 155, 13);
		frame.getContentPane().add(lblBirth_date);
		
		JLabel lblWeight = new JLabel("Weight (kg)");
		lblWeight.setBounds(79, 109, 155, 13);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblHRR = new JLabel("Heart rate at rest (bpm)");
		lblHRR.setBounds(79, 178, 155, 13);
		frame.getContentPane().add(lblHRR);
		
		JLabel lblHeight = new JLabel("Height (cm)");
		lblHeight.setBounds(79, 132, 155, 13);
		frame.getContentPane().add(lblHeight);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(247, 34, 96, 19);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(247, 57, 96, 19);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldBirthDay = new JTextField();
		textFieldBirthDay.setBounds(247, 80, 96, 19);
		frame.getContentPane().add(textFieldBirthDay);
		textFieldBirthDay.setColumns(10);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setBounds(247, 103, 96, 19);
		frame.getContentPane().add(textFieldWeight);
		textFieldWeight.setColumns(10);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(247, 126, 96, 19);
		frame.getContentPane().add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		textFieldMHR = new JTextField();
		textFieldMHR.setBounds(247, 149, 96, 19);
		frame.getContentPane().add(textFieldMHR);
		textFieldMHR.setColumns(10);
		
		textFieldHRR = new JTextField();
		textFieldHRR.setBounds(247, 172, 96, 19);
		frame.getContentPane().add(textFieldHRR);
		textFieldHRR.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(79, 217, 85, 21);
		frame.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerLogin crl = new ControllerLogin(controller.getServiceLocator());
				WindowLogins wrl = new WindowLogins(crl);
				frame.dispose();
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(211, 217, 85, 21);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel_7 = new JLabel("Register");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(79, 0, 150, 30);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblMHR = new JLabel("Maximum heart rate (bpm)");
		lblMHR.setBounds(79, 155, 155, 13);
		frame.getContentPane().add(lblMHR);
	}
}
