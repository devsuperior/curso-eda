using System;
using System.Collections.Generic;
using Newtonsoft.Json;

public class Program {

    public static int Total(List<string> visitors) {
        var uniqueVisitors = new HashSet<string>();

        foreach (var visitor in visitors) {
            var name = visitor.Split(',')[0];
            uniqueVisitors.Add(name);
        }

        return uniqueVisitors.Count;
    }

    public static int TotalNaive(List<string> visitors) {
        var uniqueVisitors = new List<string>();

        foreach (var visitor in visitors) {
            var name = visitor.Split(',')[0];
            if (!uniqueVisitors.Contains(name)) {
                uniqueVisitors.Add(name);
            }
        }

        return uniqueVisitors.Count;
    }

    public static void Main(string[] args) {

        string jsonContent = System.IO.File.ReadAllText("c:/temp/visitantes-input.json");

        var visitors = JsonConvert.DeserializeObject<List<string>>(jsonContent) ?? new List<string>();

        var start1 = DateTime.Now;
        var result1 = Total(visitors);
        var end1 = DateTime.Now;
        var time1 = (end1 - start1).TotalSeconds;
        Console.WriteLine($"RESULT = {result1}. Time = {time1:F3}s");

        var start2 = DateTime.Now;
        var result2 = TotalNaive(visitors);
        var end2 = DateTime.Now;
        var time2 = (end2 - start2).TotalSeconds;
        Console.WriteLine($"RESULT = {result2}. Time = {time2:F3}s");

        var quo = time2 / time1;
        Console.WriteLine($"Segundo algoritmo {quo:F1} vezes mais lento");
    }
}
