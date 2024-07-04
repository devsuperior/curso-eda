using System;

public class Solution
{
    public static int MinCostClimbingStairs(int[] cost)
    {
        int n = cost.Length;
        int[] memo = new int[n + 1];
        Array.Fill(memo, -1);

        return MinCostClimbingStairsUtil(n, cost, memo);
    }

    public static int MinCostClimbingStairsUtil(int n, int[] cost, int[] memo)
    {
        if (n == 0 || n == 1)
            return 0;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = Math.Min(
            MinCostClimbingStairsUtil(n - 1, cost, memo) + cost[n - 1],
            MinCostClimbingStairsUtil(n - 2, cost, memo) + cost[n - 2]
        );

        return memo[n];
    }

    public static void Main()
    {
        // Casos de teste
        int[] cost1 = { 10, 15, 20 };
        Console.WriteLine(MinCostClimbingStairs(cost1));  // Saída esperada: 15

        int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        Console.WriteLine(MinCostClimbingStairs(cost2));  // Saída esperada: 6
    }
}
