using System;

public class Program
{

    public static T[] QuickSort<T>(T[] nums) where T : IComparable
    {
        QuickSortTailRecursive(nums, 0, nums.Length - 1);
        return nums;
    }

    private static void QuickSortTailRecursive<T>(T[] nums, int left, int right) where T : IComparable
    {
        if (left < right)
        {
            int pivot = Partition(nums, left, right);
            QuickSortTailRecursive(nums, left, pivot - 1);
            QuickSortTailRecursive(nums, pivot + 1, right);
        }
    }

    private static int Partition<T>(T[] nums, int left, int right) where T : IComparable
    {
        T pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++)
        {
            if (nums[j].CompareTo(pivot) <= 0)
            {
                Swap(nums, j, i);
                i++;
            }
        }
        Swap(nums, i, right);
        return i;
    }

    private static void Swap<T>(T[] nums, int a, int b) where T : IComparable
    {
        T aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void Main()
    {
        int[] array1 = { 20, 9, 86, -2, 16 };
        int[] array2 = { 30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4 };
        int[] array3 = { 1, 1, 1, 2, 2, 4, 8, 8, 16, 32 };
        
        Console.WriteLine(String.Join(", ", QuickSort(array1)));
        Console.WriteLine(String.Join(", ", QuickSort(array2)));
        Console.WriteLine(String.Join(", ", QuickSort(array3)));
    }
}
