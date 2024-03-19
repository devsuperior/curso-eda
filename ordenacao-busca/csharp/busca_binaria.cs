using System;

/*
 *  Problema: Busca binária (Iterativa)
 * 
 *  n = number of elements array
 * 
 *  time: O(log n)
 *  space: O(n)
 */

public class busca_binaria {

    public static int BuscaBinaria(int[] nums, int key) {
        int low = 0;
        int middle;
        int high = nums.Length - 1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (key < nums[middle])
                high = middle - 1;
            else if (key > nums[middle])
                low = middle + 1;
            else
                return middle;
        }

        return -1;
    }

    static void Main() {
        int[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key = 34;
        Console.WriteLine(BuscaBinaria(nums, key));
        
        int[] nums1 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key1 = 10;
        Console.WriteLine(BuscaBinaria(nums1, key1));
    }
    
}