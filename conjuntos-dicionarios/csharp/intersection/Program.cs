using System;
using System.Collections.Generic;
using System.Linq;

public class Program {
    public static int[] Intersection(int[] nums1, int[] nums2) {
        HashSet<int> set1 = new HashSet<int>(nums1);
        HashSet<int> set2 = new HashSet<int>(nums2);

        set1.IntersectWith(set2);

        return set1.ToArray();
    }

    public static void Main(string[] args) {
        int[] result1 = Intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] result2 = Intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Console.WriteLine($"[{string.Join(", ", result1)}]");
        Console.WriteLine($"[{string.Join(", ", result2)}]");
    }
}
