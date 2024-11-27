package ejercicio01;

public class LSorteoSimulator{
	private SorteoSimulator s;

	public void lanzarSimulador() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
			 s = new SorteoSimulator("Bonoloto William" , 7, 70, 13);
				s.combinacion(500);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
	
}
