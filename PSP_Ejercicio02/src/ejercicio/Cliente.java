package ejercicio;

public class Cliente implements Runnable {

	private CuentaBancaria cuenta;
	private String nombreCliente;

	public Cliente(CuentaBancaria cuenta, String nombreCliente) {
		this.cuenta = cuenta;
		this.nombreCliente = nombreCliente;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Override
	public void run() {
		if (!cuenta.retirarDinero(50, nombreCliente)) {
			System.out.println("La transacción no ha podido llevarse a cabo");
			return;
		}
		
		System.out.println(
				"El cliente " + nombreCliente + " ha sacado " + "50 lereles y en la cuenta hay " + cuenta.getSaldo());
	}

	@Override
	public String toString() {
		return "Cliente [cuenta=" + cuenta + ", nombreCliente=" + nombreCliente + "]";
	}

}
