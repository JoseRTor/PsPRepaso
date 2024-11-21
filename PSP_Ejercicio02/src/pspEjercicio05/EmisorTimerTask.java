package pspEjercicio05;

import java.util.TimerTask;

public class EmisorTimerTask extends TimerTask {
	private DefinicionEmisor definicionEmisor;
	private int pulsos;

	public EmisorTimerTask(DefinicionEmisor definicionEmisor) {
		super();
		this.definicionEmisor = definicionEmisor;
		this.pulsos = definicionEmisor.getPulsos();
	}

	@Override
	public void run() {
		if (pulsos > 0) {
			definicionEmisor.emiteUnitariamente();
			pulsos--;
		} else {
			cancel();
		}

	}

}
