package paquete_1_5;

public class Test {
	public static void main(String[] args) {
		CompetitionSimulator c = new CompetitionSimulator("Competición Liga Escolar", 5);
		System.out.println(c);
		c.simulaRondas(500);
		
//		TCompetitionSimulator t = new TCompetitionSimulator("Liga Universitaria", 7);
//		System.out.println(t);
//		t.start();
//		
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		RCompetitionSimulator r = new RCompetitionSimulator("Toreno Profesional" , 10);
//		System.out.println(r);
//		new Thread (r).start();
		
		LCompetitionSimulator l = new LCompetitionSimulator();
		l.lanzarCompeticion();
		
	}
}
