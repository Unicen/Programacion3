package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCaminos {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int origen;
	private int destino;

	public EncontrarCaminos(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.origen = origen;
		this.destino = destino;
	}

	public ArrayList<ArrayList<Integer>> encontrarCaminos() {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}

		return encontrarCaminos(this.origen);
	}

	public ArrayList<ArrayList<Integer>> encontrarCaminos(int vertice) {

		colores.put(vertice, "amarillo");

		ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
		
		if (vertice == this.destino) {
			ArrayList<Integer> unicoCamino = new ArrayList<>();
			unicoCamino.add(vertice);
			resultado.add(unicoCamino);
		} else {
		
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					ArrayList<ArrayList<Integer>> caminosParciales = encontrarCaminos(adyacente);
					
					for (ArrayList<Integer> caminoParcial: caminosParciales) {
						ArrayList<Integer> caminoCompleto = new ArrayList<>();
						caminoCompleto.add(vertice);
						caminoCompleto.addAll(caminoParcial);
						resultado.add(caminoCompleto);
					}

				}
					
			}
	
		}
		
		colores.put(vertice, "blanco");

		return resultado;
	}

}
