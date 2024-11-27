package ejercicioExamenRepaso;

import java.util.ArrayList;
import java.util.List;

public class CountDown2 implements Runnable {
	private static final long milis = 100;
	private int start;
	private String nombre;

	public CountDown2(int start, String nombre) {
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
		List<Thread> lista = new ArrayList<Thread>();
		Thread t = new Thread(new CountDown2 (10, "C1"));
		Thread t1 = new Thread(new CountDown2 (11, "C2"));
		Thread t2 = new Thread(new CountDown2 (13, "C3"));
		System.out.println(t.getName() + " " + t.getState());
		System.out.println(t1.getName() + " " + t.getState());
		System.out.println(t2.getName() + " " + t.getState());
		lista.add(t);
		lista.add(t1);
		lista.add(t2);
		for (Thread thread : lista) {
			thread.start();
			System.out.println(thread.getName() + " " + t.getState());
		}
		while (t.isAlive() && t1.isAlive() && t2.isAlive()) {
			System.out.println(t.getName() + " " + t.getState());
			System.out.println(t1.getName() + " " + t.getState());
			System.out.println(t2.getName() + " " + t.getState());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(t.getName() + " " + t.getState());
		System.out.println(t1.getName() + " " + t.getState());
		System.out.println(t2.getName() + " " + t.getState());
		
		
	}

}