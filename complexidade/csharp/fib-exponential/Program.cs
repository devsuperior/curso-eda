using System;

class Program {
    static int FibExponential(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return FibExponential(n - 1) + FibExponential(n - 2);
    }

    static void Main() {
        int result = FibExponential(40);
        Console.WriteLine(result);
    }
}
