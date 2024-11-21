package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
	private Integer saldo;
	private List<String> registroTransacciones;

	public CuentaBancaria(Integer saldoInicial) {
		this.saldo = saldoInicial;
		registroTransacciones = new ArrayList<String>();

	}

	public synchronized Boolean retirarDinero(Integer cantidad, String nombreCliente) {

		if (saldo >= cantidad) {
			saldo = saldo - cantidad;
			registroTransacciones.add(nombreCliente + " : " + cantidad);
			return true;
		}
		return false;

	}

	public void registrarTransacción(String transaccion) {
		registroTransacciones.add(transaccion);

	}

	public void imprimirHistorialTransacciones() {
		for (String transacciones : registroTransacciones) {
			System.out.println(transacciones);
		}
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public List<String> getRegistroTransacciones() {
		return registroTransacciones;
	}

	public void setRegistroTransacciones(List<String> registroTransacciones) {
		this.registroTransacciones = registroTransacciones;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [saldo=" + saldo + ", registroTransacciones=" + registroTransacciones + "]";
	}

}
