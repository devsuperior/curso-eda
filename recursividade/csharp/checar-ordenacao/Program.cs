using System;
using System.Collections.Generic;

public class SortedChecker {
    public static bool IsSorted(List<double> list) {
        if (list.Count <= 1) {
            return true;
        }

        if (list[0] > list[1]) {
            return false;
        }

        List<double> tail = list.GetRange(1, list.Count - 1);
        return IsSorted(tail);
    }

    public static void Main() {
        Console.WriteLine(IsSorted(new List<double>()));
        Console.WriteLine(IsSorted(new List<double>{15.0, 20.0, 22.0, 31.0, 40.0}));
        Console.WriteLine(IsSorted(new List<double>{15.0, 20.0, 22.0, 21.0, 40.0}));
    }
}
