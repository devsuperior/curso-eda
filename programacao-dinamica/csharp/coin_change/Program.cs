using System;

public class Solution
{
    public static int CoinChange(int[] coins, int amount)
    {
        int[] memo = new int[amount + 1];
        Array.Fill(memo, int.MaxValue);
        memo[0] = 0;

        for (int i = 1; i <= amount; i++)
        {
            foreach (int coin in coins)
            {
                if (i - coin >= 0)
                {
                    memo[i] = Math.Min(memo[i], memo[i - coin] + 1);
                }
            }
        }

        if (memo[amount] == int.MaxValue)
        {
            return -1;
        }

        return memo[amount];
    }

    public static void Main()
    {
        // Teste dos casos fornecidos
        Console.WriteLine(CoinChange(new int[] { 1, 2, 5 }, 11)); // Saída esperada: 3
        Console.WriteLine(CoinChange(new int[] { 2 }, 3));        // Saída esperada: -1
        Console.WriteLine(CoinChange(new int[] { 1, 2, 3, 7, 11 }, 10000)); // Saída esperada: 910
    }
}
