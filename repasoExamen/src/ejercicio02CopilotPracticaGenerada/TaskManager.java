package ejercicio02CopilotPracticaGenerada;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TaskManager {
	private List<Thread> hilos = new ArrayList<Thread>();
	private TreeMap<Long, String> estados = new TreeMap<Long, String>();

	public void startTasks() {
		hilos.add(new Thread(new TaskProcessor("Twitter"), "C1"));
		hilos.add(new Thread(new TaskProcessor("Facebook"), "C2"));
		hilos.add(new Thread(new TaskProcessor("Bluesky"), "C3"));
		for (Thread thread : hilos) {
			thread.start();
			Long timesnap = System.currentTimeMillis();
			estados.put(timesnap, thread.getName() + " ------> " + thread.getState().toString());
		}

	}

	public void monitorTasks() throws InterruptedException {
		Boolean estanFinished = false;

		while (!estanFinished) {
			estanFinished = true;
			for (Thread thread : hilos) {
				Thread.sleep(90);

				if (thread.getState() != Thread.State.TERMINATED) {
					estanFinished = false;
				}
				Long timesnap = System.currentTimeMillis();
				estados.put(timesnap, thread.getName() + " ------> " + thread.getState().toString());
			}

		}
		System.out.println(hilos.get(0).getState().toString());
	}

	public void printTaskStates() {
		System.out.println("El estado de los hilos son los siguientes:");

		for (Map.Entry<Long, String> entry : estados.entrySet()) {

			System.out.println(entry.getKey() + " --- " + entry.getValue());

		}

	}

	public static void main(String[] args) throws InterruptedException {
		TaskManager tareas = new TaskManager();
		tareas.startTasks();
		tareas.monitorTasks();
		tareas.printTaskStates();

	}

}
