using System;

public class Solution
{
    public static int MinPathSum(int[][] grid)
    {
        int n = grid.Length;
        int m = grid[0].Length;

        // Criando matriz de memoização e inicializando com 0
        int[][] memo = new int[n][];
        for (int i = 0; i < n; i++)
        {
            memo[i] = new int[m];
        }

        memo[0][0] = grid[0][0];

        // Inicializando primeira coluna
        for (int i = 1; i < n; i++)
        {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }

        // Inicializando primeira linha
        for (int j = 1; j < m; j++)
        {
            memo[0][j] = memo[0][j - 1] + grid[0][j];
        }

        // Aplicando tabulação
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                memo[i][j] = Math.Min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }

        return memo[n - 1][m - 1];
    }

    public static void Main()
    {
        // Casos de teste
        int[][] grid1 = { new int[] { 1, 3, 1 }, new int[] { 1, 5, 1 }, new int[] { 4, 2, 1 } };
        Console.WriteLine(MinPathSum(grid1));  // Saída esperada: 7

        int[][] grid2 = { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } };
        Console.WriteLine(MinPathSum(grid2));  // Saída esperada: 12
    }
}
