package tpe;

import tpe.utils.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	HashMap<String,Tarea> tareasCriticas = new HashMap<>();
	HashMap<String,Tarea> tareasNoCriticas = new HashMap<>();

	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		ArrayList<Procesador> procesadores = reader.readProcessors(pathProcesadores);
		ArrayList<Tarea> tareas= reader.readTasks(pathTareas);
		for (Tarea tarea : tareas) {
			if(tarea.getEsCritica()){
				tareasCriticas.put(tarea.getId(),tarea);
			}else{
				tareasNoCriticas.put(tarea.getId(),tarea);
			}
		}
		for (Procesador procesador : procesadores) {
			// Aca deberia guardar los procesadores en una estructura de datos
		}
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
     */
	public Tarea servicio1(String ID) {
		if(tareasCriticas.containsKey(ID)){
			return tareasCriticas.get(ID);
		}else{
			return tareasNoCriticas.get(ID);
		}
	}
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     */
	public List<Tarea> servicio2(boolean esCritica) {
		if(esCritica){
			return new ArrayList<>(tareasCriticas.values());
		}else{
			return new ArrayList<>(tareasNoCriticas.values());
		}
	}

    /*
     * Expresar la complejidad temporal del servicio 3.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		List<Tarea> tareas = new ArrayList<>();
		for (Tarea tarea : tareasCriticas.values()) {
			if(tarea.getNivelPrioridad()>=prioridadInferior && tarea.getNivelPrioridad()<=prioridadSuperior){
				tareas.add(tarea);
			}
		}
		for (Tarea tarea : tareasNoCriticas.values()) {
			if(tarea.getNivelPrioridad()>=prioridadInferior && tarea.getNivelPrioridad()<=prioridadSuperior){
				tareas.add(tarea);
			}
		}
		return tareas;
	}
	public void printTareas(){

		for (Tarea tarea : tareasCriticas.values()) {
			System.out.println(tarea.toString());
		}
		for (Tarea tarea : tareasNoCriticas.values()) {
			System.out.println(tarea.toString());
		}
	}
}
/* public void sumarTiempoFinal(Integer tiempoTarea){
		var tiempoFinalActual = getTiempoFinalEjecucion();
		setTiempoFinalEjecucion(tiempoFinalActual+tiempoTarea);
		}
          this.sumarTiempoFinal(t.getTiempoEjecucion());*/