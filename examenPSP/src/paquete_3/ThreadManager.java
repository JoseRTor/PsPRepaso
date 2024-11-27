package paquete_3;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreadManager {

	private List<Thread> threads = new ArrayList<>();
	private TreeMap<Long, String> threadStates = new TreeMap<>();

	public void startThreads() {
		CountDown c1 = new CountDown("C1", 10);
		CountDown c2 = new CountDown("C2", 8);
		CountDown c3 = new CountDown("C1", 7);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		threads.add(t1);
		threads.add(t2);
		threads.add(t3);
		for (Thread thread : threads) {

			t1.start();

			t2.start();

			t3.start();
			threadStates.put(new Long(1), t1.getState().toString());
			threadStates.put(new Long(2), t2.getState().toString());
			threadStates.put(new Long(3), t3.getState().toString());

		}

		// Crea tres hilos CountDown con diferentes valores iniciales
		// y añádelos a la lista threads. Valores:
		// - "C1", 10
		// - "C2", 8
		// - "C3", 7

		// Inicia los hilos recorriendo la lista threads

		// Guarda el estado de cada hilo en el Map

	}

	public void monitoreaThreads() throws InterruptedException {
		boolean allThreadsTerminated = false;
		int numero = 0;

		while (allThreadsTerminated = false) {

			for (Thread thread : threads) {

				if (thread.getState().equals(Thread.State.TERMINATED)) {
					allThreadsTerminated = true;
					numero++;
					if (numero == 3) {
						allThreadsTerminated = true;
					}
				}
				long tiempoActual = System.currentTimeMillis();
				threadStates.put(tiempoActual, thread.getState().toString());
			}
			Thread.sleep(90);

		}

		// Monitorea hasta que todos los hilos hayan terminado.
		// Para ello cada 90 milisegundos aproximadamente
		// almacena en el map para cada hilo la información:
		// - clave -> timestamp
		// - valor -> cadena con nombre y estado
		// - ejemplo de la cadena: C1:RUNNABLE
		// y vefica si todos han terminado.
	}

	public void printThreadStates() {
		// Imprimir todos los estados registrados en el TreeMap

		System.out.println("\nResumen de estados de los hilos:");
		while (threads.get(0).isAlive()) {
			System.out.printf("%s - Estado: %s%n", threads.get(0).getName(), threads.get(0).getName());
			System.out.printf("%s - Estado: %s%n", threads.get(1).getName(), threads.get(0).getName());
			System.out.printf("%s - Estado: %s%n", threads.get(2).getName(), threads.get(0).getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadManager manager = new ThreadManager();
		manager.startThreads();
		manager.monitoreaThreads();
		manager.printThreadStates();
		// Responde brevemente a las siguientes preguntas:
		// 1.- Motivo de la frecuencia del estado RUNNABLE
		// 2.- Motivo de la frecuencia del estado TIMED_WAITING
		// 3.- Motivo de la frecuencia del estado TERMINATED
		System.out.println("Respuestas a las preguntas");
		System.out.println("1: ");
		System.out.println("2: ");
		System.out.println("3: ");
	}
}
