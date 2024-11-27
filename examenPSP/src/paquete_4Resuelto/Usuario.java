package paquete_4Resuelto;

import java.util.Iterator;

public class Usuario implements Runnable{

	private String nombre;
	// Para enlazar el log de mensajes a usar
	private LogMensajes logMensajes;
	// Para gestionar el próximo ID de mensajes de usuario
	private static Long nextIdMensaje = 0L; 

	public Usuario(String nombre, LogMensajes logMensajes) {
		this.nombre = nombre;
		this.logMensajes = logMensajes;
	}

	public synchronized void enviarMensajes(LogMensajes logMensajes) {
		logMensajes.imprimirColaMensajes();
		// Ciclo continuo para enviar 100 mensajes con esperas aleatorias

	}

	public  void  enviarMensaje() {
		
		for (int i = 0; i < 10; i++) {
			LogMensajes mensaje = new LogMensajes();
			mensaje.registrarMensaje(nextIdMensaje);
			pausar();
		}
		enviarMensajes(logMensajes);
		
		
		// Registra un nuevo ID de mansaje en la lista de mensajes en logMensajes

	}

	public void pausar() {
		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Pausa entre mensajes de 200 a 400 milisegundos
	}
	
	@Override
	public void run() {
		
		enviarMensaje();
	
	}
	

}
