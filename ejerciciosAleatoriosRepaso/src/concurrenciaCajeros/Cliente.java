package concurrenciaCajeros;

public class Cliente implements Runnable{
	private CuentaBancaria c;
	private String nombreC;
	public Cliente(CuentaBancaria c, String nombreC) {
		super();
		this.c = c;
		this.nombreC = nombreC;
	}
	@Override
	public void run() {
		while(true) {
			if(c.retirarDinero(150, nombreC)){
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				break;
			}


		}
	}
	
	
	
	
}
