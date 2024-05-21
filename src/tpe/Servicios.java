package ProgramacionIII.tpe;

import ProgramacionIII.tpe.utils.CSVReader;
import tpe.Tarea;

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
	public Tarea servicio1(String ID) {	}
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     */
	public List<Tarea> servicio2(boolean esCritica) {}

    /*
     * Expresar la complejidad temporal del servicio 3.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {}

}
