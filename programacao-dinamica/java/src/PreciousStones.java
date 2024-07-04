import java.util.Arrays;

public class PreciousStones {

    // Função principal para calcular o lucro máximo
    public static int maxProfit(int n, int[] values) {
        // Array de memoização
        int[] memo = new int[n + 1];
        // Inicializa o array com -1 para indicar que os valores não foram calculados
        Arrays.fill(memo, -1);

        // Chamada da função util para obter o lucro máximo
        return util(n, values, memo);
    }

    // Função util para calcular o lucro máximo
    private static int util(int n, int[] values, int[] memo) {
        // Caso base: se n for 0, o lucro máximo é 0
        if (n == 0) {
            return 0;
        }

        // Se o valor já foi calculado anteriormente, retorna-o
        if (memo[n] != -1) {
            return memo[n];
        }

        // Inicializa memo[n] com 0
        memo[n] = 0;

        // Itera de 1 até n para encontrar o lucro máximo
        for (int i = 1; i <= n; i++) {
            // Se for possível cortar a barra de tamanho i
            if (n - i >= 0) {
                // Atualiza memo[n] com o lucro máximo encontrado
                memo[n] = Math.max(memo[n], util(n - i, values, memo) + values[i - 1]);
            }
        }

        // Retorna o lucro máximo calculado para o tamanho n
        return memo[n];
    }

    // Método main para testar os casos de teste
    public static void main(String[] args) {
        // Casos de teste
        int n1 = 4;
        int[] values1 = {2, 5, 7, 9};
        System.out.println(maxProfit(n1, values1));

        int n2 = 8;
        int[] values2 = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(n2, values2));

        int n3 = 8;
        int[] values3 = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(n3, values3));
    }
}
