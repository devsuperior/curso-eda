using System;
using System.Collections.Generic;

public class Solution
{
    public static bool VisitAllRooms(IList<IList<int>> rooms)
    {
        bool[] visited = new bool[rooms.Count];
        visited[0] = true;
        Stack<int> stack = new Stack<int>();
        stack.Push(0);

        while (stack.Count > 0)
        {
            int current = stack.Pop();
            foreach (int neighbour in rooms[current])
            {
                if (!visited[neighbour])
                {
                    visited[neighbour] = true;
                    stack.Push(neighbour);
                }
            }
        }

        // Se alguma sala não foi visitada, retorna False
        foreach (bool visit in visited)
        {
            if (!visit)
                return false;
        }
        return true;
    }

    public static void Main(string[] args)
    {
        // Exemplo 1
        IList<IList<int>> rooms1 = new List<IList<int>> { new List<int> { 1 }, new List<int> { 2 }, new List<int> { 3 }, new List<int>() };
        Console.WriteLine(VisitAllRooms(rooms1));

        // Exemplo 2
        IList<IList<int>> rooms2 = new List<IList<int>> { new List<int> { 1, 3 }, new List<int> { 3, 0, 1 }, new List<int> { 2 }, new List<int> { 0 } };
        Console.WriteLine(VisitAllRooms(rooms2));
    }
}
