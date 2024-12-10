package ejercicioUno;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientNumerico {
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClientNumerico(String address, int port) {

		this.address = address;
		this.port = port;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando petición al server . . . ");
		socket = new Socket(address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("[Client] Petit cion aceptada ");

	}

	public void stop() throws IOException {
		System.out.printf("[Client] Cerrando conexion con %s:%d... ", address, port);
		is.close();
		os.close();
		socket.close();

		System.out.printf("[Client] Conexión cerrada con %s:%d... ", address, port);

	}

	public static void main(String[] args) {
		SocketClientNumerico client = new SocketClientNumerico("localhost", 8081);
		try {
			client.start();
			
			int datoAEnviar = new Random().nextInt(255);
			client.os.write(datoAEnviar);
			System.out.printf("[Client] Enviado %d a %s:%d%n", datoAEnviar, client.address, client.port);
			int datoRecibido = client.is.read();
			System.out.printf("[Client] Dato recibido %d de %s:%d%n", datoRecibido, client.address, client.port);
			
			client.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
