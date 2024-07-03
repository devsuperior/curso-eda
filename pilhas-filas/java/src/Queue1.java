import java.util.ArrayList;
import java.util.List;

public class Queue1<T> {

	private List<T> list;

    public Queue1() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void add(T item) {
        this.list.add(item);
    }

    public T remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.list.remove(0);
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.list.get(0);
    }

    public int count() {
        return this.list.size();
    }
}
