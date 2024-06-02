package ProgramacionIII.tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backtracking {
    private Integer resulTiempoFinalEjecucion;
    private List<Tarea> tareas;
    private List<Procesador> procesadores;
    private Integer estadosGenerados;
    private List<Procesador> procesadoresListos;


    public Backtracking(List<Tarea> tareas, List<Procesador> procesadores) {
        this.resulTiempoFinalEjecucion = 0;
        this.estadosGenerados = 0;
        this.tareas = tareas;
        this.procesadores = procesadores;
        this.procesadoresListos = new ArrayList<>();
    }

    public void printToResult() {
        System.out.println("Mejor tiempo:" + this.resulTiempoFinalEjecucion);
        System.out.println("Procesadores y tareas asignadas:" + this.procesadoresListos.toString());
        System.out.println("Cantidad estados:" + this.estadosGenerados);
    }

    public void iniciarBacktracking() {
        this.resulTiempoFinalEjecucion = Integer.MAX_VALUE;
        Integer posibleMejorTiempo = 0;
        this.ejecutarBacktracking(posibleMejorTiempo, new ArrayList<>(), this.procesadores);
        this.printToResult();
    }

    private void ejecutarBacktracking(Integer mejorTiempoActual, List<Tarea> tareasAsignadas, List<Procesador> procesadores) {
        this.estadosGenerados++;

        if (tareasAsignadas.size() == this.tareas.size() && mejorTiempoActual < this.resulTiempoFinalEjecucion) {
            this.resulTiempoFinalEjecucion = mejorTiempoActual;
            for (Procesador procesador : procesadores) {
                this.procesadoresListos.add(new Procesador(procesador.getId(), procesador.getCodigoProcesador(), procesador.getAnioFuncionamiento(), procesador.getRefrigerado(), procesador.getTiempoEjecucion(), procesador.getTiempoMaximo(), procesador.getTareasAsignadas()));
            }
        } else {
            if (mejorTiempoActual >= this.resulTiempoFinalEjecucion) {
                return;
            }
            for (Tarea tActual : this.tareas) {
                for (Procesador pActual : procesadores) {
                    if (!tareasAsignadas.contains(tActual)) {
                        if (pActual.puedeAgregarTarea(tActual)) {
                            pActual.addTarea(tActual);
                            tareasAsignadas.add(tActual);
                            mejorTiempoActual += tActual.getTiempoEjecucion();
                            ejecutarBacktracking(mejorTiempoActual, tareasAsignadas, procesadores);
                            mejorTiempoActual -= tActual.getTiempoEjecucion();
                            tareasAsignadas.remove(tActual);
                            pActual.removeTarea(tActual);
                        }
                    }
                }
            }
        }
    }
   /* private void ejecutarBacktracking(Integer mejorTiempoActual, List<Tarea> tareas, List<Procesador> procesadores) {
        this.estadosGenerados++;
        System.out.println(this.resulTiempoFinalEjecucion);
        List<Tarea> tareasParaAsignar = new ArrayList<>(tareas);
        Iterator<Tarea> tareasIterador = tareasParaAsignar.iterator();
        if (this.tareas.size()>0) {
            if(this.resulTiempoFinalEjecucion > mejorTiempoActual){
                this.resulTiempoFinalEjecucion = mejorTiempoActual;
            }

        } else {
            while (tareasIterador.hasNext()) {
                Tarea tActual = tareasIterador.next();
                for (Procesador pActual : procesadores) {
                    if (!tActual.isEstaAsignada() && pActual.addTarea(tActual)) {
                        tActual.setEstaAsignada(true);
                        this.sumarTiempoFinal(tActual.getTiempoEjecucion());
                        this.ejecutarBacktracking(mejorTiempoActual, tareasParaAsignar, procesadores);
                        this.sumarTiempoFinal(-tActual.getTiempoEjecucion());
                        tActual.setEstaAsignada(false);

                    }
                }
            }

        }
    }*/

}



