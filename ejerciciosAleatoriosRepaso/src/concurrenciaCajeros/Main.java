package concurrenciaCajeros;

public class Main {
	public static void main(String[] args) {
		CuentaBancaria c = new CuentaBancaria(1500);
		Cliente cliente = new Cliente(c, "Anita");
		Cliente cliente2 = new Cliente(c, "William");
		Cliente cliente3 = new Cliente(c, "Oreo");
		
		Thread t1 = new Thread(cliente);
		Thread t2 = new Thread(cliente2);
		Thread t3 = new Thread(cliente3);
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.imprimir();

	}
}
