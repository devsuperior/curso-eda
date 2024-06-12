using System;
using System.Collections.Generic;

public class Program {
    public static void Main(string[] args) {
        List<double> numbers = new List<double>{4.0, 5.0, 3.0};
        double result = SumList(numbers);
        Console.WriteLine("RESULTADO = " + result);
    }

    public static double SumList(List<double> list) {
        if (list.Count == 0) {
            return 0;
        }

        double head = list[0];
        List<double> tail = list.GetRange(1, list.Count - 1);

        return head + SumList(tail);
    }
}
