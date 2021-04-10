package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {

	private Node cursor;
	
	public MyIterator(Node first) {
		this.cursor = first;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public Integer next() {
		Integer info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}
	
	/* Metodos adicionales que podemos agregar si queremos */
	
	public Integer get() {
		return this.cursor.getInfo();
	}
	
	public void move() {
		this.cursor = this.cursor.getNext();
	}

}
