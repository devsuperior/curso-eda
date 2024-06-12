using System;
using System.Collections.Generic;
using System.Linq;

public class Program {
    public static double Minor(List<double> list) {
        if (list.Count == 1) {
            return list[0];
        }

        double head = list[0];
        List<double> tail = list.Skip(1).ToList();

        double tailMinor = Minor(tail);

        return (head < tailMinor) ? head : tailMinor;
    }

    public static void Main() {
        List<double> list = new List<double> {10.0, 15.0, 20.0, 8.0, 30.0, 17.0};
        double result = Minor(list);
        Console.WriteLine("MENOR = " + result);
    }
}
