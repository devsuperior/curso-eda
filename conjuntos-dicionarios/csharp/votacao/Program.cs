using System;
using System.Collections.Generic;

public class Program {
    public static List<string> Counting(List<string> votes) {
        var dict = new Dictionary<string, int>();

        foreach (string s in votes) {
            string[] parts = s.Split(",");
            string name = parts[0];
            int count = int.Parse(parts[1]);
            if (!dict.ContainsKey(name)) {
                dict.Add(name, count);
            } else {
                dict[name] += count;
            }
        }

        List<string> result = new List<string>();
        foreach (var entry in dict) {
            result.Add($"{entry.Key},{entry.Value}");
        }

        return result;
    }

    public static void Main(string[] args) {
        List<string> input = new List<string> {
            "Alex Blue,15", 
            "Maria Green,22", 
            "Bob Brown,21", 
            "Alex Blue,30",
            "Bob Brown,15", 
            "Maria Green,27", 
            "Maria Green,22", 
            "Bob Brown,25", 
            "Alex Blue,31"
        };

        List<string> result = Counting(input);
        foreach (string s in result) {
            Console.WriteLine(s);
        }
    }
}
