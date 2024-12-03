package paquete_4_no_concurrente;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario implements Runnable {
    private String nombre;
    private Archivo archivo;
    private DescargaLog descargaLog;
    private static Long nextIdDescarga = 0L; // Contador compartido para IDs de descarga


    public Usuario(String nombre, Archivo archivo, DescargaLog descargaLog) {
        this.nombre = nombre;
        this.archivo = archivo;
        this.descargaLog = descargaLog;
    }

    @Override
    public void run() {

    	Random random = new Random();
    	descargarFragmento(random.nextInt(50,101));
		pausar();
    	}
    	
    	
        // Implementa la lógica para descargar el archivo en fragmentos
    

    public  void descargarFragmento(int fragmento) {
    		nextIdDescarga++;
    		descargaLog.registrarDescarga(nombre + " descargó fragmento de " + fragmento + " MB de " + archivo.getNombre() + " id -> " + nextIdDescarga);
    		pausar();
    	
        // Registra el fragmento descargado en el log
    }

    public void pausar() {
    	Random random = new Random();
    	try {
			Thread.sleep(random.nextInt(200, 401));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Simula una pausa aleatoria entre fragmentos
    }
}
