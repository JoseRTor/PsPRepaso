package ejercicioConcurrenciaCoches;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		
		/*
		Carrera carrera0 = new Carrera(300, 3);
		ThreadGroup tg0 = new ThreadGroup("grupo0");
		Thread t1 = new Thread(tg0, new Coche("C-1", 100, carrera0));
		t1.start();
		Thread t2 = new Thread(tg0, new Coche("C-2", 100, carrera0));
		t2.start();
		Thread t3 = new Thread(tg0, new Coche("C-3", 100, carrera0));
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(tg0.activeCount());
		carrera0.imprimirPodio();		
		*/
		
		// Número de coches igual a tamaño podium
		int numCoches = 1_000;
		Carrera carrera = new Carrera(300, numCoches);
		ThreadGroup tg = new ThreadGroup("grupito");
		List<Thread> hilos = new ArrayList<>();
		for(int i = 0; i < numCoches; i++) {
			Thread t = new Thread(tg, new Coche("C" + i, 100, carrera));
			t.start();
			hilos.add(t);
		}
		try {
			for (Thread thread : hilos) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(tg.activeCount());
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carrera.imprimirPodio();

	}
}
