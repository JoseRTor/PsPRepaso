package ejercicioConcurrenciaCoches;

import java.util.Random;

public class Coche implements Runnable{
	
	private String nombre;
	private Integer kmEntrePausas;
	private Integer kmRecorridos;
	private Carrera carrera;
	
	public Coche(String nombre, Integer kmEntrePausas, Carrera carrera) {
		this.nombre = nombre;
		this.kmEntrePausas = kmEntrePausas;
		this.carrera = carrera;
		kmRecorridos = 0;
	}
	
	public void correrCarrera() {
		do {
			avanzar();
			System.out.printf("[Km %d] %s.%n ", kmRecorridos, nombre);
			pausar();
		}
		while (kmRecorridos < carrera.getKmTotales());
		System.out.printf("%s ha finalizado la carrera.%n", nombre);
		carrera.subirAlPodio(nombre);		
	}
	
	public void avanzar() {
		kmRecorridos += kmEntrePausas;
		if (kmRecorridos > carrera.getKmTotales()) {
			kmRecorridos = carrera.getKmTotales();
		}
	}
	
	public void pausar() {
		Random random = new Random();
		// TO DO: IMPLEMENTAR POR EL ALUMNO. DEBE ESPERAR UN TIEMPO ALEATORIO ENTRE 1 Y 3 SEGUNDOS
		try {
			Thread.sleep(1000 * (random.nextInt(3) + 1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		correrCarrera();	
	}
	
}
