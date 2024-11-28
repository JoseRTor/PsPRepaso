package concurrenciaCajeros;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
	private int saldo;
	private List<String> registroTrans = new ArrayList<String>();
	public CuentaBancaria(int saldo) {
		this.saldo = saldo;
	}
	
	public int getSaldo() {
		return saldo;
	}



	public synchronized Boolean retirarDinero(int cantidad, String nombreCliente) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cantidad <= saldo) {
			System.out.println("La operación ha sido realizada con éxito");
			saldo = saldo - cantidad;
			String transaccion = "Se ha realizado una sacadita de money de " + cantidad + " saldo restante " + saldo;
			registrarTransaccion(transaccion);
			return true;
		}else {
			System.out.println("NO SA PODIO");
			return false;
		}
	}
	
	private void registrarTransaccion(String trans) {
		registroTrans.add(trans);
	}
	public void imprimir() {
		for (String string : registroTrans) {
			System.out.println(string);
		}
	}
	
	

}
