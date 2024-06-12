using System;
using System.Collections.Generic;

class Program {
    public static void Main() {
        List<int> list1 = new List<int>{10, 20, 30};
        List<int> list2 = new List<int>{5, 8, 7};
        Console.WriteLine(String.Join(", ", MergeLists(list1, list2)));

        List<string> list3 = new List<string>{"ana", "maria"};
        List<string> list4 = new List<string>{"joao", "bob", "alex", "leo"};
        Console.WriteLine(String.Join(", ", MergeLists(list3, list4)));
    }

    public static List<T> MergeLists<T>(List<T> a, List<T> b) {
        if (a.Count == 0) {
            return b;
        }
        if (b.Count == 0) {
            return a;
        }

        T head1 = a[0];
        List<T> tail1 = a.GetRange(1, a.Count - 1);

        T head2 = b[0];
        List<T> tail2 = b.GetRange(1, b.Count - 1);

        List<T> result = new List<T>();
        result.Add(head1);
        result.Add(head2);
        result.AddRange(MergeLists(tail1, tail2));
        return result;
    }
}
