package ProgramacionIII.tp1;

public class Pila<T> {

	private MySimpleLinkedList<T> lista; 

	
	public Pila() {
		this.lista = new MySimpleLinkedList<T>();
	}
	
	// insertFront -> push(): 
	public void push(T info) {
		this.lista.insertFront(info);;
	}
	
	// remove() -> pop(): 
	public T pop() {
		return this.lista.extractFront();
	}

	// devolver ultimo valor() -> top(): 
		public T top() {
			return this.lista.getFirstInfo();
		}
  
		public void reverse() {
			MySimpleLinkedList<T> listAux = new MySimpleLinkedList<>();
			while(!this.lista.isEmpty()) {
				listAux.insertFront(this.lista.extractFront());
			}
			this.lista = listAux;
		}

		@Override
		public String toString() {
			return "Pila [lista=" + lista + "]";
		}
		
		
}


