class Program {
    static void Main() {
        int result = sum(4);
        Console.WriteLine("RESULTADO: " + result);
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
