package comparticionHilos;

public class ContadorCompartido {
	private int contador = 0;

	public synchronized void incrementar() {
		contador++;
	}
	public synchronized int obtenerValor() {
		return contador;
	}
}
