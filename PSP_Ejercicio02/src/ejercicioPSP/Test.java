package ejercicioPSP;

public class Test {

	public static void main(String[] args) {
		LanzadorEmisiones l1 = new LanzadorEmisiones("l1", new Emisor("e1", '*', 2));

		System.out.println("LANZADOR ANTES DE START");
		System.out.println(l1);
		l1.start();
		System.out.println();
		System.out.println("LANZADOR DESPUÉS DE START");
		System.out.println(l1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l1.interrupt();
		try {
			l1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("LANZADOR DESPUÉS DE TERMINAR");
		System.out.println(l1);

	}
}
