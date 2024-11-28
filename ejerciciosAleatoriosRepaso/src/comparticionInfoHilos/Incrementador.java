package comparticionInfoHilos;

public class Incrementador implements Runnable{
	private ContadorCompartido c;

	public Incrementador(ContadorCompartido c) {
		this.c = c;
	}

	@Override
	public void run() {
		c.incrementar();
	}
	
	
	
}
