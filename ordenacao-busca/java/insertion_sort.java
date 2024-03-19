/**
 *  Problema: Insertion Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */

public class insertion_sort {

    public static int[] insertionSort(int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            int aux = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > aux) {
                nums[j + 1] = nums[j];
                j -= 1;
            }
            nums[j + 1] = aux; 
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {20, 9, 86, -2, 16};
        for (int num : insertionSort(nums)) System.out.print(num + " ");
        System.out.println();

        int[] nums1 = {5, 4, 3, 2, 1};
        for (int num : insertionSort(nums1)) System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        for (int num : insertionSort(nums2)) System.out.print(num + " ");
        System.out.println();
    }
}
