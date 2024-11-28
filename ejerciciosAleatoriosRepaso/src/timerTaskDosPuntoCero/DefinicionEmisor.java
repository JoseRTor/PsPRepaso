package timerTaskDosPuntoCero;

public class DefinicionEmisor {
	private char caracter;
	private int pulsos;
	private String nombre;
	public DefinicionEmisor(char caracter, int pulsos, String nombre) {
		this.caracter = caracter;
		this.pulsos = pulsos;
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
	public void emitir() {
		System.out.println(caracter);
	}
	
	

}
