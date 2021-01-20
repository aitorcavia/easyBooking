package es.deusto.ingenieria.sd.auctions.server.db;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import es.deusto.ingenieria.sd.auctions.server.data.*;


public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	public void deleteData() {
		List<Usuario> usuarios = DBManager.getInstance().getUsuarios();
		
		for (Usuario user : usuarios) {
			DBManager.getInstance().deleteObjectFromDB(user);
		}
	}
	
	//GUARDAR OBJETO A BD
	public void store(Object obj) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tr = pm.currentTransaction();

		try {
			tr.begin();
			System.out.println("Almacenando en la base de datos...");
			System.out.println(obj);
			pm.makePersistent(obj);
			tr.commit();
		} catch (Exception e) {
			System.out.println("Error en el almacenamiento!!");
		} finally {
			if (tr != null && tr.isActive()) {
				tr.rollback();
			}
			pm.close();
		}
	}
	
	
	//BORRAR OBJETO DE BD
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an object: " + object);
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	//REGISTRAR USUARIO
	public void registrar(Usuario usuario) {
		store(usuario);
	}
	
	//GUARDAR USUARIO BD
	public void storeUsuario(Usuario user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("  * Storing an object: " + user);
			pm.makePersistent(user);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	
		
		//----------------------------------------------------METODOS DBMANAGER---------------------------------------------------------------//
		
		
			//BUSCAR VUELOS
			public List<Vuelo> buscarVuelos() {
				PersistenceManager pm = pmf.getPersistenceManager();
				pm.getFetchPlan().setMaxFetchDepth(4);
				Transaction tx = pm.currentTransaction();
				List<Vuelo> vuelos = new ArrayList<>(); 

				try {
					System.out.println("  * Mostrando todos los vuelos");
					tx.begin();
					
					Extent<Vuelo> vuelosExtent = pm.getExtent(Vuelo.class, true);
					
					for (Vuelo vuelo : vuelosExtent) {
						vuelos.add(vuelo);
						System.out.println(vuelo);
					}
								
					tx.commit();
				} catch (Exception ex) {
					System.out.println("  $ Error al mostrar los vuelos: " + ex.getMessage());
				} finally {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}

					pm.close();
				}

				return vuelos;
			}
			
		//BUSCAR VUELO
		public List<Vuelo> buscarVuelo(String origen, String destino) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tr = pm.currentTransaction();
			ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

			try {
				tr.begin();
				System.out.println("Mostrando vuelos con origen en " + origen + " y destino en " + destino);
				Extent<Vuelo> ext = pm.getExtent(Vuelo.class, true);
				for (Vuelo vuelo : ext) {
					if (vuelo.getAeropuerto_origen().getNombre().equals(origen) && vuelo.getAeropuerto_destino().getNombre().equals(destino)) {
						vuelos.add(vuelo);
					}
				}
				tr.commit();
			} catch (Exception e) {
				System.out.println("No hay vuelos con dichos origen y destino!!");
			} finally {
				if (tr != null && tr.isActive()) {
					tr.rollback();
				}
				pm.close();
			}
			
			return vuelos;
		}
		
		
		//BUSCAR RESERVA POR ID
		public Reserva buscarReserva(int idUsuario) {
			PersistenceManager pm = pmf.getPersistenceManager();
			pm.getFetchPlan().setMaxFetchDepth(4);
			Transaction tx = pm.currentTransaction();
			Reserva reserva = null; 

				try {
					
					System.out.println("  * Querying a Reserva by idUsuario: " + idUsuario);
					tx.begin();
					
					Query<?> query = pm.newQuery("SELECT FROM " + Reserva.class.getName() + " WHERE idUsuario == '" + idUsuario + "'");
					query.setUnique(true);
					reserva = (Reserva) query.execute();
					
					tx.commit();
				} catch (Exception ex) {
					System.out.println("  $ Error obteniendolas reservas por idUsuario: " + ex.getMessage());
				} finally {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
		
					pm.close();
				}
		
			return reserva;
		}
		
		//BUSCAR RESERVAS
		public List<Reserva> buscarReservas() {
			PersistenceManager pm = pmf.getPersistenceManager();
			pm.getFetchPlan().setMaxFetchDepth(4);
			Transaction tx = pm.currentTransaction();
			List<Reserva> reservas = new ArrayList<>(); 

			try {
				System.out.println("  * Buscando todas las reservas");
				tx.begin();
				
				Extent<Reserva> reservasExtent = pm.getExtent(Reserva.class, true);
				
				for (Reserva reserva : reservasExtent) {
					reservas.add(reserva);
					System.out.println(reserva);
				}
							
				tx.commit();
			} catch (Exception ex) {
				System.out.println("  $ Error obteniendo las reservas: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}

			return reservas;
		}
		
		
		//GET USUARIO POR MAIL
		public Usuario getUsuario(String email) {
			PersistenceManager pm = pmf.getPersistenceManager();
			pm.getFetchPlan().setMaxFetchDepth(4);
			Transaction tx = pm.currentTransaction();
			Usuario user = null; 

			if (email != null) {
				try {
					
					System.out.println("  * Querying a Usuario by email: " + email);
					tx.begin();
					
					Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + "'");
					query.setUnique(true);
					user = (Usuario) query.execute();
					
					tx.commit();
				} catch (Exception ex) {
					System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
				} finally {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
		
					pm.close();
				}
			}else {
				System.out.println("Error email");
				return null;
			}

			return user;
		}
		
		//RESERVAR VUELO
		public void reservar(Reserva reserva) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tr = pm.currentTransaction();
	
			try {
				tr.begin();
				System.out.println("Almacenando la reserva en la base de datos");
				Extent<Usuario> ext = pm.getExtent(Usuario.class, true);
				for (Usuario user : ext) {
					if (reserva.getPasajero().getCorreo().equals(user.getCorreo())) {
						reserva.setPasajero(user);
						
						user.addReserva(reserva);
						System.out.println("Reserva realizada por el usuario " + user);
						System.out.println(reserva);
						pm.makePersistent(user);
						break;
					}
				}
				tr.commit();
			} catch (Exception e) {
				System.out.println("Error en el almacenamiento de la reserva!!");
			} finally {
				if (tr != null && tr.isActive()) {
					tr.rollback();
				}
				pm.close();
			}
		}
		
		
		

	public void guardarAeropuerto(Aeropuerto aeropuerto) {
		store(aeropuerto);
	}

	public void pagar(Pago pago) {
		store(pago);
	}
	
	
	
	
	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("  * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

//	public void store(Usuario usuario) {
//		DBManager.getInstance().storeObjectInDB(usuario);	
//	}
//	

	
	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		List<Usuario> users = new ArrayList<>(); 

		try {
			System.out.println("  * Querying all users");
			tx.begin();
			
			Extent<Usuario> userExtent = pm.getExtent(Usuario.class, true);
			
			for (Usuario user : userExtent) {
				users.add(user);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return users;
	}
	
	
	
	
	


	
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Aeropuerto aeropuerto1 = new Aeropuerto("A443", "Aeropuerto Narnia", "Narnia", 80000);
		Aeropuerto aeropuerto2 = new Aeropuerto("A231", "Aeropuerto Loiu", "Loiu", 6000);
		Aeropuerto aeropuerto3 = new Aeropuerto("A442", "Aeropuerto Gran", "Granada", 7000);
		
		Aerolinea aerolinea1 = new Aerolinea("AE21", "Iberia");
		Aerolinea aerolinea2 = new Aerolinea("AE22", "AirLines");
		
		Usuario user1 = new Usuario("tony@gmail.com", aeropuerto1, "tony", "tony123");
		Usuario user2 = new Usuario("mknini@gmail.com", aeropuerto2, "mknini", "mk123");
		
		Vuelo vuelo1 = new Vuelo("V443", 100520, 110520, 50, 20, 40, aeropuerto1, aeropuerto2, aerolinea1);
		Vuelo vuelo2 = new Vuelo("V445", 220920, 230920, 100, 40, 40, aeropuerto3, aeropuerto2, aerolinea2);
		
		Paypal paypal1 = new Paypal("tony@gmail.com", null, user1);
		Credit_card creditcard1 = new Credit_card(null, 555465678, "Anton Chavarria", 776);
		
		Reserva reserva1 = new Reserva(141120, 200, 5,user1, vuelo1, paypal1);
		Reserva reserva2 = new Reserva(121120, 600, 8, user2,vuelo2, creditcard1);
		
		try {
			//Store users in DB
			DBManager.getInstance().store(user1);
			DBManager.getInstance().store(user2);
			DBManager.getInstance().store(aeropuerto1);
			DBManager.getInstance().store(aeropuerto2);
			DBManager.getInstance().store(aeropuerto3);
			DBManager.getInstance().store(aerolinea1);
			DBManager.getInstance().store(aerolinea2);
			DBManager.getInstance().store(vuelo1);
			DBManager.getInstance().store(vuelo2);
			DBManager.getInstance().store(reserva1);
			DBManager.getInstance().store(reserva2);
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}