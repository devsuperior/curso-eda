using System;
using System.Collections.Generic;

public class Program
{
    public class Transaction
    {
        public string Name;
        public int Time;
        public int Money;
        public string City;
        public string Csv;

        public Transaction(string csv)
        {
            string[] parts = csv.Split(',');
            Name = parts[0];
            Time = int.Parse(parts[1]);
            Money = int.Parse(parts[2]);
            City = parts[3];
            Csv = csv;
        }
    }

    public static List<string> InvalidTransactions(string[] transactions)
    {
        Dictionary<string, List<Transaction>> dict = new Dictionary<string, List<Transaction>>();
        List<Transaction> allTransactions = new List<Transaction>();
        List<string> result = new List<string>();

        foreach (string s in transactions)
        {
            Transaction t = new Transaction(s);
            allTransactions.Add(t);

            if (dict.ContainsKey(t.Name))
            {
                dict[t.Name].Add(t);
            }
            else
            {
                dict.Add(t.Name, new List<Transaction> { t });
            }
        }

        foreach (Transaction t in allTransactions)
        {
            if (t.Money > 1000)
            {
                result.Add(t.Csv);
            }
            else
            {
                foreach (Transaction t2 in dict[t.Name])
                {
                    if (Math.Abs(t.Time - t2.Time) <= 60 && t.City != t2.City)
                    {
                        result.Add(t.Csv);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,100,beijing" })));
        Console.WriteLine(string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,1200,mtv" })));
        Console.WriteLine(string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "bob,50,1200,mtv" })));
    }
}
