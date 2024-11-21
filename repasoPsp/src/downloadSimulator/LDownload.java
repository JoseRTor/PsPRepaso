package downloadSimulator;

public class LDownload {

	public void iniciador() {
		Runnable iniciar = new Runnable() {

			@Override
			public void run() {
				DownloadSimulator prueba = new DownloadSimulator();
				prueba.growUpDown();

			}
		};

		new Thread(iniciar).start();

	}
}
