package easyBookingClient_PayPal.client.gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import easyBookingClient_PayPal.client.controller.PaypalController;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SwitchServerGUI {

	private JFrame frmSwitchingServers;
	private JTextField IP;
	private JTextField port;
	private JTextField name;
	private PaypalController controller;

	public SwitchServerGUI(PaypalController controller) {
		this.controller = controller;
		initialize();
		frmSwitchingServers.setLocation(0, 0);
		frmSwitchingServers.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSwitchingServers = new JFrame();
		frmSwitchingServers.setTitle("Server Connection");
		frmSwitchingServers.setBounds(270, 420, 312, 207);
		frmSwitchingServers.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panelData = new JPanel();
		frmSwitchingServers.getContentPane().add(panelData, BorderLayout.CENTER);
		panelData.setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(55, 26, 85, 20);
		panelData.add(lblServerIp);

		IP = new JTextField();
		IP.setBounds(153, 23, 85, 20);
		IP.setText("127.0.0.1");
		panelData.add(IP);
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setBounds(55, 58, 85, 20);
		panelData.add(lblServerPort);

		port = new JTextField();
		port.setBounds(153, 55, 86, 20);
		port.setText("1099");
		panelData.add(port);
		
		JLabel lblServerName = new JLabel("Server Name");
		lblServerName.setBounds(55, 91, 85, 20);
		panelData.add(lblServerName);

		name = new JTextField();
		name.setBounds(153, 88, 86, 20);
		panelData.add(name);
		
		JPanel panelButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButton.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		frmSwitchingServers.getContentPane().add(panelButton, BorderLayout.SOUTH);

		JButton btnSwitchServer = new JButton("Connect to Server");
		btnSwitchServer.setForeground(Color.RED);
		
		btnSwitchServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String serverIP = IP.getText().trim();
				String serverPort = port.getText().trim();
				String serverName = name.getText().trim();
				// Calling the controller
				controller.switchServer(serverIP, serverPort, serverName);
				
				frmSwitchingServers.setTitle("Connected to '" + serverName + "'");
			}
		});
		
		panelButton.add(btnSwitchServer);

		frmSwitchingServers.getContentPane().add(panelButton, BorderLayout.SOUTH);
	}
}

