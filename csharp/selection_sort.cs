 /**
 *  Problema: Selection Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */
public class selection_sort {

    public static int[] SelectionSort(int[] nums) {
        int N = nums.Length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                Swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    private static void Swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }


    static void Main() {
        int[] nums = {20, 9, 86, -2, 16};
        nums = SelectionSort(nums);
        foreach (int num in SelectionSort(nums)) Console.Write(num + " ");
        Console.WriteLine();

        int[] nums1 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        nums1 = SelectionSort(nums1);
        foreach (int num in SelectionSort(nums1)) Console.Write(num + " ");
    }


}