using System;

/*
 *  Problema: Busca binária (Iterativa)
 * 
 *  n = number of elements array
 * 
 *  time: O(log n)
 *  space: O(n)
 */

public class busca_binaria_recursiva {

    public static int BuscaBinaria(int[] nums, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (key == nums[middle]) {
            return middle;
        }
        else if (key < nums[middle]) {
            return BuscaBinaria(nums, key, low, middle - 1);
        }
        else {
            return BuscaBinaria(nums, key, middle + 1, high);
        }
    }

    static void Main() {
        int[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key = 34;
        Console.WriteLine(BuscaBinaria(nums, key, 0, nums.Length));
        
        int[] nums1 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key1 = 10;
        Console.WriteLine(BuscaBinaria(nums1, key1, 0, nums1.Length));
    }
    
}