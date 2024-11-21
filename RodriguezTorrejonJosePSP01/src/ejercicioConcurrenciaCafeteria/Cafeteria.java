package ejercicioConcurrenciaCafeteria;

public class Cafeteria {
	private static final Integer AFORO_MAXIMO = 50;
	private static Integer entradas = 0;
	private static Integer salidas = 0;
	
	private Integer aforoActual;
	
	public Cafeteria() {
		aforoActual = 0;
	}
	
	public synchronized boolean haySitioYEntraPersona() {
		if (aforoActual < AFORO_MAXIMO) {
			aforoActual++;
			entradas++;
			System.out.println("Entra persona. Aforo actual = " + aforoActual);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void salePersona() {
		aforoActual--;
		salidas++;
		System.out.println("Sale persona. Aforo actual = " + aforoActual);
		if(entradas - salidas -aforoActual != 0) System.exit(0);
	}
}
