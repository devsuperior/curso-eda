using System;

class Program {
    public static void Main(string[] args) {
        Console.WriteLine(charCount('b', "Batata para o bebê"));
    }

    public static int charCount(char ch, string text) {
        return charCountTailRecursive(Char.ToLower(ch), text.ToLower(), 0, 0);
    }

    public static int charCountTailRecursive(char ch, string text, int index, int count) {
        if (index >= text.Length) {
            return count;
        }

        int newCount = (text[index] == ch) ? count + 1 : count;
        return charCountTailRecursive(ch, text, index + 1, newCount);
    }
}
