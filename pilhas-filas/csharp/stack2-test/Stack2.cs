using System;
using System.Collections.Generic;

public class Stack2<T>
{
    private List<T> list;

    public Stack2()
    {
        this.list = new List<T>();
    }

    public bool IsEmpty()
    {
        return this.list.Count == 0;
    }

    public void Push(T item)
    {
        this.list.Add(item);
    }

    public T Pop()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty");
        }
        T item = this.list[this.list.Count - 1];
        this.list.RemoveAt(this.list.Count - 1);
        return item;
    }

    public T Peek()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty");
        }
        return this.list[this.list.Count - 1];
    }

    public int Count
    {
        get 
        {
            return this.list.Count;
        }
    }
}
