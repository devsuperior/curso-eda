public class Transacoes
{
    public class Transaction
    {
        public string Name;
        public int Time;
        public int Money;
        public string City;

        public Transaction(string csv)
        {
            string[] parts = csv.Split(',');
            Name = parts[0];
            Time = int.Parse(parts[1]);
            Money = int.Parse(parts[2]);
            City = parts[3];
        }
    }

    public static List<string> InvalidTransactions(string[] transactions)
    {
        var result = new List<string>();
        bool[] invalidArray = new bool[transactions.Length];

        for (int i = 0; i < transactions.Length; i++)
        {
            var ti = new Transaction(transactions[i]);

            if (ti.Money > 1000)
            {
                invalidArray[i] = true;
            }

            for (int j = i + 1; j < transactions.Length; j++)
            {
                var tj = new Transaction(transactions[j]);

                if (ti.Name == tj.Name && Math.Abs(ti.Time - tj.Time) <= 60 && ti.City != tj.City)
                {
                    invalidArray[i] = true;
                    invalidArray[j] = true;
                }
            }
        }

        for (int i = 0; i < transactions.Length; i++)
        {
            if (invalidArray[i])
            {
                result.Add(transactions[i]);
            }
        }

        return result;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,100,beijing" })) + "]");
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,1200,mtv" })) + "]");
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "bob,50,1200,mtv" })) + "]");
    }

}
