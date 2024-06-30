using System;

public class Program
{
    public static T[] SelectionSort<T>(T[] array) where T : IComparable
    {
        for (int i = 0; i < array.Length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < array.Length; j++)
            {
                if (array[j].CompareTo(array[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            if (minIndex != i)
            {
                Swap(ref array[i], ref array[minIndex]);
            }
        }
        return array;
    }

    private static void Swap<T>(ref T a, ref T b)
    {
        T temp = a;
        a = b;
        b = temp;
    }

    public static void Main(string[] args)
    {
        int[] array1 = { 20, 9, 86, -2, 16 };
        int[] array2 = { 5, 4, 3, 2, 1 };
        int[] array3 = { -5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38 };

        Console.WriteLine(String.Join(", ", SelectionSort(array1)));
        Console.WriteLine(String.Join(", ", SelectionSort(array2)));
        Console.WriteLine(String.Join(", ", SelectionSort(array3)));
    }
}
