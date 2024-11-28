package paquete_1_5;

public class RSorteoSimulator implements Runnable {
    private SorteoSimulator sorteoSimulator;

    public RSorteoSimulator(SorteoSimulator sorteoSimulator) {
        this.sorteoSimulator = sorteoSimulator;
    }

    @Override
    public void run() {
        sorteoSimulator.generaUnaCombinacionGanadora(300);
    }

}
