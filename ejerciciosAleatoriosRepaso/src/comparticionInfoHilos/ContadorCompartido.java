package comparticionInfoHilos;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorCompartido {
	private AtomicInteger contador = new AtomicInteger(0);
	
	public synchronized void incrementar() {
		contador.incrementAndGet();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized AtomicInteger obtenerValor() {
		return (AtomicInteger) contador;
	}
	
}
