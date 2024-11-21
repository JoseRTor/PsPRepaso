package ejercicio04TimerTimerTask;

public class DefinicionEmisor {
	private String nombre;
	private char caracter;
	private int pulsos;
	
	public DefinicionEmisor(char caracter, int pulsos) {
		this.caracter = caracter;
		this.pulsos = pulsos;
	}
	public DefinicionEmisor(String nombre, char caracter, int pulsos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.pulsos = pulsos;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public int getPulsos() {
		return pulsos;
	}
	
	public void emiteUnintariamente() {
		System.out.print(caracter);
     
	}
	
}
