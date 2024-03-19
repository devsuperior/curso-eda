/*
 *  Problema: Busca binária (Recursiva)
 * 
 *  n = number of elements array
 * 
 *  time: O(log n)
 *  space: O(n)
 */

public class busca_binaria_recursiva {

    public static int buscaBinaria(int[] nums, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (key == nums[middle]) {
            return middle;
        }
        else if (key < nums[middle]) {
            return buscaBinaria(nums, key, low, middle - 1);
        }
        else {
            return buscaBinaria(nums, key, middle + 1, high);
        }
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
        int result = buscaBinaria(nums, key, 0, nums.length); // 9
        
        System.out.println("Buscando elemento " + key + " no array " + printArray(nums) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key + " não encontrado no array");
        }

        int key1 = 10;
        result = buscaBinaria(nums, key1, 0, nums.length); // -1

        System.out.println("Buscando elemento " + key1 + " no array " + printArray(nums) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key1 + " não encontrado no array");
        }

        int nums2[] = {-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431};
        int key2 = 11;
        result = buscaBinaria(nums2, key2, 0, nums2.length); // 3

        System.out.println("Buscando elemento " + key2 + " no array " + printArray(nums2) + " ...");
        if (result > -1) {
            System.out.println("Elemento encontrado na posicao " + result);
        } else {
            System.out.println("Elemento " + key2 + " não encontrado no array");
        }
    }
    
}
