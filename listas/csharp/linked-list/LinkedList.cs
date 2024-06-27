using System.Text;

public class LinkedList<T>
{
    public Node<T>? Head { get; private set; }
    public int Size { get; private set; }

    public LinkedList()
    {
        Head = null;
        Size = 0;
    }

    public bool IsEmpty() => Head == null;

    public void AddAtStart(T elem)
    {
        Node<T> node = new Node<T>(elem) { Next = Head };
        Head = node;
        Size++;
    }

    public void AddAtEnd(T elem)
    {
        Node<T> node = new Node<T>(elem);
        if (Head == null)
        {
            Head = node;
            Size++;
            return;
        }
        Node<T> current = Head;
        while (current.Next != null)
        {
            current = current.Next;
        }
        current.Next = node;
        Size++;
    }

    public void AddAtPosition(int index, T elem)
    {
        if (index == 0 || IsEmpty())
        {
            AddAtStart(elem);
            return;
        }

        Node<T>? current = GetNode(index - 1);
        if (current == null)
        {
            AddAtEnd(elem);
            return;
        }
        Node<T> node = new Node<T>(elem) { Next = current.Next };
        current.Next = node;
        Size++;
    }

    public T? Get(int index)
    {
        var node = GetNode(index);
        return node != null ? node.Value : default;
    }

    public Node<T>? GetNode(int index)
    {
        if (index < 0 || index >= Size)
        {
            return null;
        }
        Node<T>? current = Head;
        for (int i = 0; current != null && i < index; i++)
        {
            current = current.Next;
        }
        return current;
    }

    public bool Contains(T elem) => IndexOf(elem) != -1;

    public int IndexOf(T elem)
    {
        Node<T>? current = Head;
        for (int i = 0; i < Size; i++)
        {
            if (current != null)
            {
                if (EqualityComparer<T>.Default.Equals(current.Value, elem))
                {
                    return i;
                }
                current = current.Next;
            }
        }
        return -1;
    }

    public T? RemoveAtPosition(int index)
    {
        if (IsEmpty() || index < 0 || index >= Size)
        {
            return default;
        }
        T item;
        if (index == 0)
        {
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            item = Head.Value;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
            Head = Head.Next;
            Size--;
            return item;
        }
        Node<T>? prev = GetNode(index - 1);
#pragma warning disable CS8602 // Dereference of a possibly null reference. 
        item = prev.Next.Value;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
        prev.Next = prev.Next.Next;
        Size--;
        return item;
    }

    public bool Remove(T elem)
    {
        int index = IndexOf(elem);
        if (index == -1) return false;
        RemoveAtPosition(index);
        return true;
    }

    public T[] ToArray()
    {
        T[] array = new T[Size];
        Node<T>? current = Head;
        for (int i = 0; i < Size; i++)
        {
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            array[i] = current.Value;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
            current = current.Next;
        }
        return array;
    }

    public override string ToString()
    {
        if (Head == null) 
        {
            return "[]";
        } 
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = Head;
        while (current.Next != null)
        {
            builder.Append(current.Value).Append(",");
            current = current.Next;
        }
        builder.Append(current.Value).Append("]");
        return builder.ToString();
    }
}
