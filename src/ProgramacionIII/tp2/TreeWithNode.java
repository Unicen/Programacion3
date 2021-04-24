package ProgramacionIII.tp2;

public class TreeWithNode {

	private TreeNode raiz;
	
	public TreeWithNode() {
		this.raiz = null;
	}
	
	public void add(int value) {
		if (this.raiz == null)
			this.raiz = new TreeNode(value);
		else
			this.add(this.raiz,value);
	}
	
	// O(h) donde h es la altura del arbol (la longitud de la rama mas larga)
	private void add(TreeNode actual, int valor) {
		if (actual.getValor() > valor) {
			
			if (actual.getIzq() == null) { 
				TreeNode temp = new TreeNode(valor);
				actual.setIzq(temp);
			} else {
				add(actual.getIzq(),valor);
			}
			
		} else {
			
			if (actual.getDer() == null) { 
				TreeNode temp = new TreeNode(valor);
				actual.setRight(temp);
			} else {
				add(actual.getDer(),valor);
			}
			
		}
	}
	
	// O(n) donde n es la cantidad de nodos del arbol
	public int getHeight() {
		if (this.raiz == null)
			return 0;
		else
			return this.getHeight(this.raiz); // O(n)
	}
	
	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	private int getHeight(TreeNode cursor) {
		
		if (cursor.getIzq() == null && cursor.getDer() == null) { // Si es una hoja
			return 0; // Soy chato, tengo altura 0
		} else {
			// Si tengo al menos un hijo
			
			int alturaIzq = 0;
			int alturaDer = 0;
			
			if (cursor.getIzq() != null)
				alturaIzq = 1 + this.getHeight(cursor.getIzq()); 
			
			if (cursor.getDer() != null)
				alturaDer = 1 + this.getHeight(cursor.getDer());
			
			int mayor = Math.max(alturaIzq, alturaDer);
			
			return mayor;	
		}
		
	}

}