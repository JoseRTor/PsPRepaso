package ejercicioTres;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientAdivinanza {
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClientAdivinanza(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando petición al server . . . ");
		socket = new Socket(address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println();
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
		SocketClientAdivinanza client = new SocketClientAdivinanza("localhost", 8081);
		int datoEnviado = (int) (Math.random() * 100);
		int intentos = 0;
		try {
			client.start();

			while (true) {
				intentos++;
				System.out.println("[Client]Introduce un número ");

				client.os.write(datoEnviado);

				int datoRecibido = client.is.read();

				if (datoRecibido == 103) {
					// numero enviado es mayor del que tengo que adivinar
					System.out.println("[Client]Número mayor ");
					datoEnviado--;

				} else if (datoRecibido == 101) {
					// numero enviado es menor del que tengo que adivinar
					System.out.println("[Client]Número menor ");
					datoRecibido++;

				} else if (datoRecibido == 102) {
					System.out.println("[Client]Número adivinado en el intento " + intentos);
					break;
				}
				System.out.println(datoRecibido);
				System.out.println(datoEnviado);

			}
			client.stop();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
