package ProgramacionIII.tp1;

public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> last;

	public Node() {
		this.info = null;
		this.next = null;
		this.last = null; //no es necesario
	}
	
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
		//this.setLast(last); //no es necesario
	}
	
	public Node<T> getNext() {
		return this.next;
	}

	//no es necesario
	public Node<T> getLast() {
		return this.last;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
