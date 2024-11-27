package ejercicio03;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


public class Usuario implements Runnable {

    private String nombre;
    private LogMensajes logMensajes;
    private static AtomicLong nextIdMensaje = new AtomicLong(0);

    public Usuario(String nombre, LogMensajes logMensajes) {
        this.nombre = nombre;
        this.logMensajes = logMensajes;
    }

    public void enviarMensajes(LogMensajes logMensajes) {
        for (int i = 0; i < 100; i++) {
            long idMensaje = nextIdMensaje.getAndIncrement();
            logMensajes.registrarMensaje(idMensaje);
            System.out.println(i);
            pausar();
        }
    }

    public void enviarMensaje() {
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