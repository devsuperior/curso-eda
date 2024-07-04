import java.util.Arrays;

public class FrogJumps {
    public static int minCostFrog(int[] heights) {
        final int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        // Função recursiva com memoização
        return solve(heights, memo, 0);
    }

    private static int solve(int[] heights, int[] memo, int ind) {
        final int n = heights.length;
        if (ind >= n) {
            return Integer.MAX_VALUE;
        }
        if (ind == n - 1) {
            return 0;
        }
        if (memo[ind] != -1) {
            return memo[ind];
        }

        int jump1Cost = (ind + 1 < n) ? solve(heights, memo, ind + 1) + Math.abs(heights[ind] - heights[ind + 1]) : Integer.MAX_VALUE;
        int jump2Cost = (ind + 2 < n) ? solve(heights, memo, ind + 2) + Math.abs(heights[ind] - heights[ind + 2]) : Integer.MAX_VALUE;

        return memo[ind] = Math.min(jump1Cost, jump2Cost);
    }

    public static void main(String[] args) {
        // Testes
        int[] heights1 = {10, 30, 40, 20};
        System.out.println(minCostFrog(heights1));

        int[] heights2 = {10, 10};
        System.out.println(minCostFrog(heights2));

        int[] heights3 = {30, 10, 60, 10, 60, 50};
        System.out.println(minCostFrog(heights3));
    }
}
