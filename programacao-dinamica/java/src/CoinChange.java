import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Cria um array de memoização inicializado com Infinity
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        // Caso base: 0 moedas são necessárias para fazer o valor 0
        memo[0] = 0;

        // Preenche a tabela dp de 1 até amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int subproblem = i - coin;
                if (subproblem >= 0 && memo[subproblem] != Integer.MAX_VALUE) {
                    memo[i] = Math.min(memo[i], memo[subproblem] + 1);
                }
            }
        }

        // Retorna o resultado para dp[amount]
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        // Testes
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(coinChange(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(coinChange(coins2, amount2));

        int[] coins3 = {1, 2, 3, 7, 11};
        int amount3 = 10000;
        System.out.println(coinChange(coins3, amount3));
    }
}
