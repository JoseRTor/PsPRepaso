package paquete_4.paquete2;

public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();

        // Crear y lanzar 10 usuarios como hilos
        for (int i = 0; i < 2; i++) {
            Usuario user = new Usuario("Usuario " + i, logMensajes);
            new Thread(user).start();
        }

        // Esperar hasta fin de todos los hilos
        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Imprimir todos los mensajes registrados
        logMensajes.imprimirColaMensajes();
    }
}

