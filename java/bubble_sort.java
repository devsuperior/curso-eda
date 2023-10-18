 /**
 *  Problema: Bubble Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */

public class bubble_sort {

    public static int[] bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            boolean swapped = false;
            for (int j = 0; j < N - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
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

    private static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        int[] nums = {23, 4, 67, -8, 21};
        for (int num : bubbleSort(nums)) System.out.print(num + " ");
        System.out.println();

        int[] nums1 = {5, 4, 3, 2, 1};
        for (int num : bubbleSort(nums1)) System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        for (int num : bubbleSort(nums2)) System.out.print(num + " ");
        System.out.println();
    }
    
}
