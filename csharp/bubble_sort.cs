 /**
 *  Problema: Bubble Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */
public class bubble_sort {

    public static int[] BubbleSort(int[] nums) {
        int N = nums.Length;
        for (int i = 0; i < N; i++) {
            bool swapped = false;
            for (int j = 0; j < N - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            // Caso nenhum elemento tenha sido trocado na passagem atual, então o array já está ordenado
            if (!swapped) {
                break;
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
        int[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        nums = BubbleSort(nums);
        foreach (int num in BubbleSort(nums)) Console.Write(num + " ");
        Console.WriteLine();

        int[] nums1 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        nums1 = BubbleSort(nums1);
        foreach (int num in BubbleSort(nums1)) Console.Write(num1 + " ");
    }


}