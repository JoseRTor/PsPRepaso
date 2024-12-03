package paquete_4_con_concurrencia;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario implements Runnable {
    private String nombre;
    private Archivo archivo;
    private DescargaLog descargaLog;
    private static Long nextIdDownload = 0L; // Contador compartido para IDs de descarga
    private static AtomicInteger nextIdDescarga = new AtomicInteger(0); // Contador compartido para IDs de descarga


    public Usuario(String nombre, Archivo archivo, DescargaLog descargaLog) {
        this.nombre = nombre;
        this.archivo = archivo;
        this.descargaLog = descargaLog;
    }

    @Override
    public void run() {
    	//Esto es porque entendí al principio que no deberían descargar por encima del valor del archivo
    	//Si todos se están descargando el archivo a la vez, el peso debería disminuir
    	//Aquí se me ha ido un poco

    	Random random = new Random();
    	descargarFragmento(random.nextInt(50,101));
		pausar();
    	}
    	
    	
        // Implementa la lógica para descargar el archivo en fragmentos
    

    public synchronized void descargarFragmento(int fragmento) {
    		AtomicInteger resultado = new AtomicInteger(nextIdDescarga.incrementAndGet());
    		descargaLog.registrarDescarga(nombre + " descargó fragmento de " + fragmento + " MB de " + archivo.getNombre() + " id -> " + resultado);
    		nextIdDownload = nextIdDownload + fragmento;
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
