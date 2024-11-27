package ejercicio03;

public class Main {
	public static void main(String[] args) {
		LanzadorEmisiones l = new LanzadorEmisiones("MUERETEGORDODEPSP", new Emisor("Puta", '*', 1));
		System.out.println("Antes de iniciar");
		System.out.println(l);

		l.start();

		System.out.println("Después de iniciar");
		System.out.println(l);

		l.setPriority(10);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(l);

		l.interrupt();

		System.out.println("Tras la interrupción");
		System.out.println(l);
		
		try {
			l.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Tras la ejecución");
		System.out.println(l);
	}
}
