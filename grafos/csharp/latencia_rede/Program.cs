using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public static int Dijkstra(int s, int numVertices, List<List<(int, int)>> adjList)
    {
        int[] dist = Enumerable.Repeat(int.MaxValue, numVertices).ToArray();
        bool[] visited = new bool[numVertices];

        // Inicializar distâncias até a origem
        dist[s] = 0;

        // Loop para garantir que todos os vértices sejam processados
        for (int k = 0; k < numVertices; k++)
        {
            int current = -1;

            for (int i = 0; i < numVertices; i++)
            {
                if (visited[i]) continue;

                // Seleciona o vértice mais próximo
                if (current == -1 || dist[i] < dist[current])
                {
                    current = i;
                }
            }

            if (current == -1) break; // Todos os vértices restantes são inatingíveis
            visited[current] = true;

            // Percorrer vizinhos de current
            foreach (var (neighbour, w) in adjList[current])
            {
                // Tentar relaxar vizinho w
                if (dist[current] + w < dist[neighbour])
                {
                    dist[neighbour] = dist[current] + w;
                }
            }
        }

        // Encontre a maior distância mínima calculada durante o algoritmo de Dijkstra
        int maxMinDist = dist.Max();
        return maxMinDist == int.MaxValue ? -1 : maxMinDist;
    }

    public static int NetworkDelayTime(int[][] times, int n, int k)
    {
        var adjList = new List<List<(int, int)>>();

        for (int i = 0; i < n; i++)
        {
            adjList.Add(new List<(int, int)>());
        }

        foreach (var time in times)
        {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            adjList[u].Add((v, w));
        }

        return Dijkstra(k - 1, n, adjList);
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        int[][] times1 = { new int[] { 2, 1, 1 }, new int[] { 2, 3, 1 }, new int[] { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        Console.WriteLine(NetworkDelayTime(times1, n, k)); // Output esperado: 2

        // Exemplo 2
        int[][] times2 = { new int[] { 1, 2, 1 } };
        n = 2;
        k = 1;
        Console.WriteLine(NetworkDelayTime(times2, n, k)); // Output esperado: 1

        // Exemplo 3
        int[][] times3 = { new int[] { 1, 2, 1 } };
        n = 2;
        k = 2;
        Console.WriteLine(NetworkDelayTime(times3, n, k)); // Output esperado: -1
    }
}
