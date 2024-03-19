public class dot_product {

    public static int dotProduct(int[] nums1, int[] nums2) {
        int product = 0;
        for (int i = 0; i < nums1.length; i++) {
            product += nums1[i] * nums2[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0, 2, 3};
        int[] nums2 = {0, 3, 0, 4, 0};
        System.out.println(dotProduct(nums1, nums2)); // = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

        int[] nums3 = {0, 1, 0, 0, 0};
        int[] nums4 = {0, 0, 0, 0, 2};
        System.out.println(dotProduct(nums3, nums4)); // = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

        int[] nums5 = {0, 1, 0, 0, 2, 0, 0};
        int[] nums6 = {1, 0, 0, 0, 3, 0, 4};
        System.out.println(dotProduct(nums5, nums6)); // = 0*1 + 1*0 + 0*0 + 0*0 + 2*3 + 0*0 + 0*4
    }
    
}
