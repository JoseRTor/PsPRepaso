package ejercicio04TimerTimerTask;

import java.util.TimerTask;

public class EmisorTimerTask extends TimerTask {
	private DefinicionEmisor definicionEmisor;
	private int pulsos;
	public EmisorTimerTask(DefinicionEmisor definicionEmisor) {
		this.definicionEmisor = definicionEmisor;
		this.pulsos = definicionEmisor.getPulsos();
	}
	@Override
	public void run() {
		if(pulsos > 0) {
			definicionEmisor.emiteUnintariamente();
			pulsos--;
		} else {
			cancel();
		}
	}
}
