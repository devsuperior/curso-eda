using System;

public class Program
{
    public static int BinarySearch<T>(T[] nums, T key) where T : IComparable<T>
    {
        return BinarySearchTailRecursive(nums, key, 0, nums.Length - 1);
    }

    private static int BinarySearchTailRecursive<T>(T[] nums, T key, int low, int high) where T : IComparable<T>
    {
        if (low > high)
        {
            return -1;
        }

        int middle = low + (high - low) / 2;
        int cmp = key.CompareTo(nums[middle]);
        if (cmp == 0)
        {
            return middle;
        }
        else if (cmp < 0)
        {
            return BinarySearchTailRecursive(nums, key, low, middle - 1);
        }
        else
        {
            return BinarySearchTailRecursive(nums, key, middle + 1, high);
        }
    }

    static void Main(string[] args)
    {
        int[] nums = { -5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38 };
        Console.WriteLine(BinarySearch(nums, 34)); // 9
        Console.WriteLine(BinarySearch(nums, 10)); // -1
        int[] nums2 = { -10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431 };
        Console.WriteLine(BinarySearch(nums2, 11)); // 3
    }
}
