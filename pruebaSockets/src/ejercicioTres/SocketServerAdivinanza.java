package ejercicioTres;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServerAdivinanza {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private Integer port;

	public SocketServerAdivinanza(Integer port) throws IOException {
		serverSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("[Servidor] Esperando conexión . . . ");
		socket = serverSocket.accept();
		System.out.println("[Servidor] Conexión Establecida");
		is = socket.getInputStream();
		os = socket.getOutputStream();

	}

	public void stop() throws IOException {
		System.out.println("[Servidor] Terminando la conexión . . . ");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("[Servidor] Conexión terminada . . . ");

	}

	public static void main(String[] args) {
		SocketServerAdivinanza socket;
		Integer numero = (int) (Math.random() * 100);
		Integer datoAEnviar;

		try {
			socket = new SocketServerAdivinanza(8081);
			socket.start();
			while (true) {
				int datoLeido = socket.is.read();

				if (datoLeido > numero) {
					System.out.println("[Servidor] El dato otorgado es mayor . . . ");

					datoAEnviar = 103;
					socket.os.write(datoAEnviar);

				} else if (datoLeido < numero) {
					System.out.println("[Servidor] El dato otorgado es menor . . . ");
					datoAEnviar = 101;
					socket.os.write(datoAEnviar);

				} else {
					datoAEnviar = 102;
					socket.os.write(datoAEnviar);
					System.out.println("[Servidor] El dato coincide . . . ");
					break;
				}
				System.out.println(datoLeido);
				System.out.println(numero);

			}
			socket.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
