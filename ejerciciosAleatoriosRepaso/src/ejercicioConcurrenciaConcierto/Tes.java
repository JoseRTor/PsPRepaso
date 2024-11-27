package ejercicioConcurrenciaConcierto;

public class Tes {
public static void main(String[] args) {
	SistemaReserva s = new SistemaReserva();
	s.agregarEvento("Concierto Juanes", 220);
	s.agregarEvento("Concierto William y la Banda", 1100);
	s.agregarEvento("Concierto Ozuna", 20000);
	
	for (int i = 0; i < 10; i++) {
		new Thread(new Usuario(s ,"Anita", "Concierto William y la Banda",50 )).start();
		new Thread(new Usuario(s ,"Pepe", "Concierto William y la Banda",150 )).start();
		new Thread(new Usuario(s ,"Juan", "Concierto William y la Banda",150 )).start();
		new Thread(new Usuario(s ,"Andrea", "Concierto William y la Banda",650 )).start();
		new Thread(new Usuario(s ,"Andrea", "Concierto William y la Banda",650 )).start();
		new Thread(new Usuario(s ,"Andrea", "Concierto William y la Banda",650 )).start();
	}

}
}
