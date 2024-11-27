package concurrenciaCafeteria;

import java.util.Random;

public class Alumno implements Runnable {

	private Cafeteria cafeteria;

	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public void consumir() {
		Random rSalir = new Random();
		while (true) {
			try {
				Thread.sleep(rSalir.nextInt(4) * 1000);
				if (cafeteria.haySitio()) {
					cafeteria.entraPersona();
					Thread.sleep(rSalir.nextInt(8) * 1000);
					cafeteria.salePersona();
				} else {
					System.out.println("Está la fucking panza del de psp bloqueando la puerta");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		consumir();

	}
}
