using System;

class merge {
    static void Merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Array.Sort(nums1);
    }

    static void Main() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Merge(nums1, 3, nums2, 3);
        Console.WriteLine(string.Join(", ", nums1));
    }
}
