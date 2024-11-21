package ejercicio3;

public class BotellaDeCaracteres {

	private String nombre;
	private char caracter;
	private Integer cantidad;
	private static long milis = 300;
	
	
	public BotellaDeCaracteres(String nombre, char caracter, Integer cantidad) {
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
	
	public static void main(String[] args) {
		BotellaDeCaracteres b1 = new BotellaDeCaracteres("b1", '*', 10);
		BotellaDeCaracteres b2 = new BotellaDeCaracteres("b2", 'p', 10);

		b1.vaciar();
		b2.vaciar();
	}
	
	

}
