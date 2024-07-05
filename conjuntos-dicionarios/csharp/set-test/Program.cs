using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // Inicializando os conjuntos A e B
        HashSet<int> A = new HashSet<int> { 1, 2, 3, 4, 5 };
        HashSet<int> B = new HashSet<int> { 4, 5, 6, 7, 8 };

        // Mostrando os conteúdos dos conjuntos A e B
        Console.WriteLine("Conjunto A: " + string.Join(", ", A));
        Console.WriteLine("Conjunto B: " + string.Join(", ", B));

        // Adicionando um novo número ao conjunto A
        A.Add(9);
        Console.WriteLine("Conjunto A após adicionar 9: " + string.Join(", ", A));

        // Removendo o número adicionado do conjunto A
        A.Remove(9);
        Console.WriteLine("Conjunto A após remover 9: " + string.Join(", ", A));

        // Testando se um elemento pertence ao conjunto A
        Console.WriteLine("5 pertence ao conjunto A? " + A.Contains(5));

        // Testando se o conjunto A está vazio
        Console.WriteLine("Conjunto A está vazio? " + (A.Count == 0));

        // Testando o tamanho do conjunto A
        Console.WriteLine("Tamanho do conjunto A: " + A.Count);

        // União dos conjuntos A e B, salvando o resultado em um conjunto C
        HashSet<int> C = new HashSet<int>(A);
        C.UnionWith(B);
        Console.WriteLine("União dos conjuntos A e B (Conjunto C): " + string.Join(", ", C));

        // Interseção dos conjuntos A e B, salvando o resultado em um conjunto C
        C = new HashSet<int>(A);
        C.IntersectWith(B);
        Console.WriteLine("Interseção dos conjuntos A e B (Conjunto C): " + string.Join(", ", C));

        // Diferença entre os conjuntos A e B, salvando o resultado em um conjunto C
        C = new HashSet<int>(A);
        C.ExceptWith(B);
        Console.WriteLine("Diferença entre os conjuntos A e B (Conjunto C): " + string.Join(", ", C));
    }
}
