using System;

class dot_product {
    static int DotProduct(int[] nums1, int[] nums2) {
        int product = 0;
        for (int i = 0; i < nums1.Length; i++) {
            product += nums1[i] * nums2[i];
        }
        return product;
    }

    static void Main() {
        int[] nums1 = {1, 0, 0, 2, 3};
        int[] nums2 = {0, 3, 0, 4, 0};
        Console.WriteLine(DotProduct(nums1, nums2)); // = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

        int[] nums3 = {0, 1, 0, 0, 0};
        int[] nums4 = {0, 0, 0, 0, 2};
        Console.WriteLine(DotProduct(nums3, nums4)); // = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

        int[] nums5 = {0, 1, 0, 0, 2, 0, 0};
        int[] nums6 = {1, 0, 0, 0, 3, 0, 4};
        Console.WriteLine(DotProduct(nums5, nums6)); // = 0*1 + 1*0 + 0*0 + 0*0 + 2*3 + 0*0 + 0*4
    }
}
