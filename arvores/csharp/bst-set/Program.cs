using System;
using System.Collections.Generic;
using Bst;

class Program
{
    public static void Main()
    {
        var A = new BinarySearchTreeSet<int>(new List<int> { 1, 2, 3, 4, 5 });
        var B = new BinarySearchTreeSet<int>(new List<int> { 4, 5, 6, 7, 8 });

        Console.WriteLine("Conjunto A: " + A);
        Console.WriteLine("Conjunto B: " + B);

        A.Add(9);
        Console.WriteLine("Conjunto A após adicionar 9: " + A);

        A.Remove(9);
        Console.WriteLine("Conjunto A após remover 9: " + A);

        Console.WriteLine("5 pertence ao conjunto A? " + A.Contains(5));

        Console.WriteLine("Conjunto A está vazio? " + A.IsEmpty());

        Console.WriteLine("Tamanho do conjunto A: " + A.Size());

        var C = A.Union(B);
        Console.WriteLine("União dos conjuntos A e B (Conjunto C): " + C);

        C = A.Intersection(B);
        Console.WriteLine("Interseção dos conjuntos A e B (Conjunto C): " + C);

        C = A.Difference(B);
        Console.WriteLine("Diferença entre os conjuntos A e B (Conjunto C): " + C);
    }
}
