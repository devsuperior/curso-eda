using System;

public class Program
{

    public static T[] MergeSort<T>(T[] nums) where T : IComparable
    {
        MergeSortTailRecursive(nums, 0, nums.Length - 1);
        return nums;
    }

    private static void MergeSortTailRecursive<T>(T[] nums, int left, int right) where T : IComparable
    {
        if (left < right)
        {
            int middle = (left + right) / 2;
            MergeSortTailRecursive(nums, left, middle);
            MergeSortTailRecursive(nums, middle + 1, right);
            Merge(nums, left, middle, right);
        }
    }

    private static void Merge<T>(T[] nums, int left, int middle, int right) where T : IComparable
    {
        T[] result = new T[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right)
        {
            if (nums[i].CompareTo(nums[j]) < 0)
            {
                result[k++] = nums[i++];
            }
            else
            {
                result[k++] = nums[j++];
            }
        }

        while (i <= middle)
        {
            result[k++] = nums[i++];
        }

        while (j <= right)
        {
            result[k++] = nums[j++];
        }

        for (i = 0; i < result.Length; i++)
        {
            nums[left + i] = result[i];
        }
    }

    public static void Main()
    {
        int[] nums1 = { 20, 9, 86, -2, 16 };
        int[] nums2 = { 30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4 };
        int[] nums3 = { 1, 1, 1, 2, 2, 4, 8, 8, 16, 32 };

        Console.WriteLine(String.Join(", ", MergeSort(nums1)));
        Console.WriteLine(String.Join(", ", MergeSort(nums2)));
        Console.WriteLine(String.Join(", ", MergeSort(nums3)));
    }
}
