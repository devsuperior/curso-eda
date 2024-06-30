import java.util.Arrays;

public class SelectionSort {
	public static <T extends Comparable<T>> T[] selectionSort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j].compareTo(nums[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    private static <T> void swap(T[] nums, int a, int b) {
        T aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        Integer[] array1 = {20, 9, 86, -2, 16};
        Integer[] array2 = {5, 4, 3, 2, 1};
        Integer[] array3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};

        System.out.println(Arrays.toString(selectionSort(array1)));
        System.out.println(Arrays.toString(selectionSort(array2)));
        System.out.println(Arrays.toString(selectionSort(array3)));
    }
}
