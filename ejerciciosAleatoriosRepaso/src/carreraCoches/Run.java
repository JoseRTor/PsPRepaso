package carreraCoches;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000);
//		List<Thread> lista =new ArrayList<Thread>();
//		for (int i = 0; i < 10_000; i++) {
//			Thread t = new Thread (new Coche("C-" +i, 100, carrera));
//			lista.add(t);
//			t.start();
//		}
//		for (Thread thread : lista) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		Coche coche1 = new Coche("Alonso", 100, carrera);
		Coche coche2 = new Coche("Pertapen", 100, carrera);
		Coche coche3 = new Coche("Ozuna", 100, carrera);
		
		Thread t1 = new Thread(coche1);
		Thread t2 = new Thread(coche2);
		Thread t3 = new Thread(coche3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		carrera.imprimirPodio();
	}
}
