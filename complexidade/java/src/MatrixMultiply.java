public class MatrixMultiply {
	
	public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length;       
        int p = A[0].length;    
        int n = B[0].length;    

        int[][] C = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3}, 
            {4, 5, 6}
        }; 
        int[][] B = {
            {7, 8}, 
            {9, 10}, 
            {11, 12}
        };
        int[][] C = matrixMultiply(A, B);

        for (int[] row : C) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
