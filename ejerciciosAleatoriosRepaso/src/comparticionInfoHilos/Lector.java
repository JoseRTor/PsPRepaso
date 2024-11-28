package comparticionInfoHilos;

public class Lector implements Runnable{
	private ContadorCompartido c;

	public Lector(ContadorCompartido c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		
		System.out.println(c.obtenerValor());
	}
	

}
