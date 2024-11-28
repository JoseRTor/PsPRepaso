package paquete_3;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ThreadManager {

    private List<Thread> threads = new ArrayList<>();
    private TreeMap<Long, String> threadStates = new TreeMap<>();

    public void startThreads() {
        CountDown c1 = new CountDown("C1", 10);
        CountDown c2 = new CountDown("C2", 8);
        CountDown c3 = new CountDown("C3", 7);

        threads.add(new Thread(c1));
        threads.add(new Thread(c2));
        threads.add(new Thread(c3));

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            threadStates.put(System.currentTimeMillis(), t.getName() + ":" + t.getState());
        });
    }

    public void monitoreaThreads() throws InterruptedException {
        boolean allThreadsTerminated = false;
        int hilosTotales = threads.size();
        int hilosTerminados = 0;

        while (!allThreadsTerminated) {
            for (Thread t : threads) {
                threadStates.put(System.currentTimeMillis(), t.getName() + ":" + t.getState());
                if (t.getState() == Thread.State.TERMINATED) {
                    hilosTerminados++;
                }
            }
            allThreadsTerminated = hilosTerminados == hilosTotales;
            Thread.sleep(90);
        }
    }

    public void printThreadStates() {
        // Imprimir todos los estados registrados en el TreeMap
        System.out.println("\nResumen de estados de los hilos:");
        threadStates.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.startThreads();
        manager.monitoreaThreads();
        manager.printThreadStates();
        // Responde brevemente a las siguientes preguntas:
        // 1.- Motivo de la frecuencia del estado RUNNABLE
        // 2.- Motivo de la frecuencia del estado TIMED_WAITING
        // 3.- Motivo de la frecuencia del estado TERMINATED
        System.out.println("Respuestas a las preguntas");
        System.out.println("1: La frecuencia es baja ya que se almacenan los estados cada 90 milis y el contador 'duerme' durante 100 ms," +
                " entonces solo al inicio coincide que" +
                " el hilo 0 está disponible para funcionar y no en espera.");
        System.out.println("2: La frecuencia es muy alta dado que se monitorea el estado cada 90ms, pero cada contador " +
                "duerme durante 100ms, por lo que la mayoría del tiempo está en espera con tiempo finito.");
        System.out.println("3: Sale porque los hilos 2 y 3 ya están acabados cuando al 1 todavía le queda ejecución, " +
                "exactamente le quedan 200ms más de ejecución, por eso sale al final y dos veces distanciado por 90ms (tiempo de monitoreo).");

    }
}
