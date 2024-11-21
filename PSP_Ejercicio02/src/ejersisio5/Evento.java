package ejersisio5;

public class Evento {
    private String nombre;
    private int entradasDisponibles;

    public Evento(String nombre, int entradasDisponibles) {
        this.nombre = nombre;
        this.entradasDisponibles = entradasDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }

    public synchronized boolean reservarEntradas(int cantidad) {
        if (cantidad <= entradasDisponibles) {
            entradasDisponibles -= cantidad;
            return true;
        }
        return false;
    }
}