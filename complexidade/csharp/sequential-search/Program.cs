using System;

class Program {
    public static int SequentialSearch(int elem, int[] list) {
        for (int i = 0; i < list.Length; i++) {
            if (list[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    static void Main() {
        int[] array = {15, 82, 79, 32, 41, 28};
        int result = SequentialSearch(32, array);
        Console.WriteLine(result);
    }
}
