package ejercicio07;
public class Emisor implements Runnable{
		private String nombre;
    private char caracter;   // El carácter a emitir
    private int segundos;    // La cantidad de segundos a emitir el carácter

    // Constructor de la clase Emisor
    public Emisor(char caracter, int segundos, String nombre) {
        this.caracter = caracter;
        this.segundos = segundos;
        this.nombre = nombre;
    }
    public Emisor(char caracter, int segundos) {
        this.caracter = caracter;
        this.segundos = segundos;
    }

    public String getNombre() {
		return nombre;
	}
	// Método que emite el carácter cada 300 ms mientras transcurren los segundos indicados
    public void emite() {
    	final String ANSI_RESET = "\u001B[0m";    // Resetea el color
    	final String ANSI_GREEN = "\u001B[32m";   // Color verde
        final String ANSI_RED = "\u001B[31m";     // Color rojo
    	
    	long tiempoFinal = System.currentTimeMillis() + (segundos * 1000);  // Tiempo de finalización
        long tiempoUltimaImpresion = System.currentTimeMillis();  // Marca de tiempo de la última impresión
        
        System.out.printf(ANSI_GREEN + "%c" + ANSI_RESET, caracter);  // Empezando a emitir
        // Bucle que mantiene a la CPU trabajando constantemente
        while (System.currentTimeMillis() < tiempoFinal) {
            long tiempoActual = System.currentTimeMillis();
            if(Thread.currentThread().isInterrupted()) {
            	return;
            }
            // Si han pasado 300 milisegundos desde la última impresión
            if (tiempoActual - tiempoUltimaImpresion >= 300) {
                System.out.print(caracter);  // Imprime el carácter
                tiempoUltimaImpresion = tiempoActual;  // Actualiza el tiempo de la última impresión
            }

            // La CPU sigue trabajando aquí sin pausa, realizando iteraciones hasta que pasen los 300 ms.
        }
        System.out.printf(ANSI_RED + "%c" + ANSI_RESET, caracter);  // Terminando de transmitir
    }
	@Override
	public void run() {
		emite();
		
	}
}
