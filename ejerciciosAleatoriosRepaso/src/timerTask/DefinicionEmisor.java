package timerTask;

public class DefinicionEmisor {
	private char caracter;
	private int pulsos;
	private String nombre;
	public DefinicionEmisor(char caracter, int pulsos, String nombre) {
		this.caracter = caracter;
		this.pulsos = pulsos;
		this.nombre = nombre;
	}
	public char getCaracter() {
		return caracter;
	}
	public int getPulsos() {
		return pulsos;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void emiteUnitariamente() {
		System.out.print(caracter);
	}
}
