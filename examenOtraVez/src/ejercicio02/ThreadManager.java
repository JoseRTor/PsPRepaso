package ejercicio02;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreadManager {

    private List<Thread> threads = new ArrayList<>();
    private TreeMap<Long, String> threadStates = new TreeMap<>();

    public void startThreads() {
    	for (int i = 0; i < 3; i++) {
			threads.add( new Thread (new CountDown("Juan "+ i, 10 + i)));
		}
    	for (Thread thread : threads) {
			long timesnap = System.currentTimeMillis();
			threadStates.put(timesnap, "--------->" + thread.getName() + "------->" + thread.getState().toString());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thread.start();
		}
    	// Crea tres hilos CountDown con diferentes valores iniciales
        // y añádelos a la lista threads. Valores: 
    	  //   - "C1", 10
    	  //   - "C2", 8
    	  //   - "C3", 7


        // Inicia los hilos recorriendo la lista threads
        
        // Guarda el estado de cada hilo en el Map

    }

    public void monitoreaThreads() throws InterruptedException {
        boolean allThreadsTerminated = false;
        
        while(!allThreadsTerminated) {
        	allThreadsTerminated = true;
        	for (Thread thread : threads) {
    			long timesnap = System.currentTimeMillis();
    			threadStates.put(timesnap, "--------->" + thread.getName() + "------->" + thread.getState().toString());
    			Thread.sleep(90);
    			if(thread.getState() != Thread.State.TERMINATED) {
    				allThreadsTerminated = false;
    			}
			}
        	
        	
        }

        // Monitorea hasta que todos los hilos hayan terminado.
        // Para ello cada 90 milisegundos aproximadamente
        // almacena en el map para cada hilo la información:
        //    - clave -> timestamp 
        //    - valor -> cadena con nombre y estado 
        //    - ejemplo de la cadena: C1:RUNNABLE
        // y vefica si todos han terminado.
    }

    public void printThreadStates() {
        // Imprimir todos los estados registrados en el TreeMap
        System.out.println("\nResumen de estados de los hilos:");
        for (Map.Entry<Long, String> entry : threadStates.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.startThreads();
        manager.monitoreaThreads();
        manager.printThreadStates();
        // Responde brevemente a las siguientes preguntas:
        //  1.- Motivo de la frecuencia del estado RUNNABLE
        //  2.- Motivo de la frecuencia del estado TIMED_WAITING
        //  3.- Motivo de la frecuencia del estado TERMINATED
        System.out.println("Respuestas a las preguntas");
        System.out.println("1: ");
        System.out.println("2: ");
        System.out.println("3: ");       
    }
}
