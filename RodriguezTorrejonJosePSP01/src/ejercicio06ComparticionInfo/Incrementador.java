package ejercicio06ComparticionInfo;


public class Incrementador implements Runnable {
    private ContadorCompartido contadorCompartido;

    public Incrementador(ContadorCompartido contadorCompartido) {
        this.contadorCompartido = contadorCompartido;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {  // Incrementar el contador 5 veces
            contadorCompartido.incrementar();
            try {
                Thread.sleep(500);  // Simular trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
