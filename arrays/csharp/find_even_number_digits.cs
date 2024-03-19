using System;

public class find_even_number_digits {

    static int FindNumbers(int[] nums) {
        int countEvenNumber = 0;
        foreach (int value in nums)
        {
            int numDigits = value.ToString().Length;
            if (numDigits % 2 == 0)
            {
                countEvenNumber++;
            }
        }
        return countEvenNumber;
    }

    static void Main() {
        Console.WriteLine(FindNumbers(new int[] { 12, 345, 2, 6, 7896 }));  // 2
        Console.WriteLine(FindNumbers(new int[] { 555, 901, 482, 1771 }));  // 1
    }
}