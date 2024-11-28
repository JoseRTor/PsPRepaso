package ejercicio03;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario implements Runnable{

	private String nombre;
	// Para enlazar el log de mensajes a usar
	private LogMensajes logMensajes;
	// Para gestionar el próximo ID de mensajes de usuario
	private static AtomicLong nextIdMensaje = new AtomicLong(1); 

	public Usuario(String nombre, LogMensajes logMensajes) {
		this.nombre = nombre;
		this.logMensajes = logMensajes;
	}

	public void enviarMensajes(LogMensajes logMensajes) {
		for (int i = 0; i < 100; i++) {
			AtomicLong idMensaje = new AtomicLong(nextIdMensaje.getAndIncrement());
			logMensajes.registrarMensaje(idMensaje);
			pausar();
		}
		// Ciclo continuo para enviar 100 mensajes con esperas aleatorias

	}

	public void enviarMensaje() {
		enviarMensajes(logMensajes);
		// Registra un nuevo ID de mansaje en la lista de mensajes en logMensajes

	}

	public void pausar() {
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(200, 401));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Pausa entre mensajes de 200 a 400 milisegundos
	}

	@Override
	public void run() {
		enviarMensaje();
		
	}

}
