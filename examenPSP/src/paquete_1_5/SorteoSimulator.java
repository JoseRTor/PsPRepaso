package paquete_1_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorteoSimulator {
	
	private String nombreSorteo;
	private Integer bolaInicial;
	private Integer bolaFinal;
	private Integer cantidadBolas;

	
	
	
	public SorteoSimulator(String nombreSorteo) {
		super();
		this.nombreSorteo = nombreSorteo;
	}

	public void generaUnaCombinacionGanadora(Long milis) {
		cantidadBolas = 5;
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			lista.add(i);
		}
		Collections.shuffle(lista);
		System.out.println( nombreSorteo + " desde la bola " + lista.get(0) + " hasta la bola " + lista.getLast()
				+ " se han sacado un total de " + cantidadBolas);

		while (cantidadBolas >= 1) {

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(lista.get(cantidadBolas));
			cantidadBolas--;

		}

		System.out.println("Bonoloto les desea mucha suerte");

	}

	public void run() {

		this.generaUnaCombinacionGanadora(new Long(500));
	}

	public static void main(String[] args) {
		SorteoSimulator simulador = new SorteoSimulator("Bonoloto española");
		simulador.run();

	}
	
	
	
	
	
	
	
	
	
}
