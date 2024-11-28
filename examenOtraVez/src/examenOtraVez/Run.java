package examenOtraVez;

public class Run {
	public static void main(String[] args) {
		SorteoSimulator s = new SorteoSimulator("Sorteo bonoloto española", 1, 49, 5);
		System.out.println(s);
		s.generaUnaCombinacion(200);
		
		System.out.println();
		
		TSorteoSimulator ts = new TSorteoSimulator("Sorteo bonoloto italiana", 1, 90, 6);
		System.out.println(ts);
		ts.start();
		
		try {
			ts.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		LSorteoSimulator ls = new LSorteoSimulator();
		ls.bonolotoAlemana();
	}
	
	
	
			
}
