package ejercicioTimerTimerTask;

import java.util.TimerTask;

public class EmisorTimerTask extends TimerTask{
	private DefinicionEmisor def;
	private int tiempoRestante;
	
	
	
	public EmisorTimerTask(DefinicionEmisor def) {
		this.def = def;
		this.tiempoRestante = def.getSegundos();
	}



	@Override
	public void run() {
		if(tiempoRestante > 0) {
			def.emiteUnitariamente();
			tiempoRestante--;
		}else {
			cancel();
		}
		
	}

}
