/*
 *  Problema: Busca Sequencial
 * 
 *  n = number of elements array
 * 
 *  time: O(n)
 *  space: O(n)
 */

public class busca_sequencial {

    public static int buscaSequencial(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                return i;
        }
        return -1;
    }

    private static String printArray(int nums[]) {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < nums.length - 1; i++) {
            s.append(nums[i]);
            s.append(", ");
        }
        s.append(nums[nums.length -1]);
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        int nums[] = {28, 6, -2, 9, 16, 20, 23, 8};
        int key = 20;
        int result = buscaSequencial(nums, key);
        
        System.out.println("Buscando elemento " + key + " no array " + printArray(nums) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key + " não encontrado no array");
        }

        int nums1[] = {4, 6, -3, 21, 55, 91, 2};
        int key1 = 11;
        result = buscaSequencial(nums1, key1);

        System.out.println("Buscando elemento " + key1 + " no array " + printArray(nums1) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key1 + " não encontrado no array");
        }
    }
}