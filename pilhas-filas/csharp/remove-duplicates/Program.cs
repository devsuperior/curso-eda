using System;
using System.Collections.Generic;

class Program {
    public static string RemoveDuplicates(string text) {
        Stack<char> stack = new Stack<char>();
        foreach (char ch in text) {
            if (stack.Count != 0 && stack.Peek() == ch) {
                stack.Pop();
            } else {
                stack.Push(ch);
            }
        }

        char[] result = new char[stack.Count];
        for (int i = result.Length - 1; i >= 0; i--) {
            result[i] = stack.Pop();
        }
        return new string(result);
    }

    static void Main() {
        Console.WriteLine(RemoveDuplicates("abbaca"));
        Console.WriteLine(RemoveDuplicates("azxxzy"));
    }
}
