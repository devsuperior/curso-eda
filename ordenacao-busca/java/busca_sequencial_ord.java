import java.util.Arrays;

/*
 *  Problema: Busca Sequencial Ordenada
 * 
 *  n = number of elements array
 * 
 *  time: O(n)
 *  space: O(n)
 */

public class busca_sequencial_ord {

    public static int buscaSequencialOrdenada(int[] nums, int key) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                return i;
            else
                if (key < nums[i])
                    return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {28, 6, -2, 9, 16, 20, 23, 8};
        int key = 20;
        int result = buscaSequencialOrdenada(nums, key);
        
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key + " não encontrado no array");
        }

        int nums1[] = {4, 6, -3, 21, 55, 91, 2};
        int key1 = 11;
        result = buscaSequencialOrdenada(nums1, key1);

        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key1 + " não encontrado no array");
        }
    }
}