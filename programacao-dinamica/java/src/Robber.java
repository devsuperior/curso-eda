import java.util.Arrays;

public class Robber {

    // Método principal para calcular o máximo de dinheiro que pode ser roubado
    public static int rob(int[] nums) {
        // Array de memoização
        int[] memo = new int[nums.length + 1];
        // Inicializa o array com -1 para indicar que os valores não foram calculados
        Arrays.fill(memo, -1);

        // Chamada da função util para obter o máximo de dinheiro roubado
        return robUtil(nums, nums.length - 1, memo);
    }

    // Função util para calcular o máximo de dinheiro roubado
    private static int robUtil(int[] nums, int i, int[] memo) {
        // Caso base: se i for negativo, o máximo de dinheiro roubado é 0
        if (i < 0) {
            return 0;
        }

        // Se o valor já foi calculado anteriormente, retorna-o
        if (memo[i] != -1) {
            return memo[i];
        }

        // Calcula o máximo de dinheiro roubado considerando as casas i-2 e i-1
        int result = Math.max(robUtil(nums, i - 2, memo) + nums[i], robUtil(nums, i - 1, memo));
        memo[i] = result;

        return result;
    }

    // Método main para testar os casos de teste
    public static void main(String[] args) {
        // Casos de teste
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1));

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums2));
    }
}
