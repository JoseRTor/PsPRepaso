package paquete_4Resuelto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
		ExecutorService executor = Executors.newFixedThreadPool(10);

        
        for (int i = 0; i < 100; i++) {

			Thread t = new Thread(new Usuario("Juan", logMensajes));
			executor.execute(t);
		}
        
		while(!executor.isTerminated()) {
			
		}

		executor.shutdown();
        
//        for (int i = 0; i < 10; i++) {
//        	Usuario u = new Usuario("usuario" + i, logMensajes);
//        	Thread t1 = new Thread(u);
//        	t1.start();
//
//		}
        
        	
        // Crear y lanzar 10 usuarios como hilos

        
        // Esperar hasta fin de todos los hilos


        // Imprimir todos los mensajes registrados
        
    }
}

