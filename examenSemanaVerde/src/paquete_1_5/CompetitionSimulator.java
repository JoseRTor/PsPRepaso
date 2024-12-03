package paquete_1_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CompetitionSimulator {
	private String nombre;
	private Map<String, Integer> mapa;
	private Integer numRondas;

	public CompetitionSimulator(String nombre, Integer numRondas) {
		this.nombre = nombre;
		this.numRondas = numRondas;
		mapa = new HashMap<String, Integer>();
	}

	public void simulaRondas(long milis) {
		mapa.put("EquipoA", 0);
		mapa.put("EquipoB", 0);
		mapa.put("EquipoC", 0);
		Random random = new Random();

		for (int i = 0; i <= numRondas; i++) {
			Integer numRandom = random.nextInt(1, 4);
			if (numRandom == 1) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("EquipoA") + numRandomSuma;
				mapa.put("EquipoA", puntos);
				System.out.println("Ronda " + i + " : EquipoA gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 2) {
				Integer numRandomSuma = random.nextInt(1, 11);
				Integer puntos = mapa.get("EquipoB") + numRandomSuma;
				mapa.put("EquipoB", puntos);
				System.out.println("Ronda " + i + " : EquipoB gana " + numRandomSuma + " puntos. Total: " + puntos);

			} else if (numRandom == 3) {
				Integer numRandomSuma = random.nextInt(1, 11);

				Integer puntos = mapa.get("EquipoC") + numRandomSuma;
				mapa.put("EquipoC", puntos);
				System.out.println("Ronda " + i + " : EquipoC gana " + numRandomSuma + " puntos. Total: " + puntos);

			}
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(mapa.get("EquipoA") > mapa.get("EquipoB")) {
			
			if(mapa.get("EquipoA") > mapa.get("EquipoC")) {
			System.out.println("Ha ganado EquipoA");
			}else {
				System.out.println("Ha ganado EquipoC");
			}
			
		} else {
			if(mapa.get("EquipoB") > mapa.get("EquipoC")) {
				System.out.println("Gana equipoB");
			}else {
				System.out.println("Gana equipoC");
			}
		}


	}

	@Override
	public String toString() {
		return nombre + " Con 3 equipos : EquipoA (0 puntos), EquipoB (0 puntos), EquipoC (0 puntos)";
	}

}
