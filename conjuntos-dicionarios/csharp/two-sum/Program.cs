using System;
using System.Collections.Generic;

public class Program
{
    public static int[] twoSum(int[] nums, int target)
    {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int[] result = new int[2];

        for (int i = 0; i < nums.Length; i++)
        {
            int remainder = target - nums[i];
            if (dict.ContainsKey(remainder))
            {
                int index = dict[remainder];
                result[0] = index;
                result[1] = i;
                return result;
            }
            dict[nums[i]] = i;
        }

        return result;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine($"[{string.Join(", ", twoSum(new int[] { 2, 7, 11, 15 }, 9))}]");
        Console.WriteLine($"[{string.Join(", ", twoSum(new int[] { 3, 2, 4 }, 6))}]");
        Console.WriteLine($"[{string.Join(", ", twoSum(new int[] { 3, 5, 7, 2, 4, 8, 1, 6 }, 15))}]");
    }
}
