package ejercicio06ComparticionInfo;


public class ContadorCompartido {
    private int contador = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        contador++;
        System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + contador);
    }

    // Método sincronizado para obtener el valor del contador
    public synchronized int obtenerValor() {
        return contador;
    }
}
