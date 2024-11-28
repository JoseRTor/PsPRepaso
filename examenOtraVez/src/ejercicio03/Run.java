package ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
        List<Thread> lista = new ArrayList<Thread>();
        for (int i = 0; i < 10_000; i++) {
			Thread l = new Thread(new Usuario("Juan " + i, logMensajes));
			l.start();
			lista.add(l);
		}
        for (Thread thread : lista) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        logMensajes.imprimirColaMensajes();
        // Crear y lanzar 10 usuarios como hilos

        
        // Esperar hasta fin de todos los hilos


        // Imprimir todos los mensajes registrados
        
    }
}

