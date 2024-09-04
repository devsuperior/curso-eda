import java.util.ArrayList;
import java.util.List;

public class Stack2<T> {
    private List<T> list;

    public Stack2() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void push(T item) {
        this.list.add(item);
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.list.remove(this.list.size() - 1);
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.list.get(this.list.size() - 1);
    }

    public int count() {
        return this.list.size();
    }
    
    public void clear() {
        this.list = new ArrayList<>();
    }
}
