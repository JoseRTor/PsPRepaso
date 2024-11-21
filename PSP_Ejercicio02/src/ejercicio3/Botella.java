package ejercicio3;

public class Botella extends Thread {

	private String nombre;
	private char caracter;
	private Integer cantidad;
	private static long milis = 300;
	
	
	public Botella(String nombre, char caracter, Integer cantidad) {
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
		Botella b1 = new Botella("b1", '*', 10);
		Botella b2 = new Botella("b2", 'p', 10);

		b1.start();
		b2.run();
		//también podemos poner los dos en start 
	}
	
	

}
