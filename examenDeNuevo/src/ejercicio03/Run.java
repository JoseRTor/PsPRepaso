package ejercicio03;

import java.util.ArrayList;
import java.util.Iterator;
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
        for (Thread hilo : lista) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

		logMensajes.imprimirColaMensajes();

		// Crear y lanzar 10 usuarios como hilos

		// Esperar hasta fin de todos los hilos

		// Imprimir todos los mensajes registrados

	}
}

