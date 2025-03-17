package ProgramacionIII.tp1;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	public T extractFront() {		
		// TODO
		return null;
	}

	public boolean isEmpty() {
		// TODO
		return false;
	}
	
	public T get(int index) {
		// TODO
		return null;
	}
	
	public int size() {
		// TODO
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO
		return "";
	}
	
}
