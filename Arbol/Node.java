package Arbol;

public class Node {

    private Integer value;
    private Node left, right;

    public Node(Integer dato, Node izq, Node der) {
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

}