using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public int MinimumCoins(int n, List<int> heads, int m, List<int> knights)
    {
        heads.Sort();
        knights.Sort();

        int k = 0, coins = 0;
        bool saved = true;
        for (int i = 0; i < n; i++)
        {
            // Select knight k to chop head i
            while (k < m && knights[k] < heads[i])
            {
                k++;
            }

            // If there are not enough knights left, Loowater is doomed
            if (k == m)
            {
                saved = false;
                break;
            }

            coins += knights[k];
            k++;
        }

        return saved ? coins : -1;
    }
}

public class Program
{
    public static void Main()
    {
        while (true)
        {
            string input = Console.ReadLine();
            if (string.IsNullOrEmpty(input)) break;

            var parts = input.Split(' ').Select(int.Parse).ToArray();
            int n = parts[0], m = parts[1];
            if (n == 0 && m == 0) break;

            List<int> heads = new List<int>();
            List<int> knights = new List<int>();

            for (int i = 0; i < n; i++)
            {
                heads.Add(int.Parse(Console.ReadLine()));
            }
            for (int i = 0; i < m; i++)
            {
                knights.Add(int.Parse(Console.ReadLine()));
            }

            Solution solve = new Solution();
            int ans = solve.MinimumCoins(n, heads, m, knights);

            if (ans == -1)
                Console.WriteLine("Loowater is doomed!");
            else
                Console.WriteLine(ans);
        }
    }
}
