package ejersisio5;

import java.util.concurrent.ConcurrentHashMap;

public class SistemaReserva {
    private ConcurrentHashMap<String, Evento> eventos = new ConcurrentHashMap<>();

    public void agregarEvento(String nombre, int entradasDisponibles) {
        eventos.put(nombre, new Evento(nombre, entradasDisponibles));
    }

    public boolean reservar(String nombreEvento, int cantidad) {
        Evento evento = eventos.get(nombreEvento);
        if (evento != null) {
            return evento.reservarEntradas(cantidad);
        }
        return false;
    }

    public int entradasRestantes(String nombreEvento) {
        Evento evento = eventos.get(nombreEvento);
        return evento != null ? evento.getEntradasDisponibles() : 0;
    }
}