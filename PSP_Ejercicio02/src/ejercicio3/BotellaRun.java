package ejercicio3;

public class BotellaRun implements Runnable {

	private String nombre;
	private char caracter;
	private Integer cantidad;
	private static long milis = 300;
	
	
	public BotellaRun(String nombre, char caracter, Integer cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}
	
	public void vaciar() {
		while(cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void run() {
		vaciar();
	}
	
	public static void main(String[] args) {
		BotellaRun b1 = new BotellaRun("b1", '_', 10);
		BotellaRun b2 = new BotellaRun("b2", '*', 10);
		new Thread (b1).start();
		new Thread (b2).start();
		
		

	}
	
	

}
