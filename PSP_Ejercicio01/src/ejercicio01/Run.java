package ejercicio01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	public static void main(String[] args) {
		
		Lanzabolas lanzabol = new Lanzabolas("Esquina");
		Lanzabolas lanzabol2 = new Lanzabolas("Centro");
		Lanzabolas lanzabol3 = new Lanzabolas("sí");
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(lanzabol);
		executor.execute(lanzabol2);
		executor.execute(lanzabol3);

//		new Thread(lanzabol).start();
//		new Thread(lanzabol2).start();
//		new Thread(lanzabol3).start();
		//no especificamos hilos

//		executor.execute(lanzabol);
//		executor.execute(lanzabol2);
//		executor.execute(lanzabol3);
		//con el executor sí especificamos
		
//		lanzabol.run();
//		lanzabol2.run();
//		lanzabol3.run();
		//sale en orden
		executor.shutdown();
		
	}
}
