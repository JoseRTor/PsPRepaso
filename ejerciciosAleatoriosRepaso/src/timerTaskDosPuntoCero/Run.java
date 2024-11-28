package timerTaskDosPuntoCero;

import java.util.Timer;

public class Run {
	public static void main(String[] args) {
		DefinicionEmisor d = new DefinicionEmisor('c', 6, "Juan");
		EmisorTimerTask e = new EmisorTimerTask(d);
		Timer t = new Timer();
		t.scheduleAtFixedRate(e, 0, 500);
	}
}
