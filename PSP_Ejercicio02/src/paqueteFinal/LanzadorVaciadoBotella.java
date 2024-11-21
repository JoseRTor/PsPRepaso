package paqueteFinal;

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
		 Botella b1= new Botella("b1", 'j', 10);
		 Botella b2 = new Botella ("b2", 'a', 10);
		 new LanzadorVaciadoBotella(b1).start();
		 new LanzadorVaciadoBotella(b2).start();


		
	}
	
	

}
