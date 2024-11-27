package timerTask;

import java.util.Timer;

public class Test {
	public static void main(String[] args) {
		EmisorTimerTask e1 = new EmisorTimerTask(new DefinicionEmisor('*', 6, "William"));
		Timer t1 = new Timer();
		t1.scheduleAtFixedRate(e1, 0, 1000);
		
	}
}
