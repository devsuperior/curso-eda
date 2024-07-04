import java.util.Arrays;

public class MaxProfit {

    // Método para calcular o lucro máximo que pode ser obtido ao dividir um bloco bruto de N gramas em gemas
    public static int maxProfit(int n, int[] values) {
        // Cria um array memo de tamanho n+1 e inicializa com -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        // Chama a função util para obter o valor máximo
        return util(n, values, memo);
    }

    // Função auxiliar util para calcular o valor máximo
    private static int util(int n, int[] values, int[] memo) {
        // Caso base: se n for 0, o valor máximo é 0
        if (n == 0) {
            return 0;
        }

        // Se o valor já foi calculado anteriormente, retorna-o
        if (memo[n] != -1) {
            return memo[n];
        }

        // Inicializa memo[n] com 0
        memo[n] = 0;

        // Itera de 1 até n para encontrar o valor máximo
        for (int i = 1; i <= n; i++) {
            // Se for possível cortar a barra de tamanho i
            if (n - i >= 0) {
                // Atualiza memo[n] com o valor máximo encontrado
                memo[n] = Math.max(memo[n], util(n - i, values, memo) + values[i - 1]);
            }
        }

        // Retorna o valor máximo calculado para o tamanho n
        return memo[n];
    }

    public static void main(String[] args) {
        // Caso de teste 1
        int n1 = 4;
        int[] values1 = {2, 5, 7, 9};
        System.out.println(maxProfit(n1, values1));

        // Caso de teste 2
        int n2 = 8;
        int[] values2 = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(n2, values2));

        // Caso de teste 3
        int n3 = 8;
        int[] values3 = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(n3, values3));
    }
}
