using System;

public class Program {
    public static bool IsBalanced(string text) {
        Stack1<char> stack = new Stack1<char>();
        foreach (char ch in text) {
            if (ch == '(') {
                stack.Push(ch);
            } else if (ch == ')') {
                if (stack.Count == 0) {
                    return false;
                }
                stack.Pop();
            }
        }
        return stack.Count == 0;
    }

    public static void Main() {
        Console.WriteLine(IsBalanced("(())()")); // true
        Console.WriteLine(IsBalanced("())("));   // false
    }
}
