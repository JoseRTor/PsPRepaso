package ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RSorteoSimulator implements Runnable{
	private String nombre;
	private Integer nInicial;
	private Integer nFinal;
	private Integer cantidad;

	public RSorteoSimulator(String nombre, Integer nInicial, Integer nFinal, Integer cantidad) {
		this.nombre = nombre;
		this.nInicial = nInicial;
		this.nFinal = nFinal;
		this.cantidad = cantidad;
	}

	private void combinacion(long milis) {
		List<Integer> bolas = new ArrayList<Integer>();

		for (int i = nInicial; i <= nFinal; i++) {
			bolas.add(i);
		}
		Collections.shuffle(bolas);

		for (int i = 0; i < cantidad; i++) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(bolas.get(i));
		}

		System.out.println("bonoloto les desea mucha suerte");

	}
	@Override
	public String toString() {

		return nombre + " desde la bola " + nInicial + " a la " + nFinal + " se extraen " + cantidad + " bolas";
	}
	@Override
	public void run() {	
		combinacion(500);
		
	}

}
