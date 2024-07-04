import java.util.Arrays;

public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int INF = Integer.MAX_VALUE;

        int[][] memo = new int[n][n];

        // Inicializando primeira linha
        for (int j = 0; j < n; j++) {
            memo[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int path_a = INF, path_b = INF, path_c = INF;
                if (isValid(i - 1, j - 1, n)) {
                    path_a = matrix[i][j] + memo[i - 1][j - 1];
                }
                if (isValid(i - 1, j + 1, n)) {
                    path_b = matrix[i][j] + memo[i - 1][j + 1];
                }
                if (isValid(i - 1, j, n)) {
                    path_c = matrix[i][j] + memo[i - 1][j];
                }

                memo[i][j] = Math.min(path_a, Math.min(path_b, path_c));
            }
        }

        int ans = INF;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, memo[n - 1][j]);
        }

        return ans;
    }

    // Método para verificar se as coordenadas são válidas
    private static boolean isValid(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        // Testes
        int[][] matrix1 = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix1));

        int[][] matrix2 = {{-19, 57}, {-40, -5}};
        System.out.println(minFallingPathSum(matrix2));
    }
}
