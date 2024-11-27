package concurrenciaCoches;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000);
		List <Thread> lista = new ArrayList<Thread>();
//		Thread coche1 = new Thread(new Coche("Coche 1" , 100, carrera));
//		Thread coche2 = new Thread(new Coche("Coche 2" , 100, carrera));
//		Thread coche3 = new Thread(new Coche("Coche 3" , 100, carrera));
//		coche1.start();
//		coche2.start();
//		coche3.start();
//		
//		try {
//			coche1.join();
//			coche2.join();
//			coche3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for (int i = 0; i < 10000; i++) {
		lista.add(new Thread(new Coche("Coche " + i , 100, carrera)));
		}
		
		for (Thread thread : lista) {
			thread.start();
		}
		
		for (Thread thread : lista) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		carrera.imprimirPodio();
	}
}
