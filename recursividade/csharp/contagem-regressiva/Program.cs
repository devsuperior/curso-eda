using System;

class Program {
    public static void Main() {
        Countdown(5);
    }

    public static void Countdown(int n) {
        Console.WriteLine(n);
        if (n > 0) {
            Countdown(n - 1);
        }
    }
}
