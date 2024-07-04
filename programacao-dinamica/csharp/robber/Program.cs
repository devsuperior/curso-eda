using System;

public class Solution
{
    public static int Rob(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return 0;
        }

        int n = nums.Length;
        if (n == 1)
        {
            return nums[0];
        }

        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.Max(nums[0], nums[1]);

        for (int i = 2; i < n; i++)
        {
            memo[i] = Math.Max(memo[i - 1], memo[i - 2] + nums[i]);
        }

        return memo[n - 1];
    }

    public static void Main()
    {
        // Casos de teste
        int[] nums1 = { 1, 2, 3, 1 };
        Console.WriteLine(Rob(nums1));  // Saída esperada: 4
        
        int[] nums2 = { 2, 7, 9, 3, 1 };
        Console.WriteLine(Rob(nums2));  // Saída esperada: 12
    }
}
