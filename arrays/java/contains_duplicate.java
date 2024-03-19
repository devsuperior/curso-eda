import java.util.Arrays;

public class contains_duplicate {

    public static boolean containsDuplicate(int[] nums) {
        boolean isDuplicate = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return !isDuplicate;
                }
            }
        }
        return isDuplicate;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Array " + Arrays.toString(nums1) + " contém valores duplicados? " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        System.out.println("Array " + Arrays.toString(nums2) + " contém valores duplicados? " + containsDuplicate(nums2));
    }
}
