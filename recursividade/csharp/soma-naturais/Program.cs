class Program {
    public static void Main() {
        int result = SumNaturals(4);
        Console.WriteLine("RESULTADO: " + result);
    }

    public static int SumNaturals(int n) {
        if (n == 0) {
            return 0;
        }
        return n + SumNaturals(n - 1);
    }
}
