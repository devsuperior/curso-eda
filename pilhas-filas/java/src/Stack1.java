public class Stack1<T> {
    private int size;
    private T[] arr;
    private int top;

    public Stack1() {
        this(100);
    }

    @SuppressWarnings("unchecked")
	public Stack1(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public void push(T item) {
        if (this.isFull()) {
            throw new RuntimeException("Stack is full");
        }
        this.arr[++this.top] = item;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.arr[this.top--];
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.arr[this.top];
    }

    public int count() {
        return this.top + 1;
    }
}
