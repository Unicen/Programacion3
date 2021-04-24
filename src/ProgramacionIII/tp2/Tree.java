package ProgramacionIII.tp2;

public class Tree {

	private int valor;
	private Tree izquierda;
	private Tree derecha;

	public Tree(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
	}

	public void add(int newValue) {
		if (newValue < this.valor) {
			if (this.izquierda == null)
				this.izquierda = new Tree(newValue);
			else
				this.izquierda.add(newValue);
		} else {
			if (this.derecha == null)
				this.derecha = new Tree(newValue);
			else
				this.derecha.add(newValue);
		}
	}
	
	// Complejidad O(n) donde n es la cantidad de valores del arbol
	public int getHeight() {
		if (this.izquierda == null && this.derecha == null) { // Si soy una hoja
			return 0; // Soy chato, tengo altura 0
		} else {
			// Si tengo al menos un hijo			
			int alturaIzq = 0;
			int alturaDer = 0;
			
			if (this.izquierda != null)
				alturaIzq = 1 + this.izquierda.getHeight(); 
			
			if (this.derecha != null)
				alturaDer = 1 + this.derecha.getHeight();
			
			int mayor = Math.max(alturaIzq, alturaDer);
			
			return mayor;			
		}
	}
		
}