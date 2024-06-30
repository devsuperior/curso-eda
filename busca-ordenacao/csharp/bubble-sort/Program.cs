using System;

public class Program
{
    public static T[] BubbleSort<T>(T[] nums) where T : IComparable
    {
        int N = nums.Length;
        for (int i = 0; i < N; i++)
        {
            bool swapped = false;
            for (int j = 0; j < N - 1 - i; j++)
            {
                if (nums[j].CompareTo(nums[j + 1]) > 0)
                {
                    T temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
        }
        return nums;
    }

    public static void Main()
    {
        int[] nums = { 20, 9, 86, -2, 16 };
        int[] nums2 = { 5, 4, 3, 2, 1 };
        int[] nums3 = { -5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38 };

        Console.WriteLine(String.Join(", ", BubbleSort(nums)));
        Console.WriteLine(String.Join(", ", BubbleSort(nums2)));
        Console.WriteLine(String.Join(", ", BubbleSort(nums3)));
    }
}
