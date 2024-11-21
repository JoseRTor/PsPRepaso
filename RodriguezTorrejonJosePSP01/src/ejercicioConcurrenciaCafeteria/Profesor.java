package ejercicioConcurrenciaCafeteria;

import java.util.Random;

public class Profesor implements Runnable{
	private Cafeteria cafeteria;
	
	public Profesor(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		Random random = new Random();
		while(true) {
			try {
				Thread.sleep((random.nextInt(3) + 1)* 1_000); // 1 - 3 segundos
				if(cafeteria.haySitioYEntraPersona()) {
					Thread.sleep((random.nextInt(4) + 2)* 1_000);  // 2 a 5 segundos
					cafeteria.salePersona();	
				} else {
					System.out.println("Profesor no ha podido entrar, cafetería llena.");					
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
