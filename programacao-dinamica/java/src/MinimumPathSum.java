public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Matriz de memoização
        int[][] memo = new int[n][m];

        memo[0][0] = grid[0][0];

        // Inicializando primeira coluna
        for (int i = 1; i < n; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }

        // Inicializando primeira linha
        for (int j = 1; j < m; j++) {
            memo[0][j] = memo[0][j - 1] + grid[0][j];
        }

        // Aplicando tabulação
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }

        return memo[n - 1][m - 1];
    }

    public static void main(String[] args) {
        // Casos de teste
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid1));

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid2));
    }
}
