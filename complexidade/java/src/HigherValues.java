public class HigherValues {

	public static void main(String[] args) {
        int[] input = {7, 3, 8, 7, 5};
        int[] result = higherValues(input);
        
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] higherValues(int[] arr) {
        int[] newArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    newArray[i]++;
                }
            }
        }

        return newArray;
    }
}
