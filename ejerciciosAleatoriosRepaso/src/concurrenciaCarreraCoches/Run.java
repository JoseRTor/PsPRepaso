package concurrenciaCarreraCoches;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000);
		List<Thread> lista = new ArrayList<Thread>();
		Thread t;
		for (int i = 1; i < 1000; i++) {
			t = new Thread(new Coche("C-" + i, 100, carrera));
			t.start();
			lista.add(t);

		}

		for (Thread thread : lista) {

			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		carrera.imprimirPodio();
	}
}
