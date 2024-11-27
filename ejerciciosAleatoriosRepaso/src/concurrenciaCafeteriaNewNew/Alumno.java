package concurrenciaCafeteriaNewNew;

import java.util.Random;

public class Alumno implements Runnable {

	private Cafeteria cafeteria;

	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public void consumir() {
		while (true) {
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(4) * 1000);
				if (cafeteria.haySitio()) {
					cafeteria.entraPersona();
				} else {
					System.out.println("El aforo está lleno");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(random.nextInt(8) * 1000);
				cafeteria.salePersona();
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
