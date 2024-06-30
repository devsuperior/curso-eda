public class BuscaBinariaRecursiva {

	public static <T extends Comparable<T>> int binarySearch(T[] nums, T key) {
        return binarySearchTailRecursive(nums, key, 0, nums.length - 1);
    }

    private static <T extends Comparable<T>> int binarySearchTailRecursive(T[] nums, T key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        int cmp = key.compareTo(nums[middle]);
        if (cmp == 0) {
            return middle;
        } else if (cmp < 0) {
            return binarySearchTailRecursive(nums, key, low, middle - 1);
        } else {
            return binarySearchTailRecursive(nums, key, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(binarySearch(nums, 34)); // 9
        System.out.println(binarySearch(nums, 10)); // -1
        Integer[] nums2 = {-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431};
        System.out.println(binarySearch(nums2, 11)); // 3
    }
}
