package ejercicio06;
import java.util.Random;
public class Alumno implements Runnable {

	private Cafeteria cafeteria;
	private static Random random = new Random();

	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		while(true) {
			int segundosEsperandoFuera = random.nextInt(5);
			try {
				Thread.sleep(1_000 * segundosEsperandoFuera);
				if(cafeteria.haySitio()) {
					cafeteria.entraPersona();
					int segundosEsperandoParaSalir = random.nextInt(8);
					Thread.sleep(1_000 * segundosEsperandoParaSalir);
					cafeteria.salePersona();
				}else {
					System.out.println("Alumno no ha podido entrar en la cefetería por ser muy gay");
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