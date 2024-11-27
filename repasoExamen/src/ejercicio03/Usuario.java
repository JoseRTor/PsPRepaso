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
            logMensajes.registrarMensaje(nextIdMensaje.getAndIncrement());
            pausar();
        }
    }

    public void enviarMensaje() {
        logMensajes.registrarMensaje(nextIdMensaje.getAndIncrement());
        enviarMensajes(logMensajes);
    }

    public void pausar() {
        Random random = new Random();
        int aleatorio = random.nextInt(200, 400);
        try {
            Thread.sleep(aleatorio);
            System.out.println("Mensaje " + nextIdMensaje + " enviado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        enviarMensaje();
    }
}
