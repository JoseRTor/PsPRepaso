package ejercicioTimerTimerTask;

public class DefinicionEmisor {
	private char caracter;
	private int segundos;

	public DefinicionEmisor(char caracter, int segundos) {
		this.caracter = caracter;
		this.segundos = segundos;
	}

	public char getCaracter() {
		return caracter;
	}

	public int getSegundos() {
		return segundos;
	}

	public void emiteUnitariamente() {
		System.out.println(caracter);
	}

}
