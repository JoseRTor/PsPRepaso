package ejercicioExamenRepaso;

public class CountDown implements Runnable{
	private static final long milis = 100;
	private int start;
	private String nombre;
	public CountDown(int start, String nombre) {
		this.start = start;
		this.nombre = nombre;
	}
	
	private void cuentaAtras() {
		
		for (int i = 0; i < start; i++) {
			System.out.println(nombre + " " + i);
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@Override
	public void run() {
		cuentaAtras();
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new CountDown (12,"C1"));
		System.out.println(t.getName() + " " + t.getState());
		t.start();
		System.out.println(t.getName() + " " + t.getState());
		

		
		
		while(t.isAlive()) {
			System.out.println(t.getName() + " " + t.getState());
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println(t.getName() + " " + t.getState());
			}
		}
		System.out.println(t.getName() + " " + t.getState());

		
	}

}
