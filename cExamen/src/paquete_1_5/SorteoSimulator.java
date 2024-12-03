package paquete_1_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorteoSimulator {

    private final String nombreSorteo;
    private final int numeroBolaInicial;
    private final int numeroBolaFinal;
    private final int cantidadBolas;

    public SorteoSimulator(String nombreSorteo, int numeroBolaInicial, int numeroBolaFinal, int cantidadBolas) {
        this.nombreSorteo = nombreSorteo;
        this.numeroBolaInicial = numeroBolaInicial;
        this.numeroBolaFinal = numeroBolaFinal;
        this.cantidadBolas = cantidadBolas;
    }

    @Override
    public String toString() {
        return "Sorteo" + nombreSorteo + " desde la bola " + numeroBolaInicial +
                " a la " + numeroBolaFinal + " donde se extraen " + cantidadBolas + " bolas.";
    }

    public void generaUnaCombinacionGanadora(long milis) {
        int bolasSacadas = 0;
        Random r = new Random();
        List<Integer> listaBolasSacadas = new ArrayList<>();
        int bolaSacada = 0;

        do {
            while (listaBolasSacadas.contains(bolaSacada) || bolaSacada == 0) {
                bolaSacada = r.nextInt(numeroBolaInicial, numeroBolaFinal);
            }
            bolasSacadas++;
            listaBolasSacadas.add(bolaSacada);
            System.out.printf("\t-bonoloto: %d\n", bolaSacada);
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (bolasSacadas < cantidadBolas);
        System.out.println(nombreSorteo + " les desea mucha suerte.");

    }
}
