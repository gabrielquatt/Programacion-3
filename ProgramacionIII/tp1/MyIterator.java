package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{

	private Node<T> cursor;

	public MyIterator(Node<T> firstDeLaLista) {
		this.cursor = firstDeLaLista;
	}
	
	public T getInfo() {
		return this.cursor.getInfo();
	}
	
	
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}

}
