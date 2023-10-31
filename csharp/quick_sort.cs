 /**
 *  Problema: Quick Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(n log n)
 *  espaço: O(1)
 */
public class quick_sort {

    public static int[] QuickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = Partition(nums, left, right);
            QuickSort(nums, left, pivot - 1);
            QuickSort(nums, pivot + 1, right);
        }
        return nums;
    }

    private static int Partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                Swap(nums, j, i);
                i += 1;
            }
        }
        Swap(nums, i, right);
        return i;
    }

    private static void Swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }


    static void Main() {
        int[] nums = {20, 9, 86, -2, 16};
        nums = QuickSort(nums, 0, 4);
        foreach (int num in QuickSort(nums, 0, 4)) Console.Write(num + " ");
        Console.WriteLine();

        int[] nums1 = {30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4};
        nums1 = QuickSort(nums1, 0, 10);
        foreach (int num in QuickSort(nums1, 0, 10)) Console.Write(num + " ");
    }


}