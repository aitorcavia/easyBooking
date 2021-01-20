package gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import data.Vuelo;

public class IberiaGateway implements IAerolineasGateway {

	private String ip;
	private int port;
	
	public IberiaGateway(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public ArrayList<Vuelo> buscarVuelos(String origen, String destino) {
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		String message = null;
		try (Socket tcpSocket = new Socket(ip, port);
				// Streams to send and receive information are created from the
				// Socket
				DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())) {

			// Send request (a Srting) to the server
			out.writeUTF(message);
			System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":"
					+ tcpSocket.getPort() + "' -> '" + message + "'");

			// Read response (a String) from the server
			String data = in.readUTF();
			System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			for (Vuelo vuelo : vuelos) {
				if(vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)){
					vuelos.add(vuelo);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
		return vuelos;
	}
	
	
}
