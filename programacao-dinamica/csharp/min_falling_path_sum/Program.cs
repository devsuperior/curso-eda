using System;

public class Solution
{
    public static int MinFallingPathSum(int[][] matrix)
    {
        int n = matrix.Length;
        int INF = int.MaxValue;

        // Criando a matriz de memoização e inicializando a primeira linha
        int[][] memo = new int[n][];
        for (int i = 0; i < n; i++)
        {
            memo[i] = new int[n];
            for (int j = 0; j < n; j++)
            {
                memo[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++)
        {
            memo[0][j] = matrix[0][j];
        }

        // Preenchendo a matriz usando programação dinâmica
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int path_a = INF, path_b = INF, path_c = INF;
                if (IsValid(i - 1, j - 1, n))
                {
                    path_a = matrix[i][j] + memo[i - 1][j - 1];
                }
                if (IsValid(i - 1, j + 1, n))
                {
                    path_b = matrix[i][j] + memo[i - 1][j + 1];
                }
                if (IsValid(i - 1, j, n))
                {
                    path_c = matrix[i][j] + memo[i - 1][j];
                }

                memo[i][j] = Math.Min(Math.Min(path_a, path_b), path_c);
            }
        }

        // Encontrando o mínimo na última linha
        int ans = INF;
        for (int j = 0; j < n; j++)
        {
            ans = Math.Min(ans, memo[n - 1][j]);
        }

        return ans;
    }

    // Função para verificar se as coordenadas são válidas
    public static bool IsValid(int i, int j, int n)
    {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void Main()
    {
        // Testes dos casos fornecidos
        int[][] matrix1 = { new int[] { 2, 1, 3 }, new int[] { 6, 5, 4 }, new int[] { 7, 8, 9 } };
        Console.WriteLine(MinFallingPathSum(matrix1));  // Saída esperada: 13

        int[][] matrix2 = { new int[] { -19, 57 }, new int[] { -40, -5 } };
        Console.WriteLine(MinFallingPathSum(matrix2));  // Saída esperada: -59
    }
}
