package manejoHilos;
public class Emisor {
	private String nombre;
	private char caracter;
	private int segundos;
	public Emisor(char caracter, int segundos) {
		this.caracter = caracter;
		this.segundos = segundos;
	}
	public Emisor(String nombre, char caracter, int segundos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.segundos = segundos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void emite() {
    	final String ANSI_RESET = "\u001B[0m";    // Resetea el color
    	final String ANSI_GREEN = "\u001B[32m";   // Color verde
        final String ANSI_RED = "\u001B[31m";     // Color rojo
		
        long tiempoFinal = System.currentTimeMillis() 
        		+ segundos * 1000;
        long tiempoUltimaImpresion = System.currentTimeMillis();
        System.out.print(ANSI_GREEN + caracter + ANSI_RESET);
        
        while(System.currentTimeMillis() < tiempoFinal) {
        	if(Thread.currentThread().isInterrupted()) return;	
        	// han pasado 300 miliseguindos desde la última impresión
        	if(System.currentTimeMillis() - tiempoUltimaImpresion > 300) {
        		System.out.print(caracter);
        		tiempoUltimaImpresion = System.currentTimeMillis();
        	}
        }
        System.out.print(ANSI_RED + caracter + ANSI_RESET);
	}
}