package downloadSimulator;

public class RDownload implements Runnable {
	private DownloadSimulator prueba;

	public RDownload() {
		this.prueba = new DownloadSimulator();
	}

	@Override
	public void run() {
		this.prueba.growUpDown();
	}

}
