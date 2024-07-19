package generictree;

import java.util.ArrayList;
import java.util.List;

class Node<T> implements Position<T> {
    private T element;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T element, Node<T> parent) {
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    @Override
    public T element() {
        return element;
    }

    public void setElement(T element) {
    	this.element = element;
    }
    
    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(Node<T> child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(Node<T> child) {
        children.remove(child);
        child.setParent(null);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
