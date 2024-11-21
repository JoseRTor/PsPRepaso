package progressBar;

public class LprogressBar {
	
	public void lanzador() {
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				ProgressBar prueba = new ProgressBar();
						prueba.cargaBarra();
				
			}
		};
		Thread hilo = new Thread(run);
		hilo.start();

		
	}

}
