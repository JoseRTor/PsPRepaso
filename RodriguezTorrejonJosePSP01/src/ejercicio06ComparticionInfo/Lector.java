package ejercicio06ComparticionInfo;

public class Lector implements Runnable {
    private ContadorCompartido contadorCompartido;

    public Lector(ContadorCompartido contadorCompartido) {
        this.contadorCompartido = contadorCompartido;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int valor = contadorCompartido.obtenerValor();
            System.out.println(Thread.currentThread().getName() + " leyó el valor del contador: " + valor);
            try {
                Thread.sleep(500);  // Simular trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
