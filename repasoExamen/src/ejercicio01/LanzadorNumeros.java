package ejercicio01;

public class LanzadorNumeros extends Thread{
	private SorteoSimulator s;
	
	
	
	public LanzadorNumeros(SorteoSimulator s) {
		this.s = s;
	}



	@Override
	public void run() {
		try {
			s.generaUnaCombinacionGanadora(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		LanzadorNumeros l = new LanzadorNumeros(new SorteoSimulator());
		l.start();
		
	}

}
