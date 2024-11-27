package comparticionHilos;

public class Incrementador implements Runnable {
	private ContadorCompartido contador;

	public Incrementador(ContadorCompartido contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		contador.incrementar();
	}
	
	
}
