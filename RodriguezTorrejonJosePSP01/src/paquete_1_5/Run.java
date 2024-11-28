package paquete_1_5;

public class Run {
    public static void main(String[] args) {
        SorteoSimulator s = new SorteoSimulator("bonoloto española", 1, 49, 6);
        s.generaUnaCombinacionGanadora(300);

        SorteoSimulator s2 = new SorteoSimulator("bonoloto italiana", 1, 90, 5);
        TSorteoSimulator tSorteoSimulator = new TSorteoSimulator(s2);
        tSorteoSimulator.start();

        SorteoSimulator s3 = new SorteoSimulator("bonoloto francesa", 1, 49, 5);
        RSorteoSimulator rSorteoSimulator = new RSorteoSimulator(s3);
        new Thread(rSorteoSimulator).start();

        LSorteoSimulator lSorteoSimulator = new LSorteoSimulator();
        lSorteoSimulator.lanzarSorteo(300);


    }
}
