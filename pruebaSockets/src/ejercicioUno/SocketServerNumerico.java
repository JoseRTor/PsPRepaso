package ejercicioUno;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerNumerico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int port;

	public SocketServerNumerico(int port) throws IOException {
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
		System.out.println("[Servidor] Conexión cerrada");

	}
	public static void main(String[] args) {
		SocketServerNumerico server;
		
		try {
			server = new SocketServerNumerico(8081);
			server.start();
			int datoLeido = server.is.read();
			System.out.printf("[Server] Dato recibido: %d %n", datoLeido);
			int datoADevolver = datoLeido + 1;
			server.os.write(datoADevolver);
			System.out.printf("[Server] Dato enviado: %d %n", datoADevolver);
			server.stop();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
