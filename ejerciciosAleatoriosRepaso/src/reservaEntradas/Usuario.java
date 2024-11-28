package reservaEntradas;

public class Usuario implements Runnable{
	private SistemaReserva r;
	private String nombreUsuario;
	private String nombreEvento;
	private Integer cantidadEntradas;

	public Usuario(SistemaReserva r, String nombreUsuario, String nombreEvento, Integer cantidadEntradas) {
		super();
		this.r = r;
		this.nombreUsuario = nombreUsuario;
		this.nombreEvento = nombreEvento;
		this.cantidadEntradas = cantidadEntradas;
	}



	@Override
	public void run() {
		r.reservar(nombreEvento, cantidadEntradas);
	}

}
