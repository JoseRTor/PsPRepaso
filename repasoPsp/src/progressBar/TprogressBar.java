package progressBar;

public class TprogressBar extends Thread{
	private ProgressBar prueba;

	public TprogressBar() {
		this.prueba = new ProgressBar();
	}
	
	@Override
	public void run() {
		this.prueba.cargaBarra();
	}
	
	
	public static void main(String[] args) {
		TprogressBar prueba = new TprogressBar();
		prueba.start();
	}

}
