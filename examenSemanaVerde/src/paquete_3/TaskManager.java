package paquete_3;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<String> tasks = new ArrayList<>();
	private List<Thread> threads = new ArrayList<>();
	private List<String> taskLog = new ArrayList<>();
	private List<String> estados = new ArrayList<String>();

	public void createTasks() {
		for (int i = 0; i < 10; i++) {
			tasks.add("Task" + i);
		}
	}

	// Crear 10 tareas con nombres "Task1", "Task2", ..., "Task10"
	// y añadirlas a la lista tasks.

	public void processTasks() {
		for (String string : tasks) {
			TaskProcessor task = new TaskProcessor(string);
			Thread thread = new Thread(task);
			estados.add(thread.getName() +"------->"+thread.getState());
			thread.start();
			threads.add(thread);
			taskLog.add(thread.getName());
		}

		// Crear un hilo TaskProcessor por cada tarea en la lista tasks,
		// iniciar cada hilo y almacenarlo en la lista threads.
		// Registrar el nombre de la tarea procesada en taskLog.
	}

	public void monitorThreads() throws InterruptedException {
		boolean finHilos = false;
		int num = 0;
		while (!finHilos) {
			finHilos = true;
			for (Thread threads : threads) {
				estados.add(threads.getName() +"------->"+threads.getState());
				Thread.sleep(100);
				if (threads.getState() != Thread.State.TERMINATED) {
					finHilos = false;
				}
				
//				if(threads.getState() == Thread.State.RUNNABLE) {
//					System.out.println(threads.getName() +"------->"+threads.getState());
//				} else if(threads.getState() == Thread.State.)
			}
		}
		

		// Monitorear cada 100ms el estado de los hilos en la lista threads
		// hasta que todos los hilos hayan terminado.
		// Imprimir en consola los estados cuando cambien.
	}

	public void printLog() {
		// Imprimir el log de las tareas procesadas en taskLog.
		System.out.println("Log de tareas procesadas:");
		for (String string : estados) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TaskManager manager = new TaskManager();
		manager.createTasks();
		manager.processTasks();
		manager.monitorThreads();
		manager.printLog();

		// Responde a las preguntas:
		// 1.- ¿Por qué los estados de los hilos cambian de RUNNABLE a TERMINATED?
		// 2.- ¿Qué sucede si un hilo se interrumpe mientras está en RUNNABLE?
		// 3.- ¿Qué ventaja tiene usar varios hilos para procesar tareas independientes?
		System.out.println("Respuestas a las preguntas:");
		System.out.println("1: Porque han terminado su ejecución como hilo. Es decir, su tarea ha finalizado");
		System.out.println(
				"2: Pueden ocurrir dos cosas. Puede saltar un error (lo cual finaliza el hilo) o puede directamente finalizarlo. ");
		System.out.println(
				"3: Mayor velocidad y control sobre las tareas además de que gasta menos recursos que los procesos. ");
	}
}
