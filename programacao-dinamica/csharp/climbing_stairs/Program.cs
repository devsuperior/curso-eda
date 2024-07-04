using System;

public class Solution
{
    public static int ClimbStairs(int n)
    {
        int[] memo = new int[n + 1]; // Inicializa o array de memoização
        for (int i = 0; i <= n; i++)
        {
            memo[i] = -1;
        }
        
        return ClimbStairsUtil(n, memo); // Chama a função auxiliar
    }

    public static int ClimbStairsUtil(int n, int[] memo)
    {
        if (memo[n] != -1) // Se o valor já foi calculado, retorna o memo
        {
            return memo[n];
        }

        if (n == 0 || n == 1) // Casos base
        {
            return 1;
        }

        memo[n] = ClimbStairsUtil(n - 1, memo) + ClimbStairsUtil(n - 2, memo); // Calcula o valor e armazena no memo
        return memo[n];
    }

    public static void Main(string[] args)
    {
        // Caso de teste 1
        int n1 = 2;
        Console.WriteLine(ClimbStairs(n1)); // Saída esperada: 2

        // Caso de teste 2
        int n2 = 3;
        Console.WriteLine(ClimbStairs(n2)); // Saída esperada: 3

        // Caso de teste 3
        int n3 = 45;
        Console.WriteLine(ClimbStairs(n3)); // Saída esperada: 1836311903
    }
}
