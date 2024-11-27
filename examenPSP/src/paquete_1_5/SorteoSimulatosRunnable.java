package paquete_1_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SorteoSimulatosRunnable implements Runnable{

	private String nombreSorteo;
	private Integer bolaInicial;
	private Integer bolaFinal;
	private Integer cantidadBolas;
	
	
	

	public SorteoSimulatosRunnable(String nombreSorteo) {
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
		System.out.println(nombreSorteo+" desde la bola " + lista.get(0) + " hasta la bola " + lista.getLast()
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
	
	
	
	
	
	@Override
	public void run() {
		this.generaUnaCombinacionGanadora(new Long(500));
		
	}
	
	public static void main(String[] args) {
		SorteoSimulatosRunnable sorteo = new SorteoSimulatosRunnable("bonoloto francesa");
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		executor.execute(sorteo);
		
	}

}
