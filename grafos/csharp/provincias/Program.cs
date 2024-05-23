using System;
using System.Collections.Generic;

public class Solution
{
    public static void DFS(int node, int[][] isConnected, bool[] visit)
    {
        visit[node] = true;
        for (int i = 0; i < isConnected.Length; i++)
        {
            if (isConnected[node][i] == 1 && !visit[i])
            {
                DFS(i, isConnected, visit);
            }
        }
    }

    public static int FindCircleNum(int[][] isConnected)
    {
        int n = isConnected.Length;
        int numberOfComponents = 0;
        bool[] visit = new bool[n];

        for (int i = 0; i < n; i++)
        {
            if (!visit[i])
            {
                numberOfComponents++;
                DFS(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        int[][] isConnected1 = new int[][] {
            new int[] {1, 1, 0},
            new int[] {1, 1, 0},
            new int[] {0, 0, 1}
        };
        Console.WriteLine(FindCircleNum(isConnected1));

        // Exemplo 2
        int[][] isConnected2 = new int[][] {
            new int[] {1, 0, 0},
            new int[] {0, 1, 0},
            new int[] {0, 0, 1}
        };
        Console.WriteLine(FindCircleNum(isConnected2));
    }
}
