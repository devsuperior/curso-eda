using System;

/**
 *  n = number of elements array
 *
 *  time: O(n)
 *  space: O(n)
 */

public class busca_sequencial
{
    public static int buscaSequencial(int[] nums, int key) {
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == key)
                return i;
        }
        return -1;
    }
    
    public static void Main(string[] args)
    {
        int[] nums = {28, 6, -2, 9, 16, 20, 23, 8};
        int key = 20;
        int result = buscaSequencial(nums, key);
        
        if (result > -1) {
            Console.WriteLine("Elemento encontrado na posicao " + result);
        } else {
            Console.WriteLine("Elemento " + key + " não encontrado no array");
        }
    }
}