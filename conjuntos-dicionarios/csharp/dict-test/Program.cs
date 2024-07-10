using System;
using System.Collections.Generic;

public class Program {
    public static void Main(string[] args) {
        Dictionary<string, string> cookies = new Dictionary<string, string>();

        cookies.Add("user", "maria34");
        cookies["email"] = "ana@gmail.com";
        cookies["email"] = "maria@gmail.com";
        cookies.Add("last-login", "2024-07-04T21:42:40.353283800Z");

        Console.WriteLine("Values:");
        foreach (string value in cookies.Values) {
            Console.WriteLine(value);
        }

        Console.WriteLine("\nKeys & values:");
        foreach (KeyValuePair<string, string> entry in cookies) {
            Console.WriteLine(entry.Key + ": " + entry.Value);
        }

        Console.WriteLine("\nIs empty: " + (cookies.Count == 0));
        Console.WriteLine("Size: " + cookies.Count);

        Console.WriteLine("\nContains 'email': " + cookies.ContainsKey("email"));
        bool result = cookies.Remove("email");
        Console.WriteLine("Remove: " + result);
        
        Console.WriteLine("\nContains 'email': " + cookies.ContainsKey("email"));
        result = cookies.Remove("email");
        Console.WriteLine("Remove: " + result);
    }
}
