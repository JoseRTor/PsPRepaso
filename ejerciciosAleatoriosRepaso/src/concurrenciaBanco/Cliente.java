package concurrenciaBanco;

public class Cliente implements Runnable{
	private CuentaBancaria cuenta;
	private String nombreCliente;
	
	
	
	public Cliente(CuentaBancaria cuenta, String nombreCliente) {
		super();
		this.cuenta = cuenta;
		this.nombreCliente = nombreCliente;
	}



	@Override
	public void run() {
		while(true) {
			int cantidadRetiro = (int) (Math.random() * 150 + 50);
			if(!cuenta.retirarDinero(cantidadRetiro, nombreCliente)) {
				break;
			}
			
			try {
				Thread.sleep( (int) (Math.random() *1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
