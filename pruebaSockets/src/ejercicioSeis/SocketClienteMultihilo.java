package ejercicioSeis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClienteMultihilo {
	private ServerSocket server;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int puerto;
	private String address;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
}
