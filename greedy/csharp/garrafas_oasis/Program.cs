using System;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine(MaximumBottles(5, 10, new List<int>{8, 5, 4, 3, 2}));
        Console.WriteLine(MaximumBottles(3, 10, new List<int>{6, 3, 2}));
    }
    public static int MaximumBottles(int n, int x, List<int> v)
    {
        // Sorting the capacities list
        v.Sort();

        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            // If there's water left to fill a full bottle
            if (x - v[i] >= 0)
            {
                x -= v[i];
                ans++;
            }
            else
                break;
        }
        return ans;
    }
}