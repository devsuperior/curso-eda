using System;
using System.Collections.Generic;

public class Program
{
    public int MaximumBottles(int n, int x, List<int> v)
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