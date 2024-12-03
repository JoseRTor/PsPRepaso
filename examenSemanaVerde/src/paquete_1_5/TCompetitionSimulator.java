package paquete_1_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TCompetitionSimulator extends Thread{
	private String nombre;
	private Map<String, Integer> mapa;
	private Integer numRondas;

	public TCompetitionSimulator(String nombre, Integer numRondas) {
		this.nombre = nombre;
		this.numRondas = numRondas;
		mapa = new HashMap<String, Integer>();
	}

	public void simulaRondas(long milis) {
		mapa.put("UniversidadA", 0);
		mapa.put("UniversidadB", 0);
		mapa.put("UniversidadC", 0);
		Random random = new Random();

		for (int i = 0; i <= numRondas; i++) {
			Integer numRandom = random.nextInt(1, 4);
			if (numRandom == 1) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("UniversidadA") + numRandomSuma;
				mapa.put("EquipoA", puntos);
				System.out.println("Ronda " + i + " : UniversidadA gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 2) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("UniversidadB") + numRandomSuma;
				mapa.put("EquipoB", puntos);
				System.out.println("Ronda " + i + " : UniversidadB gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 3) {
				Integer numRandomSuma = random.nextInt(1, 11);

				Integer puntos = mapa.get("UniversidadC") + numRandomSuma;
				mapa.put("EquipoC", puntos);
				System.out.println("Ronda " + i + " : UniversidadC gana " + numRandomSuma + " puntos. Total: " + puntos);

			}
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
		return nombre + " Con 3 equipos : UniversidadA (0 puntos), UniversidadB (0 puntos), UniversidadC (0 puntos)";
	}
	
	
	
	@Override
	public void run() {
		simulaRondas(500);
	}
}
