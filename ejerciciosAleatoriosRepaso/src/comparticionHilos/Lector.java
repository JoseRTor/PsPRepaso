package comparticionHilos;

public class Lector implements Runnable {
	private ContadorCompartido contador;

	public Lector(ContadorCompartido contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		int num = contador.obtenerValor();
        System.out.println(Thread.currentThread().getName() + " leyó el valor del contador: " + num);	}

}
