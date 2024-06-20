public class SequentialSearch {
	
	public static int sequentialSearch(int elem, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {15, 82, 79, 32, 41, 28};
        int result = sequentialSearch(32, array);
        System.out.println(result);
    }
}
