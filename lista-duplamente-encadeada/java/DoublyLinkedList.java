package lists.doublelinkedlist;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void addAtStart(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
        this.size += 1;
    }

    public void addAtEnd(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setPrev(this.tail);
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size += 1;
    }
}