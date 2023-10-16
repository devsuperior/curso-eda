using System;

/**
 *  Problema: Busca Sequencial Ordenada
 *
 *  n = number of elements array
 *
 *  time: O(n)
 *  space: O(n)
 */

public class busca_seq_ordenada
{
    public static int buscaSequencialOrdenada(int[] nums, int key) {
        Array.Sort(nums);
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == key)
                return i;
            else
                if (key < nums[i])
                    return -1;
        }
        return -1;
    }
    
    public static void Main(string[] args)
    {
        int[] nums = {28, 6, -2, 9, 16, 20, 23, 8};
        int key = 20;
        int result = buscaSequencialOrdenada(nums, key);
        
        if (result > -1) {
            Console.WriteLine("Elemento encontrado na posicao " + result);
        } else {
            Console.WriteLine("Elemento " + key + " não encontrado no array");
        }
    }
}