package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int origen;
	private int destino;

	public ExisteCamino(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.origen = origen;
		this.destino = destino;
	}

	public boolean existeCamino() {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}

		return existeCamino(this.origen);
	}

	public boolean existeCamino(int vertice) {

		colores.put(vertice, "amarillo");

		boolean resultado = false;
		
		if (vertice == this.destino) {
			resultado = true;
		} else {
		
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			while (it.hasNext() && !resultado) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					resultado = existeCamino(adyacente);
				}
			}
	
		}
		
		colores.put(vertice, "negro");

		return resultado;
	}

}
