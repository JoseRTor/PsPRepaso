package prueba1;

public class CuentaAtras extends Thread {
	private int valorMaximo;
	private String nombre;
	private int valor;
	private static int milis = 300;
	
	@Override
	public void run () {
		for (this.valor = valorMaximo ; valor >= 0 ; valor--) {
			
			
			System.out.println(this.toString());
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}


	@Override
	public String toString() {
		return "CuentaAtras [valorMaximo=" + valorMaximo + ", nombre=" + nombre + ", valor=" + valor + "]";
	}


	public CuentaAtras(int valorMaximo, String nombre) {
		this.valorMaximo = valorMaximo;
		this.nombre = nombre;
		
	}	
	
	public static void main(String[] args) {
		CuentaAtras c1= new CuentaAtras(10, "J");
		CuentaAtras c2= new CuentaAtras(10, "A");
		c1.start();
		c2.start();
//		new CuentaAtras(10, "Juan Antonio").run();
//		new CuentaAtras(12, "RUTILOFILOS").run();


	}
	

	
	
	
}

