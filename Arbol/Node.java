package Arbol;

public class Node {

    private Integer value;
    private Node left, right;
    private Node parent;

    public Node(Integer dato, Node izq, Node der, Node parent) {
    	this.parent = parent;
        this.value = dato;
        this.left = izq;
        this.right = der;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node izq) {
        this.left = izq;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node der) {
        this.right = der;
    }
    public int getValue() {
        return value;
    }

    public void setValue(Integer dato) {
        this.value = dato;
    }

	public Node getParent() {
		return parent;
	}

	public void setParent(Node father) {
		this.parent = father;
	}

}