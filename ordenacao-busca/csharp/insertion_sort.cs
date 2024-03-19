 /**
 *  Problema: Insertion Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */
public class insertion_sort {

    public static int[] InsertionSort(int[] nums) {
        int N = nums.Length;
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

    static void Main() {
        int[] nums = {20, 9, 86, -2, 16};
        nums = InsertionSort(nums);
        foreach (int num in InsertionSort(nums)) Console.Write(num + " ");
        Console.WriteLine();

        int[] nums1 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        nums1 = InsertionSort(nums1);
        foreach (int num in InsertionSort(nums1)) Console.Write(num + " ");
    }
}