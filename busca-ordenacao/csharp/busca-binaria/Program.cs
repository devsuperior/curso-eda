using System;

public class Program
{
    public static int BinarySearch<T>(T[] nums, T key) where T : IComparable
    {
        int low = 0;
        int middle;
        int high = nums.Length - 1;

        while (low <= high)
        {
            middle = (low + high) / 2;
            if (key.CompareTo(nums[middle]) < 0)
                high = middle - 1;
            else if (key.CompareTo(nums[middle]) > 0)
                low = middle + 1;
            else
                return middle;
        }

        return -1;
    }

    public static void Main()
    {
        int[] nums = { -5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38 };
        Console.WriteLine(BinarySearch(nums, 34));  // 9
        Console.WriteLine(BinarySearch(nums, 10));  // -1
        int[] nums2 = { -10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431 };
        Console.WriteLine(BinarySearch(nums2, 11)); // 3
    }
}
