 /**
 *  Problema: Selection Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */

public class selection_sort {

    public static int[] selectionSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(nums, i, minIndex);
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        int[] nums = {20, 9, 86, -2, 16};
        for (int num : selectionSort(nums)) System.out.print(num + " ");
        System.out.println();

        int[] nums1 = {5, 4, 3, 2, 1};
        for (int num : selectionSort(nums1)) System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        for (int num : selectionSort(nums2)) System.out.print(num + " ");
        System.out.println();
    }
}
