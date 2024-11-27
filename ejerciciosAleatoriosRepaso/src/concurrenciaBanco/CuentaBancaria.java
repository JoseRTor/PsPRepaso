package concurrenciaBanco;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
	private Integer saldo;
	private List<String> registroTransacciones;

	public CuentaBancaria(Integer saldo) {
		registroTransacciones = new ArrayList<String>();
		this.saldo = saldo;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public synchronized Boolean retirarDinero(int cant, String nombreCliente) {

		if (cant > saldo) {
			System.out.println("No ha sido posible retirar el dinero");
			return false;
		} else {
			saldo = saldo - cant;
			System.out.println(getSaldo());
			String transaccion = nombreCliente + " ha retirado " + cant + ". Quedan" + getSaldo();
			registrarTransaccion(transaccion);
			return true;
		}
	}

	private void registrarTransaccion(String trans) {
		registroTransacciones.add(trans);
	}

	public void imprimirHistorial() {
		for (String string : registroTransacciones) {
			System.out.println(string);
		}
	}

}
