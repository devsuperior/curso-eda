import java.util.Arrays;

public class MergeSort {
	public static <T extends Comparable<T>> T[] mergeSort(T[] nums) {
		mergeSortTailRecursive(nums, 0, nums.length - 1);
		return nums;
	}

	private static <T extends Comparable<T>> void mergeSortTailRecursive(T[] nums, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSortTailRecursive(nums, left, middle);
			mergeSortTailRecursive(nums, middle + 1, right);
			merge(nums, left, middle, right);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] nums, int left, int middle, int right) {
		Object[] result = new Object[right - left + 1];
		int i = left;
		int j = middle + 1;
		int k = 0;

		while (i <= middle && j <= right) {
			if (nums[i].compareTo(nums[j]) < 0) {
				result[k++] = nums[i++];
			} else {
				result[k++] = nums[j++];
			}
		}

		while (i <= middle) {
			result[k++] = nums[i++];
		}

		while (j <= right) {
			result[k++] = nums[j++];
		}

		for (i = 0; i < result.length; i++) {
			nums[left + i] = (T) result[i];
		}
	}

	public static void main(String[] args) {
		Integer[] nums1 = { 20, 9, 86, -2, 16 };
		Integer[] nums2 = { 30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4 };
		Integer[] nums3 = { 1, 1, 1, 2, 2, 4, 8, 8, 16, 32 };

		System.out.println(Arrays.toString(mergeSort(nums1)));
		System.out.println(Arrays.toString(mergeSort(nums2)));
		System.out.println(Arrays.toString(mergeSort(nums3)));
	}
}
