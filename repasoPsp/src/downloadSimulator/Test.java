package downloadSimulator;

public class Test {
	public static void main(String[] args) {
		TDownload uno = new TDownload();
		uno.start();
		LDownload dos = new LDownload();
		dos.iniciador();
		new Thread (new RDownload()).start();
		
	}

}
