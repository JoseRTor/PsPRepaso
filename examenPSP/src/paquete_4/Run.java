package paquete_4;


public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();

        for (int i = 0; i < 10; i++) {
        	Usuario u = new Usuario("usuario" + i, logMensajes);
        	Thread t1 = new Thread(u);
        	t1.start();

		}
        
        	
        // Crear y lanzar 10 usuarios como hilos

        
        // Esperar hasta fin de todos los hilos


        // Imprimir todos los mensajes registrados
        
    }
}

