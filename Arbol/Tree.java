package Arbol;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Node root;
	private int height;

	public Tree(int n) {
		Node node = new Node(n, null, null);
		this.add(node, this.root);
	}

	public Tree(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				Node n = new Node(arr[i], null, null);
				this.add(n, this.root);
			}
		}
		// this.root = null; porque pense que era buena idea dejar esto aca lpm
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Añadir Nodo al Arbol

	public void add(Node newNode, Node pivote) {
		if (this.root == null) {
			this.root = newNode;
		} else {
			if (newNode.getValue() < pivote.getValue()) {
				if (pivote.getLeft() == null) {
					pivote.setLeft(newNode);
				} else
					add(newNode, pivote.getLeft());
			}

			if (newNode.getValue() > pivote.getValue()) {
				if (pivote.getRight() == null) {
					pivote.setRight(newNode);
				} else {
					add(newNode, pivote.getRight());
				}
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver una Lista con los elementos de un nivel dado

	public List<Integer> getElementAtLevel(int level) {
		ArrayList<Integer> elements = new ArrayList<>();
		if (this.root != null) {
			elements.addAll(getElementAtLevel(level, this.root, 0));
		}
		return elements;
	}

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

	public Boolean delete(Integer value) {
		boolean result = false;
		if (this.root != null) {
			result = delete(value, this.root);
		}
		return result;
	}

	private Boolean delete(Integer value, Node pivote) {
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
			// TODO
		}
		return result;
	}

	public void setRoot(Node n) {
		this.root = n;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Devolver Lista de la Rama mas Larga 

	public List<Integer> getLongestBranch() {
		ArrayList<Integer> longesBranch = new ArrayList<Integer>();
		if (this.root != null) {
			longesBranch.addAll(getLongestBranch(this.root));

		}
		return longesBranch;
	}
	
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
            } 
            else {
            	longestBranch.addAll(rightBranch);
            } 
        return longestBranch;
    }
	
/////////////////////////////////////////////////////////////////////////////////////
	// Devolver Lista de los Nodos Frontera del Arbol

	public List<Integer> getFrontera() {
		ArrayList<Integer> leaf = new ArrayList<>();
		if (this.root != null) {
			leaf.addAll(getFrontera(this.root));
		}
		return leaf;
	}

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

	public int getHeight() {
		this.height = 0; // variable aux declarada en la clase
		getHeight(root, 0); // le paso raiz / root - origen del arbol
		return height;
	}

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

	public int getMinElem() {
		if (root != null) {
			Node reco = root;
			while (reco.getLeft() != null) {
				reco = reco.getLeft();
			}
			return reco.getValue();
		}
		return 0;
	}

	public int getMaxElem() {
		if (root != null) {
			Node reco = root;
			while (reco.getRight() != null) {
				reco = reco.getRight();
			}
			return reco.getValue();
		}
		return 0;
	}

/////////////////////////////////////////////////////////////////////////////////////

	
	
	public List<Integer> roadSumList() {
		ArrayList<Integer> sumLeaf = new ArrayList<>();
		if (this.root != null) {
			int sum = 0;
			sumLeaf.addAll(roadSumList(this.root, sum));
		}
		return sumLeaf;
	}
		

	private List<Integer> roadSumList(Node pivote, int sum) {
		ArrayList<Integer> leaf = new ArrayList<>();

		if (pivote.getLeft() == null && pivote.getRight() == null) {
			sum = sum + pivote.getValue();
			leaf.add(sum);
		}
		if (pivote.getLeft() != null) {
			int l = sum + pivote.getValue();
			leaf.addAll(roadSumList(pivote.getLeft(), l));
		}
		if (pivote.getRight() != null) {
			sum = sum + pivote.getValue();
			leaf.addAll((roadSumList(pivote.getRight(),sum)));
		}

		return leaf;
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Imprimir en PreOrden Los Nodos Del Arbol Binario

	public void printPreOrder() {
		if (root != null) {
			printPreOrder(this.root);
		}
	}

	private void printPreOrder(Node pivote) {
		if (pivote != null) {
			System.out.print(pivote.getValue() + " ");
			if (pivote.getLeft() != null)
				printPreOrder(pivote.getLeft());
			else
				System.out.print("- ");

			if (pivote.getRight() != null)
				printPreOrder(pivote.getRight());
			else
				System.out.print("-  ");
		}
	}

/////////////////////////////////////////////////////////////////////////////////////
	// Imprimir en InOrden Los Nodos Del Arbol Binario
	public void printInOrder() {
		if (this.root != null) {
			printInOrder(this.root);
		}
	}

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
	public void printPosOrder() {
		if (this.root != null) {
			printPosOrder(this.root);
		}
	}

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

	public boolean hasElem(Integer info) {
		boolean result = false;
		if (this.root != null) {
			result = hasElem(info, this.root);
		}
		return result;
	}

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

	public boolean isEmpty() {
		boolean result = true;
		if (this.root != null) {
			result = false;
		}
		return result;
	}

/////////////////////////////////////////////////////////////////////////////////////

	public Integer getRoot() {
		return this.root.getValue();
	}

/////////////////////////////////////////////////////////////////////////////////////
	// FUNCIONES AUXILIARES NO REQUERIDAS PARA EL LA TAREA ENTREGABLE
/////////////////////////////////////////////////////////////////////////////////////
	// NO SE PIDE EN EL ENUNCIADO PERO ME SIRVIO PARA NO ANDAR DIBUJANDO EL ARBOL A
	// CADA RATO

	String[] levels;

	public void imprimirNivel() {
		levels = new String[this.getHeight() + 1];

		System.out.println("----------------------------------");
		imprimirNivel(root, 0);
		for (int i = 0; i < levels.length; i++) {
			System.out.println(levels[i] + " En nivel: " + i);
		}
		System.out.println("----------------------------------");
	}

	public void imprimirNivel(Node pivote, int nextLevel) {
		if (pivote != null) {
			levels[nextLevel] = pivote.getValue() + ", " + ((levels[nextLevel] != null) ? levels[nextLevel] : "");
			imprimirNivel(pivote.getRight(), nextLevel + 1);
			imprimirNivel(pivote.getLeft(), nextLevel + 1);
		}
	}

}