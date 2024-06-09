﻿class Program {
    static void Main() {
        int result = factorial(4);
        Console.WriteLine("RESULTADO: " + result);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
