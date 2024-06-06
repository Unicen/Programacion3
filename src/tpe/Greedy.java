package ProgramacionIII.tpe;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
    private List<Tarea> tareas;
    private List<Procesador> procesadores;
    private Integer resulTiempoFinalEjecucion;
    private Integer estadosGenerados;


    public Greedy(List<Tarea> tareas, List<Procesador> procesadores) {
        this.tareas = new ArrayList<>(tareas);
        this.procesadores = new ArrayList<>(procesadores);
        this.estadosGenerados = 0;
        this.resulTiempoFinalEjecucion = 0;
    }

    private Procesador obtenerProcesadorOptimo(Tarea tarea) {
        int mejorTiempo = Integer.MAX_VALUE;
        Procesador pOptimo = null;
        for (Procesador procesador: this.procesadores) {
            this.estadosGenerados++;
            if(procesador.puedeAgregarTarea(tarea) && procesador.getTiempoEjecucion() < mejorTiempo){
                pOptimo = procesador;
                mejorTiempo = procesador.getTiempoEjecucion();
            }
        }
        return pOptimo;
    }

    public Solucion ejecutarGreedy() {
        while ( !this.tareas.isEmpty()) {
            Tarea tareaAsignar = this.tareas.get(0);
            Procesador procesador = this.obtenerProcesadorOptimo(tareaAsignar);
            if (procesador != null) {
                this.resulTiempoFinalEjecucion += tareaAsignar.getTiempoEjecucion();
                procesador.addTarea(tareaAsignar);
                this.tareas.remove(tareaAsignar);
            } else {
                return null;
            }
        }
        return new Solucion(this.procesadores, this.resulTiempoFinalEjecucion, this.estadosGenerados);
    }
}


