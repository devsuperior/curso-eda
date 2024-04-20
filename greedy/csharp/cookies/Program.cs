using System;
using System.Collections.Generic;

class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine(FindContentChildren(new List<int>{1, 2, 3}, new List<int>{1, 1}));
        Console.WriteLine(FindContentChildren(new List<int>{1, 2}, new List<int>{2, 3, 1}));
    }
    public static int FindContentChildren(List<int> g, List<int> s)
    {
        g.Sort();
        s.Sort();

        int j = 0, ans = 0;
        // for each child
        for (int i = 0; i < g.Count; i++)
        {
            // try to find a cookie that fits
            while (j < s.Count && s[j] < g[i])
            {
                j++;
            }
            // if there's no more cookies
            if (j == s.Count)
            {
                break;
            }
            else
            {
                ans++;
                j++;
            }
        }

        return ans;
    }
}