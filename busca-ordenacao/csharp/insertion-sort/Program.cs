using System;

public class Program
{
    public static T[] InsertionSort<T>(T[] array) where T : IComparable
    {
        int N = array.Length;
        for (int i = 1; i < N; i++)
        {
            T aux = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].CompareTo(aux) > 0)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
        return array;
    }

    public static void Main()
    {
        int[] arr1 = { 20, 9, 86, -2, 16 };
        int[] arr2 = { 5, 4, 3, 2, 1 };
        int[] arr3 = { -5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38 };

        Console.WriteLine(String.Join(", ", InsertionSort(arr1)));
        Console.WriteLine(String.Join(", ", InsertionSort(arr2)));
        Console.WriteLine(String.Join(", ", InsertionSort(arr3)));
    }
}
