using System;
using System.Collections.Generic;

public class Solution
{
    public static bool ValidPath(int n, int[][] edges, int source, int destination)
    {
        // Armazena todas as arestas de acordo com os nós em 'graph'
        List<List<int>> adjList = new List<List<int>>(n);
        for (int i = 0; i < n; i++)
        {
            adjList.Add(new List<int>());
        }

        foreach (var edge in edges)
        {
            int a = edge[0], b = edge[1];
            adjList[a].Add(b);
            adjList[b].Add(a);
        }

        // Começa do nó fonte, adiciona-o à pilha
        bool[] visited = new bool[n];
        visited[source] = true;
        Stack<int> stack = new Stack<int>();
        stack.Push(source);

        while (stack.Count > 0)
        {
            int currNode = stack.Pop();
            if (currNode == destination)
            {
                return true;
            }
            // Adiciona todos os vizinhos não visitados do nó atual à pilha
            // e marca como visitado
            foreach (int neighbour in adjList[currNode])
            {
                if (!visited[neighbour])
                {
                    visited[neighbour] = true;
                    stack.Push(neighbour);
                }
            }
        }

        return false;
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        int n = 3;
        int[][] edges1 = new int[][] {
            new int[] { 0, 1 },
            new int[] { 1, 2 },
            new int[] { 2, 0 }
        };
        int source = 0;
        int destination = 2;
        Console.WriteLine(ValidPath(n, edges1, source, destination)); // True

        // Exemplo 2
        n = 6;
        int[][] edges2 = new int[][] {
            new int[] { 0, 1 },
            new int[] { 0, 2 },
            new int[] { 3, 5 },
            new int[] { 5, 4 },
            new int[] { 4, 3 }
        };
        source = 0;
        destination = 5;
        Console.WriteLine(ValidPath(n, edges2, source, destination)); // False
    }
}
