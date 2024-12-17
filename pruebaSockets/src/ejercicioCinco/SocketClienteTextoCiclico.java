package ejercicioCinco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClienteTextoCiclico {
	private ServerSocket server;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int puerto;
	private String address;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public SocketClienteTextoCiclico(int puerto, String address) throws IOException {
		this.puerto = puerto;
		this.address = address;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando petición al server . . . ");
		socket = new Socket(address, puerto);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println();
		System.out.println("[Client] Petit cion aceptada ");
	}

	public void stop() throws IOException {
		System.out.printf("[Client] Cerrando conexion con %s:%d... ", address, puerto);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Client] Conexión cerrada con %s:%d... ", address, puerto);
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
		try {
			SocketClienteTextoCiclico cliente = new SocketClienteTextoCiclico(8081, "localhost");
			cliente.start();
			cliente.abrirCanalesTexto();
			String datoEnviado = "Juan Antonio";
			for (int i = 0; i < 50; i++) {
				System.out.println("[Cliente] dato enviado " + datoEnviado);
				cliente.pw.println(datoEnviado);
				String datoRecibido = cliente.br.readLine();
				System.out.println("[Cliente] dato recibido " + datoRecibido);
				if (i == 30) {
					datoEnviado = "Juan";
					cliente.pw.println(datoEnviado);
					datoRecibido = cliente.br.readLine();
					System.out.println("[Cliente] dato recibido " + datoRecibido);
					break;
				}
			}
			cliente.cerrarCanalesTexto();
			cliente.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
