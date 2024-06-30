using System;

public class Program
{
    public static int SequentialSearch<T>(T[] array, T chave) where T : IComparable
    {
        for (int i = 0; i < array.Length; i++)
        {
            if (array[i].CompareTo(chave) == 0)
                return i;
        }
        return -1;
    }

    public static void Main(string[] args)
    {
        int[] numeros = { 28, 6, -2, 9, 16, 20, 23, 8 };
        Console.WriteLine(SequentialSearch(numeros, 20)); // 5

        int[] outrosNumeros = { 4, 6, -3, 21, 55, 91, 2 };
        Console.WriteLine(SequentialSearch(outrosNumeros, 11)); // -1
    }
}
