package concurrenciaCafeteria;

import java.util.Random;

public class Profesor implements Runnable {

	private Cafeteria cafeteria;

	public Profesor(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public void consumir() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep((random.nextInt(4) + 1) * 1000);
			if (cafeteria.haySitio()) {
				cafeteria.entraPersona();
				Thread.sleep((random.nextInt(5) + 2) * 1000);
				cafeteria.salePersona();
			} else {
				System.out.println("jaja");
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
