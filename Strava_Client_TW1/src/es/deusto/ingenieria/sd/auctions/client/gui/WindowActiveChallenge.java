package es.deusto.ingenieria.sd.auctions.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerActiveChallenge;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerSetUpChallenge;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerTrainingSession;

import javax.swing.JButton;

public class WindowActiveChallenge {

	private JFrame frame;
	private ControllerActiveChallenge controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowActiveChallenge window = new WindowActiveChallenge();
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
	public WindowActiveChallenge(ControllerActiveChallenge controllerActiveChallenge) {
		this.controller = controllerActiveChallenge;
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
		
		JLabel lblActiveChallenges = new JLabel("Active Challenges");
		lblActiveChallenges.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblActiveChallenges.setBounds(137, 32, 147, 23);
		frame.getContentPane().add(lblActiveChallenges);
		
		
		String challengeList[] = {"1st challenge", "2nd challenge", "3rd challenge"};

		JList list = new JList();
		
		for (String challenge : challengeList) {
			//list.add(challenge);
			//we have not been able to introduce the values inside of the JList
		}
		
		list.setBounds(344, 195, -272, -109);
		frame.getContentPane().add(list);
		
		JButton btnTrainingSession = new JButton("Start training session");
		btnTrainingSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTrainingSession cts = new ControllerTrainingSession(controller.getServiceLocator(), 111L);
				WindowTrainingSession wts = new WindowTrainingSession(cts);
				frame.dispose();
			}
		});
		btnTrainingSession.setBounds(10, 215, 150, 23);
		frame.getContentPane().add(btnTrainingSession);
		
		JButton btnSetUpChallenge = new JButton("Set up challenge");
		btnSetUpChallenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerSetUpChallenge csuc = new ControllerSetUpChallenge(controller.getServiceLocator(), 000L);
				WindowSetUpChallenge wsuc = new WindowSetUpChallenge(csuc);
				frame.dispose();
			}
		});
		btnSetUpChallenge.setBounds(170, 215, 130, 23);
		frame.getContentPane().add(btnSetUpChallenge);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logout();
			}
		});
		btnLogOut.setBounds(335, 215, 89, 23);
		frame.getContentPane().add(btnLogOut);
	}
}