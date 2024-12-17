package ejercicioCuatro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClienteTexto {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	private int puerto;
	private String direccion;

	public SocketClienteTexto(int puerto, String direccion) {
		this.puerto = puerto;
		this.direccion = direccion;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando petición al server . . . ");
		socket = new Socket(direccion, puerto);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println();
		System.out.println("[Client] Petit cion aceptada ");

	}

	public void stop() throws IOException {
		System.out.printf("[Client] Cerrando conexion con %s:%d... ", direccion, puerto);
		is.close();
		os.close();
		socket.close();

		System.out.printf("[Client] Conexión cerrada con %s:%d... ", direccion, puerto);

	}
	public void abrirCanalesTexto() {
		System.out.println("[Client] Abriendo canales de texto ...");
		pw = new PrintWriter(os, true); 
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.println("[Client] Canales de texto abiertos ...");
	}
	public void cerrarCanalesTexto() throws IOException {
		System.out.println("[Client] Cerrando canales de texto ...");
		pw.close();
		br.close();
		isr.close();
		System.out.println("[Client] Canales de texto cerrados.");
	}
	
	public static void main(String[] args) {
		SocketClienteTexto cliente = new SocketClienteTexto(8081, "localhost");
		try {
			cliente.start();
			cliente.abrirCanalesTexto();
			String datoEnviado = "Juan";
			System.out.println("[Cliente] dato enviado " + datoEnviado);
			cliente.pw.println(datoEnviado);
			String datoRecibido = cliente.br.readLine();
			System.out.println("[Cliente] dato recibido " + datoRecibido);
			cliente.cerrarCanalesTexto();
			cliente.stop();


		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
