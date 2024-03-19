using System;

class max_consecutive_ones {
    static int FindMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int countOnes = 0;
        
        foreach (int value in nums) {
            if (value == 1) {
                countOnes++;
            }

            if (value != 1 && countOnes > 0) {
                maxOnes = Math.Max(maxOnes, countOnes);
                countOnes = 0;
            }
        }

        maxOnes = Math.Max(maxOnes, countOnes);
        return maxOnes;
    }

    static void Main() {
        Console.WriteLine(FindMaxConsecutiveOnes(new int[] {1,1,0,1,1,1,0,1,1,1,1}));  // 4
        Console.WriteLine(FindMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));  // 2
    }
}
