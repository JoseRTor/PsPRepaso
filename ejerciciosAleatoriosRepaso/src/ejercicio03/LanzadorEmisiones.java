package ejercicio03;

public class LanzadorEmisiones extends Thread{
	private String nombre;
	private Emisor emisor;
	public LanzadorEmisiones(String nombre, Emisor emisor) {
		super();
		this.nombre = nombre;
		this.emisor = emisor;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lanzador de emisiones");
		sb.append("====================");
		sb.append("- Nombre : " + nombre);
		sb.append(" Emisor : " + emisor.getNombre());
		sb.append(" Hilo ");
		sb.append("- name : " + getName());
		sb.append(" id " + getId());
		sb.append(" alive " + isAlive());
		sb.append("state" + getState());
		sb.append("prioridad " + getPriority());
		sb.append(" interr " + isInterrupted());
		sb.append(" threadgroup " + getThreadGroup() );










		return sb.toString();
	}
	
	@Override
	public void run() {
		emisor.emite();
	}
	
	

	

}
