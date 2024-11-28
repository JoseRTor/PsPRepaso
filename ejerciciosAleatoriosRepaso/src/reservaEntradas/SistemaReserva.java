package reservaEntradas;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SistemaReserva {
	private Map<String, Evento> eventos = new ConcurrentHashMap<String, Evento>();

	public void agregarEvento(String nombre, Integer cantidad) {
		Evento evento = new Evento(nombre, cantidad);
		eventos.put(nombre, evento);
	}

	public Boolean reservar(String nombre, Integer cantidad) {

		Evento evento = eventos.get(nombre);
		if (evento != null) {
			evento.reservarEntradas(cantidad);
			return true;
		} else {
			return false;
		}

	}
	
	public Integer entradasRestantes (String nombreEvento) {
		Evento evento = eventos.get(nombreEvento);
		return evento.getEntradas();
	}

}
