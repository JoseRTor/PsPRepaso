package ejercicioPSP;

public class LanzadorEmisiones extends Thread {
	private String nombre;
	private Emisor emisor;

	
	public LanzadorEmisiones(String nombre, Emisor emisor) {
		this.nombre = nombre;
		this.emisor = emisor;
	}

	public void run() {
		emisor.emite();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lanzador de emisiones:\n");
		sb.append("======================\n");
		sb.append("- Nombre: " + nombre + "\n");
		sb.append("- Emisor: " + emisor.getNombre() + "\n");
		sb.append("- Hilo:\n");		
		sb.append("    - name: " + getName() + "\n");
		sb.append("    - id: " + getId() + "\n");
		sb.append("    - alive?: " + isAlive() + "\n");	
		sb.append("    - state: " + getState() + "\n");
		sb.append("    - prioridad: " + getPriority() + "\n");
		sb.append("    - interrumpido?: " + isInterrupted() + "\n");
		sb.append("    - threadGroup: " + getThreadGroup() + "\n");
		return sb.toString();

	}
}
