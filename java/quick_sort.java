/**
 *  Problema: Quick Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(n log n)
 *  espaço: O(1)
 */

public class quick_sort {

    public static int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
        return nums;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, j, i);
                i += 1;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        int[] nums = {20, 9, 86, -2, 16};
        for (int num : quickSort(nums, 0, 4)) System.out.print(num + " ");
        System.out.println();

        int[] nums1 = {30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4};
        for (int num : quickSort(nums1, 0, 10)) System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {1, 1, 1, 2, 2, 4, 8, 8, 16, 32};
        for (int num : quickSort(nums2, 0, 9)) System.out.print(num + " ");
        System.out.println();
    }

}
