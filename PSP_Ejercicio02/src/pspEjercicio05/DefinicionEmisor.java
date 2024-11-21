package pspEjercicio05;

public class DefinicionEmisor {

	private String nombre;
	private char caracter;
	private int pulsos;

	public DefinicionEmisor(String nombre, char caracter, int pulsos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.pulsos = pulsos;
	}

	public DefinicionEmisor(char caracter, int pulsos) {
		this.caracter = caracter;
		this.pulsos = pulsos;
	}

	public String getNombre() {
		return nombre;
	}

	public char getCaracter() {
		return caracter;
	}

	public int getPulsos() {
		return pulsos;
	}

	public void emiteUnitariamente() {
		System.out.print(caracter + " ");

	}

}
