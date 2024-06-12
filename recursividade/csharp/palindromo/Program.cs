using System;

public class PalindromeChecker {
    public static bool IsPalindrome(string text) {
        return IsPalindromeTailRecursive(text, 0, text.Length - 1);
    }

    private static bool IsPalindromeTailRecursive(string text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text[start] != text[end]) {
            return false;
        }

        return IsPalindromeTailRecursive(text, start + 1, end - 1);
    }

    public static void Main() {
        Console.WriteLine(IsPalindrome(""));
        Console.WriteLine(IsPalindrome("aba"));
        Console.WriteLine(IsPalindrome("abccba"));
        Console.WriteLine(IsPalindrome("abcfba"));
    }
}
