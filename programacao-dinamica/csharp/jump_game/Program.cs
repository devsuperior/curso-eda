using System;

public class Solution
{
    public static bool CanJump(int[] nums)
    {
        int n = nums.Length;
        int[] memo = new int[n];
        Array.Fill(memo, -1);
        memo[n - 1] = 1;  // 1 for GOOD
        
        bool CanJumpFromPosition(int position)
        {
            if (memo[position] != -1)
                return memo[position] == 1;
            
            int furthestJump = Math.Min(position + nums[position], n - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
            {
                if (CanJumpFromPosition(nextPosition))
                {
                    memo[position] = 1;  // 1 for GOOD
                    return true;
                }
            }
            
            memo[position] = 0;  // 0 for BAD
            return false;
        }
        
        return CanJumpFromPosition(0);
    }

    public static void Main()
    {
        // Casos de teste
        Console.WriteLine(CanJump(new int[] { 2, 3, 1, 1, 4 }));  // Saída esperada: True
        Console.WriteLine(CanJump(new int[] { 3, 2, 1, 0, 4 }));  // Saída esperada: False
    }
}
