using System;
using System.Collections.Generic;

public class Queue1<T>
{
    private List<T> list;

    public Queue1()
    {
        this.list = new List<T>();
    }

    public bool IsEmpty()
    {
        return this.list.Count == 0;
    }

    public void Add(T item)
    {
        this.list.Add(item);
    }

    public T Remove()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Queue is empty");
        }
        T item = this.list[0];
        this.list.RemoveAt(0);
        return item;
    }

    public T Peek()
    {
        if (this.IsEmpty())
        {
            throw new InvalidOperationException("Queue is empty");
        }
        return this.list[0];
    }

    public int Count
    {
        get
        {
            return this.list.Count;
        }
    }
}
