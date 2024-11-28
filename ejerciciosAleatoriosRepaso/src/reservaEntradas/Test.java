package reservaEntradas;

public class Test {
	public static void main(String[] args) {
		SistemaReserva r = new SistemaReserva();
		Evento e1 = new Evento("Concierto William", 50);
		Evento e2 = new Evento ("Concierto Ozuna" , 90);
		r.agregarEvento(e1.getNombre(), e1.getEntradas());
		r.agregarEvento(e2.getNombre(), e2.getEntradas());

		new Thread (new Usuario(r, "Juan", e1.getNombre(), 5)).start();
		new Thread (new Usuario(r, "Juan", e1.getNombre(), 5)).start();
		new Thread (new Usuario(r, "Juan", e1.getNombre(), 5)).start();
		new Thread (new Usuario(r, "Juan", e1.getNombre(), 5)).start();
		new Thread (new Usuario(r, "Juan", e1.getNombre(), 5)).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(r.entradasRestantes(e1.getNombre()));
		
	}
}
