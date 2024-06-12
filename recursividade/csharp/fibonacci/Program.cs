using System;

public class Fibonacci {
    public static void Main(string[] args) {
        int result = fib(6);
        Console.WriteLine("RESULTADO = " + result);
    }

    public static int fib(int n) {
        return fibTailRecursive(n, 0, 1);
    }

    public static int fibTailRecursive(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        return fibTailRecursive(n - 1, b, a + b);
    }
}
