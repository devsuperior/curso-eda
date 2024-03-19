using System;
using System.Linq;

class sorted_square
{
    static int[] SortedSquares(int[] nums) {
        int[] result = new int[nums.Length];

        for (int i = 0; i < nums.Length; i++) {
            result[i] = (int) Math.Pow(nums[i], 2);
        }

        Array.Sort(result);
        return result;
    }

    static void Main() {
        Console.WriteLine(string.Join(", ", SortedSquares(new int[]{-4, -1, 0, 3, 10})));
        Console.WriteLine(string.Join(", ", SortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
