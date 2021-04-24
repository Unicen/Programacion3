package ProgramacionIII.tp2;

public class TreeNode {

	private int valor;
	private TreeNode izquierda;
	private TreeNode derecha;

	public TreeNode(int value) {
		this.valor = value;
		this.izquierda = null;
		this.derecha = null;
	}

	public TreeNode getIzq() {
		return izquierda;
	}

	public void setIzq(TreeNode left) {
		this.izquierda = left;
	}

	public TreeNode getDer() {
		return derecha;
	}

	public void setRight(TreeNode right) {
		this.derecha = right;
	}

	public int getValor() {
		return valor;
	}


}
