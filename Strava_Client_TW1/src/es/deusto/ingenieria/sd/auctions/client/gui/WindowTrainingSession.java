package es.deusto.ingenieria.sd.auctions.client.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerTrainingSession;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class WindowTrainingSession {

	private JFrame frame;
	private JTextField textTitle;
	private JTextField textDistance;
	private JTextField textStartDate;
	private JTextField textEndDate;
	private JTextField textDuration;
    private ControllerTrainingSession controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTrainingSession window = new WindowTrainingSession();
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
	public WindowTrainingSession(ControllerTrainingSession controllerTrainingSession) {
		this.controller = controllerTrainingSession;
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
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(79, 40, 155, 13);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSelectSport = new JLabel("Select sport");
		lblSelectSport.setBounds(79, 66, 155, 13);
		frame.getContentPane().add(lblSelectSport);
		
		JLabel lblDistanceKM = new JLabel("Distance (km)");
		lblDistanceKM.setBounds(79, 89, 155, 13);
		frame.getContentPane().add(lblDistanceKM);
		
		JLabel lblStartDate = new JLabel("Start date (dd/MM/yyyy)");
		lblStartDate.setBounds(79, 112, 155, 13);
		frame.getContentPane().add(lblStartDate);
		
		JLabel lblStartTime = new JLabel("Start time (HH:mm)");
		lblStartTime.setBounds(79, 135, 155, 13);
		frame.getContentPane().add(lblStartTime);
		
		textTitle = new JTextField();
		textTitle.setBounds(247, 34, 96, 22);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textDistance = new JTextField();
		textDistance.setBounds(247, 81, 96, 22);
		frame.getContentPane().add(textDistance);
		textDistance.setColumns(10);
		
		textStartDate = new JTextField();
		textStartDate.setBounds(247, 104, 96, 22);
		frame.getContentPane().add(textStartDate);
		textStartDate.setColumns(10);
		
		textEndDate = new JTextField();
		textEndDate.setBounds(247, 127, 96, 22);
		frame.getContentPane().add(textEndDate);
		textEndDate.setColumns(10);
		
		textDuration = new JTextField();
		textDuration.setBounds(247, 150, 96, 22);
		frame.getContentPane().add(textDuration);
		textDuration.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(79, 217, 85, 21);
		frame.getContentPane().add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerLogin crl = new ControllerLogin(controller.getServiceLocator());
				WindowLogins wrl = new WindowLogins(crl);
				frame.dispose();
			}
		});
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setBounds(211, 217, 85, 21);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblCreateTrainigSession = new JLabel("Create Training Session");
		lblCreateTrainigSession.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateTrainigSession.setBounds(79, 0, 300, 30);
		frame.getContentPane().add(lblCreateTrainigSession);
		
		JLabel lblDuration = new JLabel("Duration (Min)");
		lblDuration.setBounds(79, 158, 155, 13);
		frame.getContentPane().add(lblDuration);
		
		String[] selectSport = {"Cycling", "Running", "Both"};
		JComboBox comboSelectSport = new JComboBox(selectSport);
		comboSelectSport.setBounds(247, 58, 96, 22);
		frame.getContentPane().add(comboSelectSport);
	}
}
