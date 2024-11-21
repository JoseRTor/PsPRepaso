package ejercicio07;

public class Emisor implements Runnable{

	private char caracter;
	private int segundos;
	public Emisor(char caracter, int segundos) {
		this.caracter = caracter;
		this.segundos = 300;
	}
	
	
	
	public void emite() {
		
		
		
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(caracter);
	}
	
	
	
	
	@Override
	public void run() {
		
	}
	
	

}
