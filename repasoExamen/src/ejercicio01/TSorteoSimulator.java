package ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TSorteoSimulator extends Thread {
	private String nombre;
	private Integer bInicial;
	private Integer bFinal;
	private Integer cantidad;

	public TSorteoSimulator() {
		nombre = "Sorteo bonoloto italiana";
		cantidad = 5;
		bInicial = 1;
		bFinal = 90;

	}

	public void generaUnaCombinacionGanadora(long milis) throws InterruptedException {
		System.out.println(nombre + " dede la bola " + bInicial + " a la bola " + bFinal + " donde se extraen "
				+ cantidad + " bolas.");
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = bInicial; i <= bFinal; i++) {
			numeros.add(i);
		}
		Collections.shuffle(numeros);
		for (int i = 0; i < cantidad; i++) {
			System.out.println("-" + numeros.get(i));
			Thread.sleep(milis);
		}
		System.out.println("bonoloto les desea mucha suerte.");
	}
}
