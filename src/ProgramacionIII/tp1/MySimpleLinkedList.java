package ProgramacionIII.tp1;

public class MySimpleLinkedList {
	
	private Node first;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(Integer o) {
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	public Integer extractFront() {		
		// TODO
		return null;
	}

	public boolean isEmpty() {
		// TODO
		return false;
	}
	
	public Integer get(int index) {
		// TODO
		return null;
	}
	
	public int size() {
		// TODO
		return 0;
	}
	
	public void print(int n) {
		// TODO
	}
	
}
