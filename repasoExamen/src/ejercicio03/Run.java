package ejercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
        List<Thread> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario("user" + i, logMensajes);
            Thread thread = new Thread(usuario);
            lista.add(thread);
            thread.start();
        }

        for (Thread thread : lista) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logMensajes.imprimirColaMensajes();
    }
}

