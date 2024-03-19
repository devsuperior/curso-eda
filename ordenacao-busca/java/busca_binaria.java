/*
 *  Problema: Busca binária (Iterativa)
 * 
 *  n = number of elements array
 * 
 *  time: O(log n)
 *  space: O(n)
 */

public class busca_binaria {

    public static int buscaBinaria(int[] nums, int key) {
        int low = 0;
        int middle;
        int high = nums.length - 1;
        
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
        int nums[] = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key = 34;
        int result = buscaBinaria(nums, key); // 9
        
        System.out.println("Buscando elemento " + key + " no array " + printArray(nums) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key + " não encontrado no array");
        }

        int nums1[] = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        int key1 = 10;
        result = buscaBinaria(nums1, key1); // -1

        System.out.println("Buscando elemento " + key1 + " no array " + printArray(nums1) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key1 + " não encontrado no array");
        }

        int nums2[] = {-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431};
        int key2 = 11;
        result = buscaBinaria(nums2, key2); // 3

        System.out.println("Buscando elemento " + key2 + " no array " + printArray(nums2) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key2 + " não encontrado no array");
        }
    }
}