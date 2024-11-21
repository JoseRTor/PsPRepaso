package ejercicio;

public class Main {

	public static void main(String[] args) {
		
		CuentaBancaria personal= new CuentaBancaria(900);
		Cliente jose = new Cliente(personal, "Jose");
		Cliente juan = new Cliente (personal, "Pepita");
		while (jose.getCuenta().getSaldo() > 0) {
		new Thread(jose).start();
		new Thread(juan).start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
	}

}
