package ejercicioConcurrenciaCafeteria;

import java.util.Random;

public class Alumno implements Runnable{
	private Cafeteria cafeteria;
	
	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		Random random = new Random();
		while(true) {
			try {
				Thread.sleep(random.nextInt(5) * 1_000); // 0 - 4 segundos
				if(cafeteria.haySitioYEntraPersona()) {
					Thread.sleep(random.nextInt(8) * 1_000);  // 0 a 7 segundos
					cafeteria.salePersona();	
				} else {
					System.out.println("Alumno no ha podido entrar, cafetería llena.");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		consumir();
	}
}
