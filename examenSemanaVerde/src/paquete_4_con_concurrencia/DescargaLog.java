package paquete_4_con_concurrencia;

import java.util.ArrayList;
import java.util.List;

public class DescargaLog {
	private List<String> registroDescargas;

	public DescargaLog() {
		registroDescargas = new ArrayList<>();
	}

	public void registrarDescarga(String detalle) {
		registroDescargas.add(detalle);
	}

	public void imprimirDescargas() {
		System.out.println("Registro de Descargas:");
		for (String descarga : registroDescargas) {
			System.out.println("\t" + descarga);
		}
	}
}