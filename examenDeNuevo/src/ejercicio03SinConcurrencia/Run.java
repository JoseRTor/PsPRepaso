package ejercicio03SinConcurrencia;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
        List<Thread> lista = new ArrayList<Thread>();

        for (int i = 1; i <= 10; i++) {
            Thread hilo = new Thread(new Usuario("Usuario" + i, logMensajes));
            lista.add(hilo);
            hilo.start();
        }

        // Esperar hasta fin de todos los hilos
        for (Thread hilo : lista) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir todos los mensajes registrados
        logMensajes.imprimirColaMensajes();
    }
}
