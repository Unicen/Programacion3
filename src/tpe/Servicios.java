package ProgramacionIII.tpe;

import ProgramacionIII.tpe.utils.CSVReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.util.List;
import java.util.stream.Collectors;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	HashMap<String,Tarea> tareasCriticas = new HashMap<>();
	HashMap<String,Tarea> tareasNoCriticas = new HashMap<>();
	List<Procesador> procesadores = new ArrayList<>();


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
		this.procesadores.addAll(procesadores);
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

	public void asginarTareasConBacktracking(Integer maxTiempoNoRefrigerados){
		this.procesadores.stream().filter(p -> !p.getRefrigerado()).collect(Collectors.toList()).forEach(p -> p.setTiempoMaximo(maxTiempoNoRefrigerados));
		List<Tarea> tareasAsignar = new ArrayList<>();
		tareasAsignar.addAll(this.tareasCriticas.values());
		tareasAsignar.addAll(this.tareasNoCriticas.values());
		tareasAsignar.sort(comparadorPrioridad);
		Backtracking backtracking = new Backtracking(tareasAsignar,this.procesadores);
		backtracking.iniciarBacktracking();
		System.out.println(tareasAsignar);
	}

	Comparator<Tarea> comparadorPrioridad = new Comparator<Tarea>() {
		@Override
		public int compare(Tarea tarea1, Tarea tarea2) {
			// Si las tareas son críticas, poner la crítica primero
			if (tarea1.getEsCritica() && !tarea2.getEsCritica()) {
				return -1;
			} else if (!tarea1.getEsCritica() && tarea2.getEsCritica()) {
				return 1;
			}
			// Si ambas tareas son críticas o no críticas, ordenar por prioridad de menor a mayor
			return Integer.compare(tarea1.getNivelPrioridad(),tarea2.getNivelPrioridad());
		}
	};

	public void printProcesadores(){
		System.out.println(this.procesadores.toString());
	}
}