using System;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        Queue<string> queue = new Queue<string>();

        Console.WriteLine("queue.Count: " + queue.Count);
        Console.WriteLine("queue.IsEmpty: " + (queue.Count == 0));

        queue.Enqueue("Maria");
        queue.Enqueue("Joao");
        queue.Enqueue("Ana");
        Console.WriteLine("Adicionados: Maria, Joao, Ana");

        Console.WriteLine("queue.Count: " + queue.Count);
        Console.WriteLine("queue.IsEmpty: " + (queue.Count == 0));
        Console.WriteLine("queue.Peek: " + queue.Peek());

        Console.WriteLine("Itens:");
        while (queue.Count > 0)
        {
            Console.WriteLine(queue.Dequeue()); // Usando Dequeue que é similar ao poll
        }
    }
}
