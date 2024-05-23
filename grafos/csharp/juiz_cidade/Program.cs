using System;
using System.Collections.Generic;

class Solution
{
    public static int FindJudge(int n, int[][] trust)
    {
        // Vetor para contar quantas pessoas confiam em cada pessoa
        int[] trustCount = new int[n + 1];
        // Vetor para verificar se uma pessoa confia em alguém
        bool[] trustsSomeone = new bool[n + 1];

        // Processa a lista de confiança
        foreach (var t in trust)
        {
            int a = t[0];
            int b = t[1];
            // Marca que a pessoa 'a' confia em alguém
            trustsSomeone[a] = true;
            // Incrementa o contador de confiança para a pessoa 'b'
            trustCount[b]++;
        }

        // Verifica cada pessoa para encontrar o juiz
        for (int i = 1; i <= n; i++)
        {
            // O juiz não confia em ninguém e todos (exceto ele mesmo) confiam nele
            if (trustCount[i] == n - 1 && !trustsSomeone[i])
            {
                return i;
            }
        }

        // Se não encontrar nenhum juiz, retorna -1
        return -1;
    }

    static void Main(string[] args)
    {
        // Exemplo 1
        int n = 2;
        int[][] trust = new int[][] { new int[] { 1, 2 } };
        Console.WriteLine(FindJudge(n, trust));

        // Exemplo 2
        n = 3;
        trust = new int[][] { new int[] { 1, 3 }, new int[] { 2, 3 } };
        Console.WriteLine(FindJudge(n, trust));

        // Exemplo 3
        n = 3;
        trust = new int[][] { new int[] { 1, 3 }, new int[] { 2, 3 }, new int[] { 3, 1 } };
        Console.WriteLine(FindJudge(n, trust));
    }
}
