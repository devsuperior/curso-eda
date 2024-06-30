import java.util.Arrays;

public class BubbleSort {
	public static <T extends Comparable<T>> T[] bubbleSort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            boolean swapped = false;
            for (int j = 0; j < N - 1 - i; j++) {
                if (nums[j].compareTo(nums[j + 1]) > 0) {
                    T temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Integer[] nums = {20, 9, 86, -2, 16};
        System.out.println(Arrays.toString(bubbleSort(nums)));

        Integer[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort(nums2)));

        Integer[] nums3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(Arrays.toString(bubbleSort(nums3)));
    }
}
