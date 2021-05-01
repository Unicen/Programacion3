package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	
	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	private int tiempo;	
	private HashMap<Integer,Integer> descubrimiento;
	private HashMap<Integer,Integer> finalizacion;

	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = new HashMap<>();
		this.finalizacion = new HashMap<>();
		this.tiempo = 0;
	}
	
	public void dfs() {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;
		
		it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			if (colores.get(verticeId).equals("blanco"))
				dfs_visit(verticeId);
		}
		
	}
	
	public void dfs_visit(int vertice) {
		
		colores.put(vertice, "amarillo");
		tiempo += 1;
		descubrimiento.put(vertice, tiempo);
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		while(it.hasNext()) {
			int adyacente = it.next();
			if (colores.get(adyacente).equals("blanco"))
				dfs_visit(adyacente);
		}
		
		colores.put(vertice, "negro");
		tiempo += 1;
		finalizacion.put(vertice, tiempo);
		
	}
	

}
