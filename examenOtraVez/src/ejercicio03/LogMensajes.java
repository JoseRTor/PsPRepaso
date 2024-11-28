package ejercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class LogMensajes {

	private List<AtomicLong> colaMensajes;

	public LogMensajes() {
		colaMensajes = new ArrayList<>();
	}

	public synchronized void registrarMensaje(AtomicLong idMensaje) {
		colaMensajes.add(idMensaje);
	}

	public synchronized void imprimirColaMensajes() {
		// 
		System.out.println("Cola de mensajes enviados:");
		for (AtomicLong idMensaje : colaMensajes) {
			System.out.println("\tMensaje ID: " + idMensaje);
		}
	}
}
