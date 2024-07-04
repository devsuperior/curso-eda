using System;

public class Solution
{
    public static int MinCostFrog(int[] heights)
    {
        int n = heights.Length;
        int[] memo = new int[n];
        Array.Fill(memo, -1);

        int Solve(int ind)
        {
            if (ind >= n)
                return int.MaxValue;
            if (ind == n - 1)
                return 0;
            if (memo[ind] != -1)
                return memo[ind];

            int jump1Cost = (ind + 1 < n) ? Solve(ind + 1) + Math.Abs(heights[ind] - heights[ind + 1]) : int.MaxValue;
            int jump2Cost = (ind + 2 < n) ? Solve(ind + 2) + Math.Abs(heights[ind] - heights[ind + 2]) : int.MaxValue;

            memo[ind] = Math.Min(jump1Cost, jump2Cost);
            return memo[ind];
        }

        return Solve(0);
    }

    public static void Main()
    {
        // Teste dos casos fornecidos
        Console.WriteLine(MinCostFrog(new int[] { 10, 30, 40, 20 }));   // Saída esperada: 30
        Console.WriteLine(MinCostFrog(new int[] { 10, 10 }));          // Saída esperada: 0
        Console.WriteLine(MinCostFrog(new int[] { 30, 10, 60, 10, 60, 50 }));   // Saída esperada: 40
    }
}
