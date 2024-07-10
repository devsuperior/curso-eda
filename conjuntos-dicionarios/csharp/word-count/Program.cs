using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Rank
{
    public string Word { get; set; }
    public int Count { get; set; }

    public Rank(string word, int count)
    {
        Word = word;
        Count = count;
    }
}

public class Program
{
    public static string Normalize(string text)
    {
        string noPunctuation = Regex.Replace(text, "\\p{P}", " ");
        return Regex.Replace(noPunctuation, "\\s+", " ").Trim().ToLower();
    }

    public static List<Rank> WordCount(string text)
    {
        var dict = new Dictionary<string, int>();

        string[] words = Normalize(text).Split(' ');

        foreach (string word in words)
        {
            if (!dict.ContainsKey(word))
            {
                dict.Add(word, 1);
            }
            else
            {
                dict[word]++;
            }
        }

        var ranks = new List<Rank>();
        foreach (KeyValuePair<string, int> entry in dict)
        {
            ranks.Add(new Rank(entry.Key, entry.Value));
        }

        ranks.Sort((a, b) =>
        {
            int countComparison = b.Count.CompareTo(a.Count);
            if (countComparison != 0)
            {
                return countComparison;
            }
            return a.Word.CompareTo(b.Word);
        });

        return ranks;
    }

    public static void Main(string[] args)
    {
        string inputText = @"
            O vento sussurra sons entre as árvores, sons que fazem animais 
            correrem. A floresta e a natureza vibram com segredos e sons.
        ";

        List<Rank> result = WordCount(inputText);
        foreach (Rank obj in result)
        {
            Console.WriteLine(obj.Word + ": " + obj.Count);
        }
    }
}
