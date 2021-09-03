package ProgramacionIII.tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertLast(T info) {
		Node<T> tmp = this.first;
		if (tmp != null) {
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			Node<T> newNode = new Node<>(info, null);
			tmp.setNext(newNode);
		} else this.insertFront(info);
		this.size++;
	}

	// inserta un nodo en la lista en primer lugar
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}

	// extrae y elimina el primer elemento de la lista
	public T extractFront() {
		T info = null;
		if (this.first != null) {
			info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
		}
		return info;
	}

	public T extractLast() {  // menos eficiente que scioli atajando 
		int cont = 0;
		T info = null;
		Node<T> tmp = this.first;
		Node<T> last = null;

		if (size == 0) {
			return null;
		} else if (size == 1) {
			info = tmp.getInfo();
			this.first = null;
		} else {
			while (cont < this.size - 1) {
				last = tmp;
				tmp = tmp.getNext();
				cont++;
			}
			info = tmp.getInfo();
			last.setNext(null);
		}
		this.size--;
		return info;
	}

	public int indexOf(T info) {
		int num = -1;
		int cont = 0;
		Node<T> aux = this.first;
		while (cont < size) {
			if (aux.getInfo().equals(info)) {
				num = cont;
				cont = size++;
			}
			aux = aux.getNext();
			cont++;
		}
		return num;
	}

	public T getFirstInfo() {
		if (!this.isEmpty()) {
			return this.first.getInfo();
		}
		return null;
	}

	// verifica si la informacion no este vacia
	public boolean isEmpty() {
		if (this.first == null)
			return true;
		else
			return false;
	}

	// retorna la informacion segun el index dado
	public T get(int index) {

//		if(index > this.size) {
//			return null;
//		}
		if (index < 0 || this.isEmpty() || index > size) {
			return null;
		}
		int i = 0;
		Node<T> aux = this.first;
		/**
		 * while (i < index) { // aux = aux.getNext(); // contador++; }
		 */
		while (aux != null) {
			if (i == index) {
				return aux.getInfo();
			}
			aux = aux.getNext();
			i++;
		}
		return null;
	}

	// retorna la cantidad de nodos vinculados de la lista (tamaño)
	public int size() {
		// O(n) donde n es el tamaño de la lista
		/**
		 * Integer _size = 0; Node<T> cursor = this.first; while(cursor != null) {
		 * _size++; cursor = cursor.getNext(); } return _size;
		 */
		return this.size;
		// O(1) agrega complejidad de programacion pero quita complejidad computacional
	}
	
	public void insertOrderly(T info) {
		Node<T> newNode = new Node<>(info, null);
		Node<T> tmp = this.first;
		if (tmp != null && (int) tmp.getInfo() < (int) info) {
			if (tmp.getNext() != null) {
				Node<T> next = tmp.getNext();
				while (next.getNext() != null && (int) next.getInfo() < (int) info) {
					tmp = next;
					next = next.getNext();
				}
				if (next.getNext() != null) newNode.setNext(next);
				else insertLast(info);
			}
		}
		else this.insertFront(info);
		this.size++;
	}

	@Override // by Facu el chimi Arana
	public String toString() {

		if (this.size == 0) {
			return "empty";
		}
		String info = "[" + this.first.getInfo();
		Node aux = this.first.getNext();
		while (aux != null) {
			info += ", " + aux.getInfo();
			aux = aux.getNext();
		}
		return info + "]";
	}

	@Override
	public MyIterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}	

}
