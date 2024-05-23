using System;
using System.Collections.Generic;

public class DisjointSet
{
    private int[] parent;
    public int Components { get; private set; }

    public DisjointSet(int n)
    {
        parent = new int[n];
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
        }
        Components = n;
    }

    // Acha o parent da componente atual
    public int Find(int x)
    {
        while (parent[x] != x)
        {
            x = parent[x];
        }
        return x;
    }

    // Une duas componentes a partir dos parents
    public void Union(int x, int y)
    {
        int rootX = Find(x);
        int rootY = Find(y);
        if (rootX != rootY)
        {
            parent[rootY] = rootX;
            Components--;
        }
    }
}

public class Solution
{
    public static int MinimumCost(int n, int[][] connections)
    {
        int Kruskal(int numVertices, List<int[]> edges)
        {
            // Ordenar crescentemente por peso
            edges.Sort((a, b) => a[2].CompareTo(b[2]));

            // Criar estruturas de apoio
            DisjointSet disjointSet = new DisjointSet(numVertices);
            int totalWeight = 0;

            // Percorrer a lista de arestas ordenada
            foreach (var edge in edges)
            {
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                int weight = edge[2];

                // Se estiverem em componentes diferentes, faz a união
                if (disjointSet.Find(u) != disjointSet.Find(v))
                {
                    disjointSet.Union(u, v);
                    totalWeight += weight;
                }
            }

            // Verificar se todas as vértices estão conectadas
            if (disjointSet.Components > 1)
            {
                return -1; // Não é possível formar uma árvore mínima
            }

            return totalWeight;
        }

        var edgesList = new List<int[]>(connections);
        return Kruskal(n, edgesList);
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        int n = 3;
        int[][] connections1 = { new int[] { 1, 2, 5 }, new int[] { 1, 3, 6 }, new int[] { 2, 3, 1 } };
        Console.WriteLine(MinimumCost(n, connections1)); // Output esperado: 6

        // Exemplo 2
        n = 4;
        int[][] connections2 = { new int[] { 1, 2, 3 }, new int[] { 3, 4, 4 } };
        Console.WriteLine(MinimumCost(n, connections2)); // Output esperado: -1
    }
}
