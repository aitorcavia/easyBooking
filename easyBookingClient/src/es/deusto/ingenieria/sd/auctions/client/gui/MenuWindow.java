package es.deusto.ingenieria.sd.auctions.client.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.ingenieria.sd.auctions.client.controller.LoginController;
import es.deusto.ingenieria.sd.auctions.client.controller.VueloController;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;



import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.List;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	public static VueloController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuWindow(VueloController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
//		List<Vuelo> vuelos = new ArrayList<Vuelo>();
//		vuelos =  DBManager.getInstance().getVuelos();
//		
//		list = new JList();
//		list.setBounds(109, 11, 315, 239);
//		contentPane.add(list);
//		
//		btnReservar.setBounds(10, 227, 89, 23);
//		contentPane.add(btnReservar);
//		
//		DefaultListModel<Vuelo> modeloVuelos = new DefaultListModel<Vuelo>();
//		for (Vuelo vuelo : vuelos) {
//			modeloVuelos.addElement(vuelo);
//		}
//		
//		list.setModel(modeloVuelos);
		
		
		System.out.println(" - Importar vuelos into the server: '"   + "' - '"  + "'");
		List<VueloDTO> vuelos = controller.listaVuelos();
		System.out.println(vuelos);
		
	}
}
