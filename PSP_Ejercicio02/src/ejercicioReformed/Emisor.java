package ejercicioReformed;

public class Emisor {

	private String palabro;
	private static long milis = 300;

	public Emisor(String palabro) {
		this.palabro = palabro;
	}

	public void vaciar() {
		while (true) {
			System.out.print(palabro);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
			}

		}
	}

}
