package ejercicioConcurrenciaConcierto;

import java.util.concurrent.ConcurrentHashMap;

public class SistemaReserva {
    private ConcurrentHashMap<String, Evento> eventos = new ConcurrentHashMap<>();

	public void agregarEvento(String nombre, int cantidadentradas) {
		Evento evento = new Evento(nombre, cantidadentradas);
		eventos.put(nombre, evento);
	}
	
	public boolean reveservar(String nombre, int cantidad) {
		Evento evento = eventos.get(nombre);
		
		if(evento != null) {
			System.out.println("Se ha reservado correctamente");
			return evento.reservarEntradas(cantidad);
		}else {
			System.out.println("no hay puto");
			return false;
		}
	}

	public int entradasRestantes(String nombre) {
		Evento evento = eventos.get(nombre);
		if (evento != null) {
		return evento.getEntradasDisponibles();
		}
		return 0;
	}
}
