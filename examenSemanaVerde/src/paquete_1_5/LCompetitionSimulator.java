package paquete_1_5;

public class LCompetitionSimulator {
	public void lanzarCompeticion() {
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				CompetitionSimulator comp = new CompetitionSimulator("Liga Mundial", 8);
				comp.simulaRondas(500);
			}
		};
		Thread thread = new Thread(run);
		thread.start();
	}
}
