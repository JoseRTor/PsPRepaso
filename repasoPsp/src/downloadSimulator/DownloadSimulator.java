package downloadSimulator;

public class DownloadSimulator {

	public void growUpDown() {
		Integer download = 0;

		while (download <= 100) {
			System.out.println("Descarga del archivo \"JuanesBailaEnPelotaPicada.mp4\" al " + download + " %");
			download += 10;
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
