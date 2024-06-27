public class DoublyLinkedList<T>
{
    private NodeDoubly<T>? head;
    private NodeDoubly<T>? tail;
    private int size;

    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void Clear()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public bool IsEmpty() => head == null;

    public int Size => size;

    public void AddAtStart(T elem)
    {
        var node = new NodeDoubly<T>(elem);
        if (IsEmpty())
        {
            head = node;
            tail = node;
        }
        else
        {
            node.Next = head;
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            head.Prev = node;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
            head = node;
        }
        size++;
    }

    public void AddAtEnd(T elem)
    {
        var node = new NodeDoubly<T>(elem);
        if (IsEmpty())
        {
            head = node;
            tail = node;
        }
        else
        {
            node.Prev = tail;
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            tail.Next = node;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
            tail = node;
        }
        size++;
    }

    public void AddAtPosition(int index, T elem)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfRangeException($"Index: {index}, Size: {size}");
        }
        if (index == 0)
        {
            AddAtStart(elem);
            return;
        }
        if (index == size)
        {
            AddAtEnd(elem);
            return;
        }
        var node = new NodeDoubly<T>(elem);
        var current = GetNode(index - 1);
        node.Next = current.Next;
        node.Prev = current;
#pragma warning disable CS8602 // Dereference of a possibly null reference.
        current.Next.Prev = node;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
        current.Next = node;
        size++;
    }

    public T Get(int index)
    {
        var current = GetNode(index);
        if (current != null)
            return current.Value;
        throw new IndexOutOfRangeException($"Index: {index}, Size: {size}");
    }

    private NodeDoubly<T> GetNode(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfRangeException($"Index: {index}, Size: {size}");

        var current = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++)
        {
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            current = current.Next;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
        }
#pragma warning disable CS8603 // Possible null reference return.
        return current;
#pragma warning restore CS8603 // Possible null reference return.
    }

    public bool Contains(T elem) => IndexOf(elem) != -1;

    public int IndexOf(T elem)
    {
        var current = head;
        int index = 0;
        while (current != null)
        {
#pragma warning disable CS8602 // Dereference of a possibly null reference.
            if (elem.Equals(current.Value))
                return index;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
            current = current.Next;
            index++;
        }
        return -1;
    }

    public T RemoveHead()
    {
        if (head == null)
            throw new InvalidOperationException("List is empty");

        var node = head;
        head = head.Next;

        if (head == null)
        {
            tail = null;
        }
        else
        {
            head.Prev = null;
        }
        size--;
        return node.Value;
    }

    public T RemoveTail()
    {
        if (tail == null)
            throw new InvalidOperationException("List is empty");

        var node = tail;
        tail = tail.Prev;

        if (tail == null)
        {
            head = null;
        }
        else
        {
            tail.Next = null;
        }
        size--;
        return node.Value;
    }

    public T RemoveAtPosition(int index)
    {
        if (IsEmpty() || index < 0 || index >= size)
            throw new InvalidOperationException("Invalid index or empty list");

        if (index == 0)
            return RemoveHead();
        if (index == size - 1)
            return RemoveTail();

        var current = GetNode(index);
#pragma warning disable CS8602 // Dereference of a possibly null reference.
        current.Prev.Next = current.Next;
        current.Next.Prev = current.Prev;
#pragma warning restore CS8602 // Dereference of a possibly null reference.
        size--;
        return current.Value;
    }

    public bool Remove(T elem)
    {
        int index = IndexOf(elem);
        if (IsEmpty() || index == -1)
        {
            return false;
        }
        RemoveAtPosition(index);
        return true;
    }

    public void Reverse()
    {
        NodeDoubly<T>? temp = null;
        NodeDoubly<T>? current = head;
        tail = head;
        while (current != null)
        {
            temp = current.Prev;
            current.Prev = current.Next;
            current.Next = temp;
            current = current.Prev;
        }
        if (temp != null)
        {
            head = temp.Prev;
        }
    }

    public object[] ToArray()
    {
        object[] result = new object[size];
        var current = head;
        int index = 0;
        while (current != null)
        {
#pragma warning disable CS8601 // Possible null reference assignment.
            result[index++] = current.Value;
#pragma warning restore CS8601 // Possible null reference assignment.
            current = current.Next;
        }
        return result;
    }
}
