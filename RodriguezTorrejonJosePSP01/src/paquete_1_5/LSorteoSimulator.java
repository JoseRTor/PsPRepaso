package paquete_1_5;

public class LSorteoSimulator {
    public void lanzarSorteo(long milis) {
        Runnable sorteoRunnable = new Runnable() {
            @Override
            public void run() {
                SorteoSimulator sorteo = new SorteoSimulator("bonoloto alemana", 1, 49, 6);
                sorteo.generaUnaCombinacionGanadora(milis);
            }
        };
        Thread hilo = new Thread(sorteoRunnable);
        hilo.start();

    }
}
