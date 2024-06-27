public class NodeDoubly<T> {

    private T value;
    private NodeDoubly<T> next;
    private NodeDoubly<T> prev;

    public NodeDoubly(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeDoubly<T> getNext() {
        return this.next;
    }

    public void setNext(NodeDoubly<T> next) {
        this.next = next;
    }

    public NodeDoubly<T> getPrev() {
        return this.prev;
    }

    public void setPrev(NodeDoubly<T> prev) {
        this.prev = prev;
    }
}

