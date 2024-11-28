package comparticionInfoHilos;

public class Test {

	public static void main(String[] args) {
		ContadorCompartido c = new ContadorCompartido();	
		for (int i = 0; i <= 599; i++) {
			new Thread ( new Incrementador(c)).start();
			}
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread ( new Lector(c)).start();

	}
	
}
