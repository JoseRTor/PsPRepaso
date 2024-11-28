package paquete_4.paquete2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario implements Runnable {

    private String nombre;
    // Para enlazar el log de mensajes a usar
    private LogMensajes logMensajes;
    // Para gestionar el próximo ID de mensajes de usuario
    private static AtomicLong nextIdMensaje = new AtomicLong(0);

    public Usuario(String nombre, LogMensajes logMensajes) {
        this.nombre = nombre;
        this.logMensajes = logMensajes;
    }

    public void enviarMensajes() {
        // Ciclo continuo para enviar 100 mensajes con esperas aleatorias
        for (int i = 0; i < 100; i++) {
            enviarMensaje();
        }
    }

    public void enviarMensaje() {
        // Registra un nuevo ID de mansaje en la lista de mensajes en logMensajes
        logMensajes.registrarMensaje(nextIdMensaje);
        nextIdMensaje.addAndGet(1);
        pausar();
    }

    public void pausar() {
        // Pausa entre mensajes de 200 a 400 milisegundos
        Random rand = new Random();
        int espera = rand.nextInt(200, 400);
        try {
            Thread.sleep(espera);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        enviarMensajes();
    }
}
