public class Stack1<T>
{
    private int size;
    private T[] arr;
    private int top;

    public Stack1(int size = 100)
    {
        this.size = size;
        this.arr = new T[size];
        this.top = -1;
    }

    public bool IsEmpty()
    {
        return this.top == -1;
    }

    public bool IsFull()
    {
        return this.top == this.size - 1;
    }

    public void Push(T item)
    {
        if (this.IsFull())
        {
            throw new InvalidOperationException("Stack is full");
        }
        this.arr[++this.top] = item;
    }

    public T Pop()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty");
        }
        return this.arr[this.top--];
    }

    public T Peek()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty");
        }
        return this.arr[this.top];
    }

    public int Count
    {
        get
        {
            return this.top + 1;
        }
    }
}
