package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCamino {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int origen;
	private int destino;

	public EncontrarCamino(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.origen = origen;
		this.destino = destino;
	}

	public ArrayList<Integer> encontrarCamino() {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}

		return encontrarCamino(this.origen);
	}

	public ArrayList<Integer> encontrarCamino(int vertice) {

		colores.put(vertice, "amarillo");

		ArrayList<Integer> resultado = new ArrayList<Integer>();
		
		if (vertice == this.destino) {
			resultado.add(vertice);
		} else {
		
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			while (it.hasNext() && !resultado.isEmpty()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					ArrayList<Integer> caminoParcial = encontrarCamino(adyacente);
					if (!caminoParcial.isEmpty()) {
						resultado.add(vertice);
						resultado.addAll(caminoParcial);
					}
				}
					
			}
	
		}
		
		colores.put(vertice, "negro");

		return resultado;
	}

}
