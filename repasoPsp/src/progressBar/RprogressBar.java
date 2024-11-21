package progressBar;

public class RprogressBar implements Runnable{
	
	private ProgressBar prueba;

	public RprogressBar() {
		this.prueba = new ProgressBar();
	}

	@Override
	public void run() {
		this.prueba.cargaBarra();
		
	}
	
	
	
	
}
