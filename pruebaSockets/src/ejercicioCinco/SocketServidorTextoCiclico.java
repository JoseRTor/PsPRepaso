package ejercicioCinco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidorTextoCiclico {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int puerto;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public SocketServidorTextoCiclico(int puerto) throws IOException {
		serverSocket = new ServerSocket(puerto);
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

	public void abrirCanalesTexto() {
		System.out.println("[Servidor] Abriendo canales de texto . . .");
		pw = new PrintWriter(os, true);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.println("[Servidor]  Canales de texto abiertos . . .");
	}

	public void cerrarCanalesTexto() throws IOException {
		System.out.println("[Servidor]  Cerrando canales de texto . . .");
		pw.close();
		br.close();
		isr.close();
		System.out.println("[Servidor]  Canales de texto cerrados.");
	}

	public static void main(String[] args) {
		try {
			SocketServidorTextoCiclico server = new SocketServidorTextoCiclico(8081);
			server.start();
			server.abrirCanalesTexto();
			while (true) {
				String datoLeido = server.br.readLine();
				if(datoLeido == null) {
					break;
				}
				System.out.println("[Servidor] Dato leido " + datoLeido );
				String datoAMandar = datoLeido.toUpperCase();
				System.out.println("[Servidor] Dato Recogido " + datoAMandar);
				server.pw.println(datoAMandar);
				if (datoLeido.equalsIgnoreCase("FIN")) {
					break;
				}
			}
			server.cerrarCanalesTexto();
			server.stop();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
