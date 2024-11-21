package ejercicio012Runnable;

public class Main {
	public static void main(String[] args) {
		Botella b1 = new Botella("B-1", '*', 10);
		Thread hilo1 = new Thread(b1);
		hilo1.start();
		
		Botella b2 = new Botella("B-2", '-', 6);
		new Thread(b2).start();
	}
}
