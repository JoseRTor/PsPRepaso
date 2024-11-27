package ejercicio02CopilotPracticaGenerada;

public class TaskProcessor implements Runnable {
	private String taskname;
	private Integer taskDuration;

	public TaskProcessor(String taskname) {
		this.taskname = taskname;
		taskDuration = 100;
	}

	@Override
	public void run() {
		while (taskDuration >= 0) {
			System.out.println("El estado de la instalación de " + taskname + " es de " + taskDuration + "%");
			taskDuration -= 10;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

// Mi prueba del main jejejejejejejje
//	public static void main(String[] args) {
//		TaskProcessor p1 = new TaskProcessor("Twitter");
//		p1.run();
//	}

}
