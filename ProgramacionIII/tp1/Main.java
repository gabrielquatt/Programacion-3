package ProgramacionIII.tp1;

import java.util.Iterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

		lista.insertFront(1);
		lista.insertFront(2);
		lista.insertFront(3);
		lista.insertFront(4);

		//System.out.println(lista);
		
//		Ejercicio 1.
//		Implemente los m�todos indicados del esqueleto de Lista desarrollado en Teor�a
//		(insertFront, extractFront, isEmpty, size). Agregar tambi�n el m�todo: T get(index)
		
//		Ejercicio 2.
//		Considerando la implementaci�n de la Lista realizado en el ejercicio anterior, comparar la
//		complejidad computacional contra un array en las siguientes operaciones:
//		1.- Insertar al principio.
//		2.- Buscar un elemento en una posici�n.
//		3.- Determinar la cantidad de elementos.

		
		
//		Ejercicio 3.
//		Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
//		elementos utilizando el m�todo push(T o). Para retirar elementos de la colecci�n se utiliza el
//		m�todo pop(), que retorna el �ltimo elemento agregado a la colecci�n y lo elimina de la
//		misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el m�todo top(). Por
//		�ltimo, es posible invertir el orden de los elementos de la pila mediante el m�todo reverse()
		
		Pila<Integer> p = new Pila <Integer>();
		
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		System.out.println(p);
		
		System.out.println(" ");
		System.out.println("top = " +p.top());
		System.out.println(" ");
		p.reverse();
		System.out.println(p);
		System.out.println(" ");
//		Ejercicio 4.
//		A la implementaci�n de la clase Lista realizada en el ejercicio 1, agregue un m�todo
//		indexOf, que reciba un elemento y retorne el indice donde esta almacenado ese elemento, o
//		-1 si el elemento no existe en la lista.
		
		System.out.println(lista.indexOf(1)); 
		
//		Ejercicio 5.
//		A partir de la clase Lista implementada en el ejercicio 1, implemente el patr�n
//		iterator-iterable, para que la lista sea iterable. �Existe alguna ventaja computacional a la
//		hora de recorrer la lista de principio a fin si se cuenta con un iterador?

		Iterator<Integer> it1 = lista.iterator();  //0(1)
		while(it1.hasNext()) {
			int valor = it1.next();                
			System.out.println(valor);
			
			
		}
	}
//		Ejercicio 6.
//		Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
//		suponiendo que: a) las listas est�n desordenadas y la lista resultante debe quedar
//		ordenada. b) las listas est�n ordenadas y la lista resultante debe mantenerse ordenada.
		
		
	//las listas est�n desordenadas y la lista resultante debe quedar ordenada.
	public static void ejercicio6a(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2) {
		MySimpleLinkedList<Integer> elementosComunes = new MySimpleLinkedList<Integer>();
		for (int e: lista1) {
			for (int f: lista2) {
				if (e == f) elementosComunes.insertOrderly(e);
			}
		}
		System.out.println("las listas est�n desordenadas y la lista resultante debe quedar ordenada.");
		System.out.println(elementosComunes);
	}

	//las listas est�n ordenadas y la lista resultante debe mantenerse ordenada.
	public static void ejercicio6b(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2) {
		MySimpleLinkedList<Integer> elementosComunes = new MySimpleLinkedList<Integer>();
		MyIterator<Integer> it1 = (MyIterator<Integer>) lista1.iterator();
		MyIterator<Integer> it2 = (MyIterator<Integer>) lista2.iterator();
		while (it1.hasNext() && it2.hasNext()) {
			if (it1.getInfo() > it2.getInfo()) it2.next();
			else if (it2.getInfo() > it1.getInfo()) it1.next();
			else if (it1.getInfo().equals(it2.getInfo())) {
				elementosComunes.insertLast(it1.getInfo());
				it1.next();
				it2.next();
			}
		}
		System.out.println("las listas est�n ordenadas y la lista resultante debe mantenerse ordenada.");
		System.out.println(elementosComunes);
	}
	
//	Ejercicio 7.
//	Escriba una funci�n que dadas dos listas construya otra con los elementos que est�n en la
//	primera pero no en la segunda.

	//TODO
	
//	Ejercicio 8.
//	Considerando la Implementaci�n de Lista del ejercicio 1, realice una Lista doblemente
//	vinculada.
	
	//TODO
	
//	Ejercicio 9.
//	Verificar si una cadena de texto es palindroma (capicua).
	
	//TODO
	

}
