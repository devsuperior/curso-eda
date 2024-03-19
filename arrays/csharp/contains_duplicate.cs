using System;

class contains_duplicate {
    static bool ContainsDuplicate(int[] nums) {
        bool isDuplicate = false;
        for (int i = 0; i < nums.Length - 1; i++) {
            for (int j = i + 1; j < nums.Length; j++) {
                if (nums[i] == nums[j]) {
                    return !isDuplicate;
                }
            }
        }
        return isDuplicate;
    }

    static void Main() {
        int[] nums1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        Console.WriteLine($"Array [{string.Join(", ", nums1)}] contém valores duplicados? {ContainsDuplicate(nums1)}");

        int[] nums2 = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        Console.WriteLine($"Array [{string.Join(", ", nums2)}] contém valores duplicados? {ContainsDuplicate(nums2)}");
    }
}
