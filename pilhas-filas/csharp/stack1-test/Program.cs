using System;

public class Program {
    public static void Main(string[] args) {
        Stack1<string> stack = new Stack1<string>(10);

        Console.WriteLine("stack.Count: " + stack.Count);
        Console.WriteLine("stack.IsEmpty(): " + stack.IsEmpty());

        stack.Push("Maria");
        stack.Push("Joao");
        stack.Push("Ana");
        Console.WriteLine("Adicionados: Maria, Joao, Ana");

        Console.WriteLine("stack.Count: " + stack.Count);
        Console.WriteLine("stack.IsEmpty(): " + stack.IsEmpty());
        Console.WriteLine("stack.Peek(): " + stack.Peek());

        Console.WriteLine("Itens:");
        while (!stack.IsEmpty()) {
            Console.WriteLine(stack.Pop());
        }
    }
}
