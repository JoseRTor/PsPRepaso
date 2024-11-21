package ejercicioPSP;

public class Emisor {

	private String nombre;
	private char caracter;
	private static long milis = 300;
	private Integer tiempo;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public static long getMilis() {
		return milis;
	}

	public static void setMilis(long milis) {
		Emisor.milis = milis;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Emisor(String nombre, char caracter, Integer tiempo) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.tiempo = tiempo;
	}

	public Emisor(char caracter, Integer tiempo) {
		this.caracter = caracter;
		this.tiempo = tiempo;
	}

	public void emite() {
		final String ANSI_RESET = "\u001B[0m"; // Resetea el color
		final String ANSI_GREEN = "\u001B[32m"; // Color verde
		final String ANSI_RED = "\u001B[31m"; // Color rojo

		long milisFinales = System.currentTimeMillis() + tiempo * 1_000;

		long milisParar = System.currentTimeMillis() + 300;
		System.out.print(ANSI_GREEN + caracter + ANSI_RESET);

		while (System.currentTimeMillis() < milisFinales) {
			if(Thread.currentThread().isInterrupted())return;
			if (System.currentTimeMillis() > milisParar) {
				System.out.print(caracter);
				milisParar = System.currentTimeMillis() + 300;
			}
		}
		System.out.print(ANSI_RED + caracter + ANSI_RESET);

	}
	


	public static void main(String[] args) {
		Emisor prueba = new Emisor("Jose", '*', 4);

		prueba.emite();
	}

//	public void cambiarColor() {
//		
//		if (milis == 300) {
//			System.out.println("\u001B[32m " + caracter);
//		}else if (milis < 300 && milis == 0) {
//			System.out.println(caracter);
//		}else {
//			System.out.println("\u001B[31m " + caracter);
//		}
//		
//		
//	}

}
