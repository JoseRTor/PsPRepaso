package comparticionHilos;

public class Test {
	public static void main(String[] args) {
		
		ContadorCompartido c = new ContadorCompartido();
		
		for (int i = 0; i < 10; i++) {
			new Thread (new Incrementador(c)).start();;
			new Thread(new Lector(c)).start();;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
