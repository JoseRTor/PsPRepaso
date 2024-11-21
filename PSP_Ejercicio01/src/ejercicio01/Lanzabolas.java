package ejercicio01;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Lanzabolas implements Runnable {

	private String nombre;
	

	public Lanzabolas(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void run() {
		LocalTime fecha = LocalTime.now();
		DateTimeFormatter huevins = DateTimeFormatter.ofPattern("hh:mm:ss.SSS");
		System.out.println("Lanzando bola desde " + nombre + " a las " + fecha.format(huevins));

	}

}
