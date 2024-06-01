package ProgramacionIII.tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backtracking {
    private Integer resulTiempoFinalEjecucion;
    private List<Tarea> tareas;
    private List<Procesador> procesadores;
    private Integer estadosGenerados;

    public Backtracking(List<Tarea> tareas, List<Procesador> procesadores) {
        this.resulTiempoFinalEjecucion = 0;
        this.estadosGenerados = 0;
        this.tareas = tareas;
        this.procesadores = procesadores;
    }
    public void printToResult(){
        System.out.println("Mejor tiempo:" + this.resulTiempoFinalEjecucion);
        System.out.println("Procesadores y tareas asignadas:" + this.procesadores.toString());
    }

    public void iniciarBacktracking() {
        Integer posibleMejorTiempo = 0;
        List<Tarea> tareasParaAsignar = new ArrayList<>(this.tareas);
        this.ejecutarBacktracking(posibleMejorTiempo, tareasParaAsignar, this.procesadores);
        this.printToResult();
    }

    private void ejecutarBacktracking(Integer mejorTiempoActual, List<Tarea> tareasParaAsignar, List<Procesador> procesadores) {
        // Verificar si se ha alcanzado una solución válida // menor tiempo y todas las tareas asignadas
       this.estadosGenerados ++;
        if(tareasParaAsignar.size() == 0){
            this.resulTiempoFinalEjecucion = Math.min(this.resulTiempoFinalEjecucion, mejorTiempoActual);
        }else{
            // Si no se ha alcanzado una solución válida, continuar con la búsqueda

            for (Procesador pActual: procesadores){
                for (Tarea tActual: tareasParaAsignar){
                    if(pActual.addTarea(tActual)){
                        tareasParaAsignar.remove(tActual);
                        this.sumarTiempoFinal(tActual.getTiempoEjecucion());
                    }else{
                        this.ejecutarBacktracking(mejorTiempoActual,tareasParaAsignar,procesadores);
                    }
                }
            }
          /*  while (procesadores.iterator().hasNext()){
                Procesador pActual = procesadores.next();
                if(!this.procesadoresYaRecorridos.contains(pActual)){
                    this.procesadoresYaRecorridos.add(pActual);
                    if(tareasParaAsignar.hasNext()){
                        Tarea tActual = tareasParaAsignar.next();
                        if(pActual.addTarea(tActual)){
                            tareasParaAsignar.remove();
                            this.sumarTiempoFinal(tActual.getTiempoEjecucion());
                        }else{
                            this.ejecutarBacktracking(posibleMejorTiempo,tareasParaAsignar,procesadores);
                        }
                    }
                }
            }*/
        }



        // Iterar sobre todas las posibles opciones
        //   Realizar una acción
        //   Llamar recursivamente a backtracking con los nuevos parámetros
        //   Deshacer la acción (si es necesario)





    }
    //  this.sumarTiempoFinal(t.getTiempoEjecucion());

     public void sumarTiempoFinal(Integer tiempoTarea) {
         this.resulTiempoFinalEjecucion += tiempoTarea;
     }

}



