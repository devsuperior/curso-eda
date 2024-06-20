public class BinarySearch {
	
	public static void main(String[] args) {
        int[] v = {7, 13, 20, 25, 28, 31, 35, 39, 40, 45, 46, 48, 57, 59, 63, 71};
        System.out.println(binarySearch(39, v));
        System.out.println(binarySearch(46, v));
        System.out.println(binarySearch(22, v));
    }

    public static int binarySearch(int elem, int[] arr) {
        return binarySearchTailRecursive(elem, arr, 0, arr.length - 1);
    }

    private static int binarySearchTailRecursive(int elem, int[] arr, int start, int finish) {
        if (start > finish) {
            return -1;
        }
        int middle = start + (finish - start) / 2;
        if (elem == arr[middle]) {
            return middle;
        } else if (elem < arr[middle]) {
            return binarySearchTailRecursive(elem, arr, start, middle - 1);
        } else {
            return binarySearchTailRecursive(elem, arr, middle + 1, finish);
        }
    }
}
