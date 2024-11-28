package examenOtraVez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RSorteoSimulator implements Runnable {
	private String nombreSorteo;
	private Integer bInicial;
	private Integer bFinal;
	private Integer cantidad;

	public RSorteoSimulator(String nombreSorteo, Integer bInicial, Integer bFinal, Integer cantidad) {
		this.nombreSorteo = nombreSorteo;
		this.bInicial = bInicial;
		this.bFinal = bFinal;
		this.cantidad = cantidad;
	}

	public void generaUnaCombinacion(long milis) {
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = bInicial; i <= bFinal; i++) {
			numeros.add(i);
		}
		Collections.shuffle(numeros);
		for (int i = 0; i < cantidad; i++) {
			System.out.println(numeros.get(i));
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Bonoloto les desea mucha suerte");
	}

	@Override
	public void run() {
		generaUnaCombinacion(400);
	}

	@Override
	public String toString() {
		return nombreSorteo + " desde la bola " + bInicial + " a la " + bFinal + " se extraen " + cantidad + " bolas,";
	}
}
