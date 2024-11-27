package ejercicioTimerTimerTask;

import java.util.Timer;

public class Test {
	public static void main(String[] args) {

		DefinicionEmisor d1 = new DefinicionEmisor('¿', 7);
		EmisorTimerTask e1 = new EmisorTimerTask(d1);
		Timer t1 = new Timer();
		t1.scheduleAtFixedRate(e1, 0, 1000);
	}
}
