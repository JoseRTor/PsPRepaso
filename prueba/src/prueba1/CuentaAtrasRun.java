package prueba1;

import java.util.concurrent.atomic.AtomicInteger;

public class CuentaAtrasRun implements Runnable {
	private int valorMaximo;
	private String nombre;
	private int valor;
	private static AtomicInteger ejecuciones = new AtomicInteger(0);
	private AtomicInteger ejecucionesInstancia = new AtomicInteger(0);
	private static int milis = 1;
	
	public static AtomicInteger getEjecuciones() {
		return ejecuciones;
	}

	public static void setEjecuciones(AtomicInteger ejecuciones) {
		CuentaAtrasRun.ejecuciones = ejecuciones;
	}

	public AtomicInteger getEjecucionesInstancia() {
		return ejecucionesInstancia;
	}

	public void setEjecucionesInstancia(AtomicInteger ejecucionesInstancia) {
		this.ejecucionesInstancia = ejecucionesInstancia;
	}

	@Override
	public void run() {
		ejecuciones.incrementAndGet();
		ejecucionesInstancia.incrementAndGet();
		for (this.valor = valorMaximo; valor >= 0; valor--) {

			System.out.println(this.toString());
			

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public String toString() {
		return "CuentaAtras [valorMaximo=" + valorMaximo + ", nombre=" + nombre + ", valor=" + valor + "]";
	}

	public CuentaAtrasRun(int valorMaximo, String nombre) {
		this.valorMaximo = valorMaximo;
		this.nombre = nombre;
		
	}

	public static void main(String[] args) {
		CuentaAtrasRun c1= new CuentaAtrasRun(10, "J");
		int veces = 100000;
		for (int i = 0; i < veces; i++) {
			new Thread(c1).start();
		}
		
		try {
			Thread.sleep(milis * veces / 10);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.getEjecucionesInstancia());
		System.out.println(c1.getEjecuciones());


	}
	

	

}
