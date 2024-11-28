package timerTaskDosPuntoCero;

import java.util.TimerTask;

public class EmisorTimerTask extends TimerTask {
	private DefinicionEmisor d;
	private Integer tiempoRestante;
	
	

	public EmisorTimerTask(DefinicionEmisor d) {
		this.d = d;
		tiempoRestante = d.getPulsos();
	}



	@Override
	public void run() {
		if(tiempoRestante > 0) {
			d.emitir();
			tiempoRestante--;
		}else {
			cancel();
		}
		
	}

}
