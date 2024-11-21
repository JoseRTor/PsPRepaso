package ejercicio06ComparticionInfo;

public class Test {
	public static void main(String[] args) {
		ContadorCompartido contadorCompartido = new ContadorCompartido();

		// Crear Incrementador y Lector
		Thread incrementador = new Thread(new Incrementador(contadorCompartido), "Incrementador");
		Thread lector = new Thread(new Lector(contadorCompartido), "Lector");

		// Iniciar ambos hilos
		incrementador.start();
		lector.start();

		// Esperar a que los hilos terminen
		try {
			incrementador.join();
			lector.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Ejecución completada.");
	}
}
