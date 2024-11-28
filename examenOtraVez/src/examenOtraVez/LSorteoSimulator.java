package examenOtraVez;

public class LSorteoSimulator {
	private SorteoSimulator s;

	public void bonolotoAlemana() {
		s = new SorteoSimulator("Sorteo bonoloto alemana", 1, 49, 6);
		Runnable run = new Runnable() {
			
			

			@Override
			public void run() {
				System.out.println(s);
				s.generaUnaCombinacion(500);
			}
		};
		Thread t = new Thread(run);
		t.start();
	}
}
