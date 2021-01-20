package es.deusto.ingenieria.sd.auctions.server.data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;





@PersistenceCapable
public class Usuario {

		private String email;
		private Aeropuerto aeropuertoPred;
		private String nom_usuario;
		private String pass;
		ArrayList<Reserva> reservas;
		
		
		
		public Usuario(String email, Aeropuerto aeropuertoPred, String nom_usuario, String pass) {
			super();
			this.email = email;
			this.aeropuertoPred = aeropuertoPred;
			this.nom_usuario = nom_usuario;
			this.pass = pass;
			reservas  = new ArrayList<Reserva>();
		}
		
		
		public String getCorreo() {
			return email;
		}
		public void setCorreo(String email) {
			this.email = email;
		}
		public Aeropuerto getAeropuertoPred() {
			return aeropuertoPred;
		}
		public void setAeropuertoPred(Aeropuerto aeropuertoPred) {
			this.aeropuertoPred = aeropuertoPred;
		}
		public String getNom_usuario() {
			return nom_usuario;
		}
		public void setNom_usuario(String nom_usuario) {
			this.nom_usuario = nom_usuario;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		public ArrayList<Reserva> getReservas() {
			return reservas;
		}

		public void setReservas(ArrayList<Reserva> reservas) {
			this.reservas = reservas;
		}

		public void addReserva(Reserva reserva) {
			reservas.add(reserva);
		}

		public void removeReserva(Reserva reserva) {
			reservas.remove(reserva);
		}

		public boolean chekPassword(String password) {
			return this.pass.equals(password);
		}
		
		
		
		
		
		
}
