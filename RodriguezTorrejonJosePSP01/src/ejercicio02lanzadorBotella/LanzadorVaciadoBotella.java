package ejercicio02lanzadorBotella;

public class LanzadorVaciadoBotella extends Thread {
	private Botella botella;

	public LanzadorVaciadoBotella(Botella botella) {
		this.botella = botella;
	}
	
	@Override
	public void run() {
		botella.vaciar();
	}
	
	public static void main(String[] args) {
		Botella b1 = new Botella("B-1", '*', 10);
		LanzadorVaciadoBotella lanzador1 = new LanzadorVaciadoBotella(b1);
		lanzador1.start();
		
		Botella b2 = new Botella("B-2", '-', 6);
		new LanzadorVaciadoBotella(b2).start();
	}
}
