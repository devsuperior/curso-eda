class Program
{
    static void Main(string[] args)
    {
        Queue1<string> queue = new Queue1<string>();

        Console.WriteLine("queue.Count: " + queue.Count);
        Console.WriteLine("queue.IsEmpty(): " + queue.IsEmpty());

        queue.Add("Maria");
        queue.Add("Joao");
        queue.Add("Ana");
        Console.WriteLine("Adicionados: Maria, Joao, Ana");

        Console.WriteLine("queue.Count: " + queue.Count);
        Console.WriteLine("queue.IsEmpty(): " + queue.IsEmpty());
        Console.WriteLine("queue.Peek(): " + queue.Peek());

        Console.WriteLine("Itens:");
        while (!queue.IsEmpty())
        {
            Console.WriteLine(queue.Remove());
        }
    }
}
