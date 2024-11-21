package ejercicioCoches;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000);
		Coche cocheAlonso = new Coche("Alonso", 100, carrera);
		Coche juanCoche = new Coche("Juan",100, carrera);
		Coche batiCoche = new Coche("Batman",100,carrera);
		ExecutorService executor = Executors.newFixedThreadPool(1000);
//		executor.execute(cocheAlonso);
//		executor.execute(batiCoche);
//		executor.execute(juanCoche);
//		executor.shutdown();
		
		
		for (int i = 0; i < 999; i++) {
			Coche c = new Coche("Coche" + i, 100, carrera);
			executor.execute(c);
		}

		while(!executor.isTerminated()) {
			
		}

		executor.shutdown();
		carrera.imprimirPodio();

		
		
		
//		juanCoche.correrCarrera();
//		batiCoche.correrCarrera();
//		cocheAlonso.correrCarrera();
		
	}

}
