package downloadSimulator;

public class TDownload extends Thread {
	private DownloadSimulator simulador;

	public TDownload() {
		this.simulador = new DownloadSimulator();
	}

	@Override
	public void run() {
		this.simulador.growUpDown();
	}

}
