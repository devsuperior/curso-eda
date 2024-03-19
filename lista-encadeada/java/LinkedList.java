package lists.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        if (this.head == null)
            return true;
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public void addAtStart(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }
        Node<T> aux = this.head;
        this.head = node;
        node.setNext(aux);
        this.size++;
    }

    public void addAtEnd(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        this.size++;
    }

    public void addAtPosition(int index, T elem) {
        if (index == 0) {
            this.addAtStart(elem);
            return;
        }
    
        if (this.get(index) == null) {
            this.addAtEnd(elem);
            return;
        }
        
        Node<T> node = new Node<T>(elem);
        Node<T> aux = this.getNode(index - 1);
        node.setNext(aux.getNext());
        aux.setNext(node);
        this.size++;
    }

    public T get(int index) {
        Node<T> current = this.getNode(index);
        if (current != null)
            return current.getValue();
        return null;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index > this.getSize())
            return null;
        Node<T> current = this.head;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        if (current != null)
            return current;
        return null;
    }

    public boolean contains(T elem) {
        int indexElem = this.indexOf(elem);
        if (indexElem != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(T elem) {
        Node<T> current = this.head;
        int i = 0;
        while (current != null) {
            if (current.getValue() == elem)
                return i;
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public T removeAtPosition(int index) {
        if (this.isEmpty() || this.get(index) == null) {
            return null;
        }
        T item = null;
        Node<T> aux = null;
        if (index == 0) {
            item = this.head.getValue();
            this.head = this.head.getNext();
            this.size--;
            return item;
        }
        if (index == this.getSize() - 1) {
            item = this.get(index);
            aux = this.getNode(index - 1);
            aux.setNext(null);
            this.size--;
            return item;
        }
        aux = this.getNode(index - 1);
        item = aux.getNext().getValue();
        aux.setNext(aux.getNext().getNext());
        this.size--;
        return item;
    }

    public boolean remove(T elem) {
        int index = this.indexOf(elem);
        if (this.isEmpty() || index == -1) 
            return false;
        this.removeAtPosition(index);
        return true;
    }

    public List<T> toArray() {
        List<T> vect = new ArrayList<>();
        Node<T> current = this.head;

        while (current != null) {
            vect.add(current.getValue());
            current = current.getNext();
        }
        return vect;
    }

    @Override
    public String toString() {
        if (this.isEmpty() == true) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = this.head;
        while (current.getNext() != null) {
            builder.append(current.getValue()).append(",");
            current = current.getNext();
        }
        builder.append(current.getValue()).append("]");

        return builder.toString();
    }
}