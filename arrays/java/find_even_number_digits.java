public class find_even_number_digits {

    public static int findNumbers(int[] nums) {
        int countEvenNumber = 0;
        for (int value : nums) {
            int numDigits = String.valueOf(value).length();
            if (numDigits % 2 == 0) {
                countEvenNumber++;
            }
        }
        return countEvenNumber;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));  // 2
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));  // 1
    }
}
