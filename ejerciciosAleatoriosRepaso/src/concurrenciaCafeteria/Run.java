package concurrenciaCafeteria;

public class Run {
	public static void main(String[] args) {
		Cafeteria cafeteria = new Cafeteria();
		// ... 	
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread (new Alumno (cafeteria));
			t.start();
			if (i > 20) {
				Thread t1 = new Thread (new Profesor (cafeteria));
				t1.start();
			}
		}
		
	}
}
