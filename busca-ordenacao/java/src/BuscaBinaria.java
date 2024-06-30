public class BuscaBinaria {
	public static <T extends Comparable<T>> int binarySearch(T[] nums, T key) {
        int low = 0;
        int middle;
        int high = nums.length - 1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (key.compareTo(nums[middle]) < 0)
                high = middle - 1;
            else if (key.compareTo(nums[middle]) > 0)
                low = middle + 1;
            else
                return middle;
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(binarySearch(nums, 34));  // 9
        System.out.println(binarySearch(nums, 10));  // -1
        Integer[] nums2 = {-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431};
        System.out.println(binarySearch(nums2, 11)); // 3
    }
}
