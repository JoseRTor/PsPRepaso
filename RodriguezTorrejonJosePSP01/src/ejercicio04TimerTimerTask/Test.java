package ejercicio04TimerTimerTask;

import java.util.Timer;

public class Test {
	public static void main(String[] args) {
		DefinicionEmisor de1 = new DefinicionEmisor('*', 5);
		Timer t1 = new Timer();
		EmisorTimerTask tt1 = new EmisorTimerTask(de1);
		
		System.out.print("Iniciando emisión ...");
		t1.scheduleAtFixedRate(tt1, 0, 500);	
	}
}
