package ejersisio5;

public class Test {
    public static void main(String[] args) {
        SistemaReserva sistemaReserva = new SistemaReserva();

        sistemaReserva.agregarEvento("Concierto Rock", 10);
        sistemaReserva.agregarEvento("Concierto Jazz", 5);

        Thread usuario1 = new Thread(new Usuario(sistemaReserva, "Usuario1", "Concierto Rock", 4));
        Thread usuario2 = new Thread(new Usuario(sistemaReserva, "Usuario2", "Concierto Rock", 6));
        Thread usuario3 = new Thread(new Usuario(sistemaReserva, "Usuario3", "Concierto Rock", 3));
        Thread usuario4 = new Thread(new Usuario(sistemaReserva, "Usuario4", "Concierto Jazz", 2));
        Thread usuario5 = new Thread(new Usuario(sistemaReserva, "Usuario5", "Concierto Jazz", 4));

        usuario1.start();
        usuario2.start();
        usuario3.start();
        usuario4.start();
        usuario5.start();

        try {
            usuario1.join();
            usuario2.join();
            usuario3.join();
            usuario4.join();
            usuario5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Entradas restantes para Concierto Rock: " + sistemaReserva.entradasRestantes("Concierto Rock"));
        System.out.println("Entradas restantes para Concierto Jazz: " + sistemaReserva.entradasRestantes("Concierto Jazz"));
    }
}
