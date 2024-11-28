package paquete_1_5;

public class TSorteoSimulator extends Thread {

    private SorteoSimulator sorteoSimulator;

    public TSorteoSimulator(SorteoSimulator s) {
        sorteoSimulator = s;
    }


    @Override
    public void run() {
        sorteoSimulator.generaUnaCombinacionGanadora(300);
    }
}
