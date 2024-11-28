package reservaEntradas;

public class Evento {
	private String nombre;
	private Integer entradas;
	public Evento(String nombre, Integer entradas) {
		this.nombre = nombre;
		this.entradas = entradas;
	}
	
	
	public Integer getEntradas() {
		return entradas;
	}
	
	


	public String getNombre() {
		return nombre;
	}


	public synchronized Boolean reservarEntradas(Integer cantidadAReservar) {
		if (entradas >= cantidadAReservar) {
			System.out.println("Se ha realizado la reserva con éxito");
			entradas = entradas - cantidadAReservar;
			System.out.println("Quedan " + entradas + " disponibles.");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			System.out.println("No se ha podido realizar la reserva de " + cantidadAReservar);
			System.out.println("Quedan " + entradas);
			return false;
		}
		
	}
	
}
