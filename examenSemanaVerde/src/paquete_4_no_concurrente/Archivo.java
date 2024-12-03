package paquete_4_no_concurrente;

public class Archivo {
	private String nombre;
	private int tamano;

	public Archivo(String nombre, int tamano) {
		this.nombre = nombre;
		this.tamano = tamano;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTamano() {
		return tamano;
	}
}
