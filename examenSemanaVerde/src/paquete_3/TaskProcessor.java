package paquete_3;

public class TaskProcessor implements Runnable {
    private String taskName;

    public TaskProcessor(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.printf("Procesando tarea: %s%n", taskName);
        try {
            Thread.sleep(200); // Simula tiempo de procesamiento
        } catch (InterruptedException e) {
            System.out.printf("La tarea %s fue interrumpida.%n", taskName);
        }
        System.out.printf("Tarea %s completada.%n", taskName);
    }
}


