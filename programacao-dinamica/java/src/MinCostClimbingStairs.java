import java.util.Arrays;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1); // Inicializa o array de memoização

        return minCostClimbingStairsUtil(cost.length, cost, memo);
    }

    private static int minCostClimbingStairsUtil(int n, int[] cost, int[] memo) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = Math.min(
                minCostClimbingStairsUtil(n - 1, cost, memo) + cost[n - 1],
                minCostClimbingStairsUtil(n - 2, cost, memo) + cost[n - 2]
        );

        return memo[n];
    }

    public static void main(String[] args) {
        // Caso de teste 1
        int[] cost1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost1));

        // Caso de teste 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost2));
    }
}
