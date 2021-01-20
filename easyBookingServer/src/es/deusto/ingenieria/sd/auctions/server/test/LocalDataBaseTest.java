//package es.deusto.ingenieria.sd.auctions.server.test;
//
//
//import java.util.Calendar;
//import java.util.List;
//
//import es.deusto.ingenieria.sd.auctions.server.data.Reserva;
//import es.deusto.ingenieria.sd.auctions.server.data.Usuario;
//import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;
//import es.deusto.ingenieria.sd.auctions.server.db.DBManager;
//
//public class LocalDataBaseTest {
//
//	public static void main(String[] args) {		
//		try {								
//			List<Vuelo> vuelos = DBManager.getInstance().getVuelos();
//			System.out.println(" - Recuperando vuelos ...");
//			System.out.println("   - " + vuelos.size() + " vuelos recuperados!");
//						
//					
//			
//			
//					
//			System.out.println(" - Recuperando usuarios por email ...");
//			Usuario user = DBManager.getInstance().getUsuario("ejemplo@gmail.com");
//			System.out.println("   - " + user + " recuperado!");
//			
//			Vuelo vuelo = DBManager.getInstance().getVueloPorUsuario(user);	
//			System.out.println(" - Recuperadno vuelos de " + user.getNom_usuario() + " ...");
//		
//			
//			System.out.println(" - Recuperando reservas por usuario ...");
//			Reserva reserva = DBManager.getInstance().getReserva(user);
//			System.out.println(reserva + "recuperado!");
//			
//			System.out.println(" - Realizando una reserva ...");
//			Reserva reserva1 = new Reserva();
//			
//			reserva1.setImporte(vuelo.getPrecio());
//			reserva1.setPasajero(user);
//			reserva1.setVuelo(vuelo);
//			
//			
//		
//			user.addReserva(reserva);
//			
//			System.out.println(" - Storing the bid...");
//			DBManager.getInstance().storeObjectInDB(reserva);
//			
//			System.out.println(" - Deleting data...");
//			DBManager.getInstance().deleteData();
//		} catch (Exception ex) {
//			System.out.println(" $ Entities Test Error :" + ex.getMessage());
//			ex.printStackTrace();
//		}
//	}
//}