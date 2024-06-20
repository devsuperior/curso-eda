using System;

public class MatrixMultiplication {
    public static int[,] MatrixMultiply(int[,] A, int[,] B) {
        int m = A.GetLength(0);      
        int p = A.GetLength(1);      
        int n = B.GetLength(1);      

        int[,] C = new int[m, n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    C[i, j] += A[i, k] * B[k, j];
                }
            }
        }
        return C;
    }

    public static void Main(string[] args) {
        int[,] A = {
            {1, 2, 3}, 
            {4, 5, 6}
        }; 
        int[,] B = {
            {7, 8}, 
            {9, 10}, 
            {11, 12}
        };
        int[,] C = MatrixMultiply(A, B);

        for (int i = 0; i < C.GetLength(0); i++) {
            for (int j = 0; j < C.GetLength(1); j++) {
                Console.Write(C[i, j] + " ");
            }
            Console.WriteLine();
        }
    }
}
