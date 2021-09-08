package Arbol;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Node root;
	private int height;

	/**
	 * O(n*h) donde la complejida dependera de los nodos y la altura del arbol 
	 * @param arr
	 */
	public Tree(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				Node n = new Node(arr[i], null, null, null);
				this.add(n, this.root);
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Añadir Nodo al Arbol

	/**
	 * O(n) porque puede invocar un metodo O(n)
	 * 
	 * @param n
	 */
	public void add(int n) {
		Node node = new Node(n, null, null, null);
		add(node, this.root);
	}

	/**
	 * O(h) donde el peor de los casos tendra que ir a la altura maxima del arbol (h
	 * es la altura)
	 * 
	 * @param newNode
	 * @param pivote  nodo puntero.
	 */
	private void add(Node newNode, Node pivote) {
		if (isEmpty()) {
			this.root = newNode;
		} else {
			if (newNode.getValue() < pivote.getValue()) {
				if (pivote.getLeft() == null) {
					pivote.setLeft(newNode);
					newNode.setParent(pivote);
				} else
					add(newNode, pivote.getLeft());
			}
			if (newNode.getValue() > pivote.getValue()) {
				if (pivote.getRight() == null) {
					pivote.setRight(newNode);
					newNode.setParent(pivote);
				} else {
					add(newNode, pivote.getRight());
				}
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver una Lista con los elementos de un nivel dado

	/**
	 * O(n) donde en el peor de los casos llamo a un metodo O(n) 
	 * @param level
	 * @return
	 */
	public List<Integer> getElementAtLevel(int level) {
		ArrayList<Integer> elements = new ArrayList<>();
		if (!isEmpty()) {
			elements.addAll(getElementAtLevel(level, this.root, 0));
		}
		return elements;
	}

	/**
	 * O(n) en el peor de los casos voy a buscar hasta el ultimo nivel
	 * 
	 * @param level
	 * @param pivote
	 * @param currentLevel
	 * @return
	 */
	private List<Integer> getElementAtLevel(int level, Node pivote, int currentLevel) {
		ArrayList<Integer> elements = new ArrayList<>();
		if (level == currentLevel) {
			elements.add(pivote.getValue());
		} else {
			if (pivote.getLeft() != null) {
				currentLevel++;
				elements.addAll(getElementAtLevel(level, pivote.getLeft(), currentLevel));
				currentLevel--;
			}
			if (pivote.getRight() != null) {
				currentLevel++;
				elements.addAll(getElementAtLevel(level, pivote.getRight(), currentLevel));
				currentLevel--;
			}
		}
		return elements;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Eliminar Nodo Del Arbol

	/**
	 * Complejidad O(h)
	 * 
	 * @param value
	 * @return
	 */
	public boolean delete(Integer value) {
		boolean result = false;
		if (!isEmpty()) {
			result = delete(value, this.root);
		}
		return result;
	}

	/**
	 * O(h) en el peor de los casos borro un elemento Hoja
	 * 
	 * @param value
	 * @param pivote
	 * @return
	 */
	private boolean delete(Integer value, Node pivote) {
		boolean result = false;

		if (value < pivote.getValue()) {
			if (pivote.getLeft() != null) {
				result = delete(value, pivote.getLeft());
			} else {

				return false;
			}

		} else if (value > pivote.getValue()) {
			if (pivote.getRight() != null) {
				result = delete(value, pivote.getRight());
			} else {
				return false;
			}
		} else {
			if (pivote.getLeft() == null && pivote.getRight() == null) {
				Node parent = pivote.getParent();
				if (parent == null) {
					this.root = null;
				} else {
					result = setParentNode(parent, value, null);
				}
			}
			if (pivote.getLeft() != null) {
				Node next = getMaxNode(pivote.getLeft());
				int v = next.getValue();

				delete(v, next);
				pivote.setValue(v);
			} else if (pivote.getRight() != null) {
				Node next = getMinNode(pivote.getRight());
				int v = next.getValue();
				delete(v, next);
				pivote.setValue(next.getValue());
			}
		}
		return result;
	}

	/**
	 * O(1) al padre le borro el hijo si es una hoja
	 * 
	 * @param father
	 * @param value
	 * @param newValue
	 * @return
	 */
	private boolean setParentNode(Node father, int value, Node newValue) {
		boolean result = false;
		if (father.getLeft() != null) {
			if (father.getLeft().getValue() == value) {
				father.setLeft(newValue);
				result = true;
			}
		}
		if (father.getRight() != null) {
			if (father.getRight().getValue() == value) {
				father.setRight(newValue);
				result = true;
			}
		}
		return result;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver Lista de la Rama mas Larga
	/**
	 * O(n) 
	 * @return
	 */
	public List<Integer> getLongestBranch() {
		ArrayList<Integer> longesBranch = new ArrayList<Integer>();
		if (!isEmpty()) {
			longesBranch.addAll(getLongestBranch(this.root));

		}
		return longesBranch;
	}

	/**
	 * O(n) tengo que recorrer el arbol completo siempre
	 * 
	 * @param pivote
	 * @return
	 */
	private List<Integer> getLongestBranch(Node pivote) {
		ArrayList<Integer> longestBranch = new ArrayList<>();
		ArrayList<Integer> leftBranch = new ArrayList<>();
		ArrayList<Integer> rightBranch = new ArrayList<>();
		longestBranch.add(pivote.getValue());

		if (pivote.getLeft() != null) {
			leftBranch.addAll(getLongestBranch(pivote.getLeft()));
		}
		if (pivote.getRight() != null) {
			rightBranch.addAll(getLongestBranch(pivote.getRight()));
		}

		if (leftBranch.size() > rightBranch.size()) {
			longestBranch.addAll(leftBranch);
		} else {
			longestBranch.addAll(rightBranch);
		}
		return longestBranch;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver Lista de los Nodos Frontera del Arbol

	/**
	 * O(n)
	 * @return
	 */
	public List<Integer> getFrontera() {
		ArrayList<Integer> leaf = new ArrayList<>();
		if (!isEmpty()) {
			leaf.addAll(getFrontera(this.root));
		}
		return leaf;
	}

	/**
	 * O(n) tengo que recorrer el arbol completo siempre
	 * 
	 * @param pivote
	 * @return
	 */
	private List<Integer> getFrontera(Node pivote) {
		ArrayList<Integer> leaf = new ArrayList<>();

		if (pivote.getLeft() == null && pivote.getRight() == null) {
			leaf.add(pivote.getValue());
		}
		if (pivote.getLeft() != null) {
			leaf.addAll(getFrontera(pivote.getLeft()));
		}
		if (pivote.getRight() != null) {
			leaf.addAll((getFrontera(pivote.getRight())));
		}

		return leaf;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver Altura Maxima Del Arbol

	/**
	 * O(1)
	 * @return
	 */
	public int getHeight() {
		this.height = 0; // variable aux declarada en la clase
		getHeight(root, 0); // le paso raiz / root - origen del arbol
		return height;
	}

	/**
	 * O(n) tengo que recorrer el arbol completo siempre
	 * @param n
	 * @param level
	 */
	private void getHeight(Node n, int level) {
		if (n != null) {
			getHeight(n.getLeft(), level + 1);// si el nodo es null no se va a setear la altura
			if (level > this.height) {
				this.height = level;
			}
			getHeight(n.getRight(), level + 1);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver El Valor Maximo o Minimo del Arbol

	/**
	 * O(h)
	 * @return
	 */
	public Integer getMaxElement() {
		if (!isEmpty()) {
			return getMaxElement(this.root);
		} else {
			return null;
		}
	}

	/**
	 * O(h) en peor de los casos la rama derecha es la mas grande
	 * @param n
	 * @return
	 */
	private Integer getMaxElement(Node n) {
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n.getValue();
	}

//	public Integer getMinElement() {
//		if (!isEmpty()) {
//			Node reco = root;
//			while (reco.getLeft() != null) {
//				reco = reco.getLeft();
//			}
//			return reco.getValue();
//		}
//		return null;
//	}

	/**
	 * O(h) en peor de los casos la rama derecha es la mas grande
	 * @param n
	 * @return
	 */
	private Node getMaxNode(Node n) {

		if (n != null) {
			while (n.getRight() != null) {
				n = n.getRight();
			}
			return n;
		}
		return n;
	}

	/**
	 * O(h) en peor de los casos la rama Izquierda es la mas grande 
	 * @param n
	 * @return
	 */
	private Node getMinNode(Node n) {
		if (n != null) {
			while (n.getLeft() != null) {
				n = n.getLeft();
			}
			return n;
		}
		return n;
	}

/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * O(n)
	 * @return
	 */
	public List<Integer> roadSumList() {
		ArrayList<Integer> sumLeaf = new ArrayList<>();
		if (!isEmpty()) {
			int sum = 0;
			sumLeaf.addAll(roadSumList(this.root, sum));
		}
		return sumLeaf;
	}

	/**
	 * O(n) siempre tiene que recorrer todos los nodos
	 * @param pivote
	 * @param sum
	 * @return
	 */
	private List<Integer> roadSumList(Node pivote, int sum) {
		ArrayList<Integer> leaf = new ArrayList<>();

		sum = sum + pivote.getValue();
		if (pivote.getLeft() == null && pivote.getRight() == null) {
			leaf.add(sum);
		}
		if (pivote.getLeft() != null) {
			leaf.addAll(roadSumList(pivote.getLeft(), sum));
		}
		if (pivote.getRight() != null) {
			leaf.addAll((roadSumList(pivote.getRight(), sum)));
		}

		return leaf;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Imprimir en PreOrden Los Nodos Del Arbol Binario

	public void printPreOrder() {
		if (!isEmpty()) {
			printPreOrder(this.root);
		}
	}

	/**
	 * O(n)
	 * 
	 * @param pivote
	 */
	private void printPreOrder(Node pivote) {
		if (pivote != null) {
			System.out.print(pivote.getValue() + " ");
			if (pivote.getLeft() != null) {
				printPreOrder(pivote.getLeft());
			} else {
				System.out.print("- ");
			}

			if (pivote.getRight() != null) {
				printPreOrder(pivote.getRight());
			} else {
				System.out.print("-  ");
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Imprimir en InOrden Los Nodos Del Arbol Binario
	
	/**
	 * O(n)
	 */
	public void printInOrder() {
		if (!isEmpty()) {
			printInOrder(this.root);
		}
	}

	/**
	 * O(n)
	 * @param pivote
	 */
	private void printInOrder(Node pivote) {
		if (pivote.getLeft() != null) {
			printInOrder(pivote.getLeft());
		}
		System.out.print(" " + pivote.getValue());
		if (pivote.getRight() != null) {
			printInOrder(pivote.getRight());
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
// Imprimir en PosOrden Los Nodos Del Arbol Binario
	
	/**
	 * O(n)
	 */
	public void printPosOrder() {
		if (!isEmpty()) {
			printPosOrder(this.root);
		}
	}

	/**
	 * O(n)
	 * @param pivote
	 */
	private void printPosOrder(Node pivote) {
		if (pivote.getLeft() != null) {
			printPosOrder(pivote.getLeft());
		}

		if (pivote.getRight() != null) {
			printPosOrder(pivote.getRight());
		}
		System.out.print(" " + pivote.getValue());
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Verificar Si Existe Un Valor Dentro Del Arbol

	/**
	 * O(n)
	 * @param info
	 * @return
	 */
	public boolean hasElem(Integer info) {
		boolean result = false;
		if (!isEmpty()) {
			result = hasElem(info, this.root);
		}
		return result;
	}

	/**
	 * O(n) en el pero de los casos no esta el elemento en el arbol 
	 * @param info
	 * @param pivote
	 * @return
	 */
	private boolean hasElem(Integer info, Node pivote) {
		boolean result = false;
		if (info == pivote.getValue()) {
			result = true;
		}
		if (info > pivote.getValue()) {
			if (pivote.getRight() != null) {
				result = hasElem(info, pivote.getRight());
			}
		}

		if (info < pivote.getValue()) {
			if (pivote.getLeft() != null) {
				result = hasElem(info, pivote.getLeft());
			}
		}

		return result;
	}

/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * O(1) 
	 * @return
	 */
	public boolean isEmpty() {
		boolean result = true;
		if (this.root != null) {
			result = false;
		}
		return result;
	}

/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * O(1) 
	 * @return
	 */
	public Integer getRoot() {
		return this.root.getValue();
	}
}