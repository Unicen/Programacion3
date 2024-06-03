package ProgramacionIII.tpe;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    private final List<Procesador> procesadores;
    private final int tiempoMaximo;
    private final int cantEstaddos;

    public Solucion(List<Procesador> procesadores, int tiempoMaximo, int cantEstaddos) {
        this.procesadores = new ArrayList<>(procesadores);
        this.tiempoMaximo = tiempoMaximo;
        this.cantEstaddos = cantEstaddos;
    }

    public List<Procesador> getProcesadores() {
        return new ArrayList<>(procesadores);
    }

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public int getCantEstaddos() {
        return cantEstaddos;
    }

    public String toString() {
        return "Solucion obtenida: " + procesadores + "\n" +
                "Tiempo maximo: " + tiempoMaximo + "\n" +
                "CantEstaddos: " + cantEstaddos + "\n";
    }
}
