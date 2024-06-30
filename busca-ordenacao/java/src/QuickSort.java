import java.util.Arrays;

public class QuickSort {

	public static <T extends Comparable<T>> T[] quickSort(T[] nums) {
        quickSortTailRecursive(nums, 0, nums.length - 1);
        return nums;
    }

    private static <T extends Comparable<T>> void quickSortTailRecursive(T[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSortTailRecursive(nums, left, pivot - 1);
            quickSortTailRecursive(nums, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] nums, int left, int right) {
        T pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j].compareTo(pivot) <= 0) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static <T extends Comparable<T>> void swap(T[] nums, int a, int b) {
        T aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    public static void main(String[] args) {
        Integer[] array1 = {20, 9, 86, -2, 16};
        Integer[] array2 = {30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4};
        Integer[] array3 = {1, 1, 1, 2, 2, 4, 8, 8, 16, 32};
        System.out.println(Arrays.toString(quickSort(array1)));
        System.out.println(Arrays.toString(quickSort(array2)));
        System.out.println(Arrays.toString(quickSort(array3)));
    }
}
