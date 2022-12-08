package es.deusto.ingenieria.sd.auctions.client.gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.auctions.client.controller.ControllerLogin;
import es.deusto.ingenieria.sd.auctions.client.controller.ControllerSetUpChallenge;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class WindowSetUpChallenge {

	private JFrame frame;
	private JTextField textName;
	private JTextField textDistance;
	private JTextField textStartDate;
	private JTextField textEndDate;
	private JTextField textDuration;
    private ControllerSetUpChallenge controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowSetUpChallenge window = new WindowSetUpChallenge();
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
	public WindowSetUpChallenge(ControllerSetUpChallenge controllerSetUpChallenge) {
		this.controller = controllerSetUpChallenge;
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(79, 40, 155, 13);
		frame.getContentPane().add(lblName);
		
		JLabel lblSelectSport = new JLabel("Select sport");
		lblSelectSport.setBounds(79, 63, 155, 13);
		frame.getContentPane().add(lblSelectSport);
		
		JLabel lblDistanceKM = new JLabel("Distance (km)");
		lblDistanceKM.setBounds(79, 112, 155, 13);
		frame.getContentPane().add(lblDistanceKM);
		
		JLabel lblStartDate = new JLabel("Start date (dd/MM/yyyy)");
		lblStartDate.setBounds(79, 163, 155, 13);
		frame.getContentPane().add(lblStartDate);
		
		JLabel lblStartTime = new JLabel("Start time (HH:mm)");
		lblStartTime.setBounds(79, 186, 155, 13);
		frame.getContentPane().add(lblStartTime);
		
		textName = new JTextField();
		textName.setBounds(247, 34, 96, 22);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textDistance = new JTextField();
		textDistance.setBounds(247, 107, 96, 22);
		frame.getContentPane().add(textDistance);
		textDistance.setColumns(10);
		
		textStartDate = new JTextField();
		textStartDate.setBounds(247, 155, 96, 22);
		frame.getContentPane().add(textStartDate);
		textStartDate.setColumns(10);
		
		textEndDate = new JTextField();
		textEndDate.setBounds(247, 178, 96, 22);
		frame.getContentPane().add(textEndDate);
		textEndDate.setColumns(10);
		
		textDuration = new JTextField();
		textDuration.setBounds(247, 131, 96, 22);
		frame.getContentPane().add(textDuration);
		textDuration.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(79, 217, 85, 21);
		frame.getContentPane().add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerLogin crl = new ControllerLogin(controller.getServiceLocator());
				WindowLogin wrl = new WindowLogin(crl);
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
		
		JLabel lblSetUpChallenge = new JLabel("Create A Challenge");
		lblSetUpChallenge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetUpChallenge.setBounds(79, 0, 300, 30);
		frame.getContentPane().add(lblSetUpChallenge);
		
		JLabel lblDuration = new JLabel("Duration (Min)");
		lblDuration.setBounds(79, 139, 155, 13);
		frame.getContentPane().add(lblDuration);
		
		String[] selectSport = {"Cycling", "Running", "Both"};
		JComboBox comboSelectSport = new JComboBox(selectSport);
		comboSelectSport.setBounds(247, 58, 96, 22);
		frame.getContentPane().add(comboSelectSport);
		
		JLabel lblSelectDistanceduration = new JLabel("Select distance/duration");
		lblSelectDistanceduration.setBounds(79, 86, 155, 13);
		frame.getContentPane().add(lblSelectDistanceduration);
		
		String[] selectDistanceDuration = {"Distance", "Duration"};
		JComboBox comboSelectDistanceDuration = new JComboBox(selectDistanceDuration);
		comboSelectDistanceDuration.setBounds(247, 82, 96, 22);
		frame.getContentPane().add(comboSelectDistanceDuration);
	}

}
