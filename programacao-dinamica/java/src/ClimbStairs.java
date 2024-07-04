import java.util.Arrays;

public class ClimbStairs {
    /**
     * Retorna o número de maneiras diferentes de subir n degraus.
     * @param n O número de degraus a subir
     * @return O número de maneiras diferentes de subir os degraus
     */
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsUtil(n, memo);
    }

    /**
     * Função auxiliar para calcular o número de maneiras de subir os degraus utilizando memoização.
     * @param n O número de degraus a subir
     * @param memo Array de memoização para armazenar resultados intermediários
     * @return O número de maneiras diferentes de subir os degraus
     */
    private static int climbStairsUtil(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        memo[n] = climbStairsUtil(n - 1, memo) + climbStairsUtil(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        // Caso de teste 1
        int n1 = 2;
        System.out.println(climbStairs(n1));

        // Caso de teste 2
        int n2 = 3;
        System.out.println(climbStairs(n2));

        // Caso de teste 3
        int n3 = 45;
        System.out.println(climbStairs(n3));
    }
}
