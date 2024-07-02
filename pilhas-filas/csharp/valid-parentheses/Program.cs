using System;
using System.Collections.Generic;

public class Program
{
    public static bool ValidParenthesesMethod(string text)
    {
        Stack<char> stack = new Stack<char>();
        foreach (char c in text)
        {
            if (c == '(')
            {
                stack.Push(')');
            }
            else if (c == '{')
            {
                stack.Push('}');
            }
            else if (c == '[')
            {
                stack.Push(']');
            }
            else if (stack.Count == 0 || stack.Pop() != c)
            {
                return false;
            }
        }
        return stack.Count == 0;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(ValidParenthesesMethod("()([]{})")); // True
        Console.WriteLine(ValidParenthesesMethod("(){]{}")); // False
    }
}
