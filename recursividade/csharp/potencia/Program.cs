using System;

class Program {
    public static void Main(string[] args) {
        Console.WriteLine(power(5, 0));
        Console.WriteLine(power(3, 4));
    }

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }
}
