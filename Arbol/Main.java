package Arbol;

public class Main {

	public static void main(String[] arg) {
		// Se construye el árbol de ejemplo utilizando el constructor previamente
		// mencionado
		int[] valoresIniciales = new int[] { 8, 4, 12, 2, 1, 3, 7, 11, 25, 9 };

		// ------------------------------------------------------------------------//
		// Agregar Nodos al Arbol
		Tree miArbol = new Tree(valoresIniciales);

		// ------------------------------------------------------------------------//
		// miArbol.printPreOrder();
		// miArbol.printPosOrder();
		// miArbol.printInOrder();

		// ------------------------------------------------------------------------//
		// Eliminar Nodo Del Arbol
		// System.out.println(miArbol.delete(25));

		// ------------------------------------------------------------------------//
		// Retorna un boolean que responde si se encuentra el valor dado dentro del
		// arbol
		// System.out.println(miArbol.hasElem(8));

		// ------------------------------------------------------------------------//
		// Retorna a Altura del Arbol
		// System.out.println("La alturra del arbol es: " + miArbol.getHeight());

		// Obtener el Nodo con Mayor o Menor Valor en el Arbol
		// System.out.println("El Elemento de Mayor Valor: "+ miArbol.getMaxElement() );
		// System.out.println("El Elemento de Menor Valor: "+ miArbol.getMinElement() );

		// ------------------------------------------------------------------------//
		// Obtener una lista con los elementos de la rama más larga
		// System.out.println( miArbol.getLongestBranch());

		// ------------------------------------------------------------------------//
		// Obtener un listado de los elementos que son hojas
		// System.out.println("lista de hojas " + miArbol.getFrontera() );

		// ------------------------------------------------------------------------//
		// Obtener una lista de todos los elementos que esten en un nivel especifico del
		// arbol
		// System.out.println( miArbol.getElementAtLevel(4));

		// ------------------------------------------------------------------------//
		// Dado un árbol retornar una lista donde cada elemento es el valor de la suma
		// del
		// camino desde la raíz hacía una hoja determinada. Por ejemplo, para el árbol
		// del
		// caso anterior la lista resultante sería: [15, 17, 19, 40, 45]
		System.out.println(miArbol.roadSumList());

		// ------------------------------------------------------------------------//
		
		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElement() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

		miArbol.add(23);
		miArbol.add(21);
		miArbol.delete(3);
		miArbol.delete(12);

		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElement() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

		miArbol.add(65);
		miArbol.delete(21);
		miArbol.delete(8);
		miArbol.add(5);

		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElement() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );



	}

}