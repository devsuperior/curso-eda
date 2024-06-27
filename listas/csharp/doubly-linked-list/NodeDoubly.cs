public class NodeDoubly<T>
{
    public T Value { get; set; }
    public NodeDoubly<T>? Next { get; set; }
    public NodeDoubly<T>? Prev { get; set; }

    public NodeDoubly(T value)
    {
        Value = value;
        Next = null;
        Prev = null;
    }
}
