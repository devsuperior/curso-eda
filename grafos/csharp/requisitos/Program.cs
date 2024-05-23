using System;
using System.Collections.Generic;

public class Solution
{
    public static bool CanFinish(int numCourses, int[][] prerequisites)
    {
        List<int>[] graph = new List<int>[numCourses];
        for (int i = 0; i < numCourses; i++)
        {
            graph[i] = new List<int>();
        }

        foreach (var pair in prerequisites)
        {
            int course = pair[0];
            int prereq = pair[1];
            graph[prereq].Add(course);
        }

        int[] visited = new int[numCourses];

        // Perform DFS on each course
        for (int course = 0; course < numCourses; course++)
        {
            if (visited[course] == 0) // Unvisited node
            {
                if (!DFS(course, graph, visited))
                {
                    return false;
                }
            }
        }

        return true;
    }

    // DFS function
    private static bool DFS(int node, List<int>[] graph, int[] visited)
    {
        if (visited[node] == 1)
        {
            // Node is being visited, hence a cycle is detected
            return false;
        }
        if (visited[node] == 2)
        {
            // Node has been completely visited
            return true;
        }

        // Mark the node as visiting
        visited[node] = 1;

        // Visit all the neighbors
        foreach (int neighbor in graph[node])
        {
            if (!DFS(neighbor, graph, visited))
            {
                return false;
            }
        }

        // Mark the node as completely visited
        visited[node] = 2;
        return true;
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][] { new int[] { 0, 1 } };
        Console.WriteLine(CanFinish(numCourses1, prerequisites1));

        // Exemplo 2
        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 } };
        Console.WriteLine(CanFinish(numCourses2, prerequisites2));
    }
}
