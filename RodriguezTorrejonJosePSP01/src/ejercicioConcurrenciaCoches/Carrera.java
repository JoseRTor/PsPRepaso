package ejercicioConcurrenciaCoches;

public class Carrera {

	private Integer kmTotales;
	private String[] podio;
	private Integer personasEnPodio;
	
	public Carrera(Integer kmTotales, int podioSize) {
		this.kmTotales = kmTotales;
		podio = new String[podioSize];
		personasEnPodio = 0;
	}

	public Integer getKmTotales() {
		return kmTotales;
	}
	
	public synchronized void subirAlPodio(String nombreCoche) {
		if(personasEnPodio < podio.length) {
			podio[personasEnPodio] = nombreCoche;
			personasEnPodio++;
		}
	}
	
	public void imprimirPodio() {
		System.out.println("Podio de la carrera: ");
		for (int i = 0; i < podio.length; i++) {
			System.out.printf("\tLugar %d -> %s%n", i+1, podio[i]);
		}
	}
}
