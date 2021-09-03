package Tp_2;

import ProgramacionIII.tp1.MyIterator;
import ProgramacionIII.tp1.MySimpleLinkedList;

public class Main_Tp2 {

	public static void main(String[] args) {
//		------------------------------- Practico 2 ---------------------------------------------
//		Ejercicio 1.
//		Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
//		1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
		/*
		 * en el pero de los casos se hubiera tenido que recorrer todo el arreglo de
		 * rpincipio a fin
		 */
//		2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
		/*
		 * el problema que trae es la complejidad siendo que el ejercio podria
		 * reslverser con un for o while (se forzo la recursividad )
		 */
//		3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
		/* no cambia la complejidad */
		int[] arreglo = { 1, 2, 3, 4, 5, 6 };

		/* el usuario no necesita mandar ni saber como se realuiza la verificacion */
		boolean estaOrdenado = estaOrdenado(arreglo);
		System.out.println(estaOrdenado);

//		Ejercicio 2.
//		Implemente un algoritmo recursivo para buscar un elemento en una lista simple.
//		Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado
//		ascendentemente [1 2 3 …].
//		1. ¿Qué complejidad O tienen estos algoritmos?
//		2. ¿En qué afecta la estructura a estos algoritmos?
//		3. ¿Cambia algo que la estructura esté ordenada?

		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

		lista.insertFront(1);
		lista.insertFront(2);
		lista.insertFront(3);
		lista.insertFront(4);
		System.out.println(buscarElemento(lista, 0));
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(buscarElemento(arr, 0));

//		Ejercicio 3.
//		Implemente un algoritmo recursivo que convierta un número en notación decimal a su
//		equivalente en notación binaria
		
		   int n = 77;
	       dec_a_Bin(n);
	       
//	       Ejercicio 4.
//	       Implemente un algoritmo de ordenamiento por selección en un arreglo.
//	       Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
//	       1. ¿Qué complejidad O tienen estos algoritmos?

	}
	
	 public static void dec_a_Bin(int n) {
	        if (n < 2) {//el punto de corte de la recursividad se va a dar cuando n sea menor a 2 (sea 0 o 1)
	            System.out.print(n);
	        } else { // en caso contrario se llamara a la recursividad 
	            dec_a_Bin(n / 2);
	            System.out.print(n % 2);//se inprimira tambien el resultado de la division  
	        }
	    }

	/* Este metodo es la cara visible de mi funconalidad */
	public static boolean estaOrdenado(int[] arreglo) {
		/*
		 * Lo unico que hace es invocar al metodo recursivo incluyendo los parametros de
		 * inicio
		 */
		return verificarOrdenado(arreglo, arreglo.length - 1);
	}

	/* Este metdo es privado, es el encargadode realizar la recurcion */
	public static boolean verificarOrdenado(int[] arreglo, int indice) {

		if (indice == 0) {
			return true; // si el recorrido llego hasta la pocicion 0 del arreglo significa que esta
							// arreglado
		} else {
			boolean ordenado = arreglo[indice] > arreglo[indice - 1]; // verifico que en numero anterior sea menor al
																		// valor de donde se encuentra el indice
			if (ordenado) {
				ordenado = verificarOrdenado(arreglo, indice - 1);// en caso de ser verdadero recursivamente
																	// sigo preguntado
			}
			return ordenado;// en caso de un numero ser mayor se retornara falso
		}
	}

	/**
	 * Busqueda en lista O(n)
	 */
	public static boolean buscarElemento(MySimpleLinkedList<Integer> lista, int elemento) {

		return buscarElemento(lista, elemento, lista.iterator());
	}

	private static boolean buscarElemento(MySimpleLinkedList<Integer> lista, int elemento, MyIterator<Integer> it) {
		if (!it.hasNext()) {
			return false;
		}

		int value = it.getInfo();
		boolean find = value == elemento;

		while (lista.size() > 0 && !find) {
			it.next();
			return buscarElemento(lista, elemento, it);
		}

		return find;
	}

	/**
	 * Busqueda en arreglo ordenado
	 * 
	 * O(n)
	 */
	public static int buscarElemento(int[] lista, int elemento) {

		return buscarElemento(lista, elemento, 0, lista.length);
	}

	// [1, 2, 3, 4, 5, 6, 7, 8]
	//

	private static int buscarElemento(int[] lista, int elemento, int ini, int fin) {
		if (elemento < lista[ini] || elemento > lista[fin - 1]) {
			return -1;
		}
		int medio = (ini + fin) / 2;

		if (lista[medio] > elemento) {
			return buscarElemento(lista, elemento, ini, medio);
		} else if (lista[medio] < elemento) {
			return buscarElemento(lista, elemento, medio, fin);
		} else {
			return medio;
		}

	}

//	    private static boolean buscarElemento(int[] lista, int elemento, int size) {
//	        System.out.println("recursion n° " + (lista.length - size));
//	        
//	        
//	        boolean find = (lista[size] == elemento) ? true : (lista[lista.length - size + 1] == elemento);
//	        
	//
//	        while (size / 2 > 0 && !find) {
//	            return buscarElemento(lista, elemento, size - 1);
//	        }
	//
//	        return find;
//	    }
}
