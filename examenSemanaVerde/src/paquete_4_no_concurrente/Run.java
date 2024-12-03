package paquete_4_no_concurrente;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        List<Archivo> archivos = new ArrayList<>();
        List<Thread> hilos = new ArrayList<Thread>();
        archivos.add(new Archivo("Archivo1", 5000)); // 500 MB
        archivos.add(new Archivo("Archivo2", 750)); // 750 MB
        archivos.add(new Archivo("Archivo3", 10000)); // 1000 MB
        
        //Esto es con problemas de concurrencia
        // Se está descargando más de la capacidad real del archivo

        
        DescargaLog descargaLog = new DescargaLog();
        for (int i = 0; i < 10000; i++) {
			Thread t = new Thread (new Usuario ("Usuario" + i, archivos.get(0), descargaLog));
			hilos.add(t);
			t.start();
		}
        for (Thread thread : hilos) {
			thread.join();
		}
        descargaLog.imprimirDescargas();

//		  Creación de cinco usuarios
//        hilos.removeAll(hilos);
        
//        Usuario usuario1 = new Usuario("Juan", archivos.get(0), descargaLog);
//        Usuario usuario2 = new Usuario("Jose", archivos.get(0), descargaLog);
//        Usuario usuario3 = new Usuario("Ana", archivos.get(0), descargaLog);
//        Usuario usuario4 = new Usuario("Filberto", archivos.get(0), descargaLog);
//        Usuario usuario5 = new Usuario("Anastasia", archivos.get(0), descargaLog);
//        hilos.add(new  Thread (usuario1));
//        hilos.add(new  Thread (usuario2));
//        hilos.add(new  Thread (usuario3));
//        hilos.add(new  Thread (usuario4));
//        hilos.add(new  Thread (usuario5));
//        for (Thread thread : hilos) {
//        thread.start();
//        }
//        for (Thread thread : hilos) {
//			thread.join();
//		}
//        descargaLog.imprimirDescargas();
        // Crear y lanzar usuarios para descargar los archivos

        // Esperar a que todas las descargas terminen

        // Imprimir el registro de descargas
    }
}
