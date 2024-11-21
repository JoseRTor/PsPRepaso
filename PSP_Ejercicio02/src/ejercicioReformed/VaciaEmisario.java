package ejercicioReformed;

public class VaciaEmisario extends Thread {

	private Emisor emitido;

	public VaciaEmisario(Emisor emitido) {
		this.emitido = emitido;
	}

	@Override
	public void run() {
		emitido.vaciar();
	}

	public static void main(String[] args) {
		Emisor nombre = new Emisor("Fran ");
		Emisor verbo = new Emisor("Para por favor ");
		new VaciaEmisario(nombre).start();
		new VaciaEmisario(verbo).start();

	}

}
