package paquete_4.paquete2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class LogMensajes {

    private List<AtomicLong> colaMensajes;

    public LogMensajes() {
        colaMensajes = new CopyOnWriteArrayList<>();
    }

    public void registrarMensaje(AtomicLong idMensaje) {
        colaMensajes.add(idMensaje);
    }

    public void imprimirColaMensajes() {
        //
        System.out.println("Cola de mensajes enviados:");
        for (AtomicLong idMensaje : colaMensajes) {
            System.out.println("\tMensaje ID: " + idMensaje);
        }
    }
}