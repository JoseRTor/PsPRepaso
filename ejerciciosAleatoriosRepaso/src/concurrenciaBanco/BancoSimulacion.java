package concurrenciaBanco;

public class BancoSimulacion {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(1500);
		Cliente c = new Cliente(cuenta, "Juan");
		Cliente c1 = new Cliente(cuenta, "William");
		Cliente c2 = new Cliente(cuenta, "Añita");
		Thread cliente = new Thread(c);
		Thread cliente1 = new Thread(c1);
		Thread cliente2 = new Thread(c2);
		cliente.start();
		cliente1.start();
		cliente2.start();

		try {
			cliente.join();
			cliente1.join();
			cliente2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cuenta.imprimirHistorial();
	}
}
