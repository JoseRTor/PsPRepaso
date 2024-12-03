package paquete_1_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RCompetitionSimulator implements Runnable {
	
	private String nombre;
	private Map<String, Integer> mapa;
	private Integer numRondas;

	public RCompetitionSimulator(String nombre, Integer numRondas) {
		this.nombre = nombre;
		this.numRondas = numRondas;
		mapa = new HashMap<String, Integer>();
	}

	public void simulaRondas(long milis) {
		mapa.put("EquipoX", 0);
		mapa.put("EquipoY", 0);
		mapa.put("EquipoZ", 0);
		Random random = new Random();

		for (int i = 0; i <= numRondas; i++) {
			Integer numRandom = random.nextInt(1, 4);
			if (numRandom == 1) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("EquipoX") + numRandomSuma;
				mapa.put("EquipoX", puntos);
				System.out.println("Ronda " + i + " : EquipoX gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 2) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("EquipoY") + numRandomSuma;
				mapa.put("EquipoB", puntos);
				System.out.println("Ronda " + i + " : EquipoY gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 3) {
				Integer numRandomSuma = random.nextInt(1, 11);

				Integer puntos = mapa.get("EquipoZ") + numRandomSuma;
				mapa.put("EquipoC", puntos);
				System.out.println("Ronda " + i + " : EquipoZ gana " + numRandomSuma + " puntos. Total: " + puntos);

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
	public void run() {
		
		simulaRondas(500);
		
	}
	@Override
	public String toString() {
		return nombre + " Con 3 equipos : EquipoX (0 puntos), EquipoY (0 puntos), EquipoZ (0 puntos)";
	}
	
	
	
}

