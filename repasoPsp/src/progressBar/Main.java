package progressBar;

public class Main {
	public static void main(String[] args) {
		
		TprogressBar barra1 = new TprogressBar();
		barra1.start();
		
		new Thread  (new RprogressBar()).start();
		
		LprogressBar barra3 = new LprogressBar();
		barra3.lanzador();
		
	}
}