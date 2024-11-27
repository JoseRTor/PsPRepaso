package ejercicioConcurrenciaConcierto;

public class Usuario implements Runnable{
	private SistemaReserva s;
	private String nombreUser;
	private String nombreEvento;
	private int cantidadEntradas;
	
	
	
	public Usuario(SistemaReserva s, String nombreUser, String nombreEvento, int cantidadEntradas) {
		super();
		this.s = s;
		this.nombreUser = nombreUser;
		this.nombreEvento = nombreEvento;
		this.cantidadEntradas = cantidadEntradas;
	}



	@Override
	public void run() {
		boolean reserva = s.reveservar(nombreEvento, cantidadEntradas);
		if (reserva) {
			System.err.println("Se ha reservado con éxito pero lo imprimo en rojo");
		}else {
			System.out.println("eres un notas");
		}
	}
	
	

}
