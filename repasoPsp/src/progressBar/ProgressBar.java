package progressBar;

public class ProgressBar {

	public void cargaBarra() {
		Integer barra = 0;
		while (barra <= 100) {

			System.out.println(barra + " %");

			barra = barra + 10;

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
