package ejercicio03SinConcurrencia;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario implements Runnable {

    private String nombre;
    private LogMensajes logMensajes;
    private static Long nextIdMensaje = 0L;

    public Usuario(String nombre, LogMensajes logMensajes) {
        this.nombre = nombre;
        this.logMensajes = logMensajes;
    }

    public void enviarMensajes(LogMensajes logMensajes) {
        for (int i = 0; i < 100; i++) {
            logMensajes.registrarMensaje(nextIdMensaje);
            nextIdMensaje++;
        }
    }

    public void enviarMensaje() {
    	logMensajes.registrarMensaje(nextIdMensaje);
        enviarMensajes(logMensajes);
    }

    public void pausar() {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(200, 400));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        enviarMensaje();
    }
}
