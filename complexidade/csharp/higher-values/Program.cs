using System;

public class Program
{
    public static void Main()
    {
        int[] input = {7, 3, 8, 7, 5};
        int[] result = HigherValues(input);
        
        foreach (int value in result) {
            Console.WriteLine(value);
        }
    }

    public static int[] HigherValues(int[] arr) {
        int[] newArray = new int[arr.Length];

        for (int i = 0; i < arr.Length; i++) {
            for (int j = 0; j < arr.Length; j++) {
                if (arr[j] > arr[i]) {
                    newArray[i]++;
                }
            }
        }

        return newArray;
    }
}
