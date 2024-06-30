import java.util.Arrays;

public class InsertionSort {
	public static <T extends Comparable<T>> T[] insertionSort(T[] array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            T aux = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(aux) > 0) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = aux;
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {20, 9, 86, -2, 16};
        Integer[] arr2 = {5, 4, 3, 2, 1};
        Integer[] arr3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};

        System.out.println(Arrays.toString(insertionSort(arr1)));
        System.out.println(Arrays.toString(insertionSort(arr2)));
        System.out.println(Arrays.toString(insertionSort(arr3)));
    }
}
