public class Transacoes
{
    public static void Main(string[] args)
    {
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,100,beijing" })) + "]");
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "alice,50,1200,mtv" })) + "]");
        Console.WriteLine("[" + string.Join(", ", InvalidTransactions(new string[] { "alice,20,800,mtv", "bob,50,1200,mtv" })) + "]");
    }

    public static List<string> InvalidTransactions(string[] transactions)
    {
        var result = new List<string>();
        bool[] invalidArray = new bool[transactions.Length];

        for (int i = 0; i < transactions.Length; i++)
        {
            var ti = ParseTransaction(transactions[i]);

            if (ti.money > 1000)
            {
                invalidArray[i] = true;
            }

            for (int j = i + 1; j < transactions.Length; j++)
            {
                var tj = ParseTransaction(transactions[j]);

                if (ti.name == tj.name && Math.Abs(ti.time - tj.time) <= 60 && ti.city != tj.city)
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

        (string name, int time, int money, string city) ParseTransaction(string csv)
        {
            var parts = csv.Split(',');
            return (
                parts[0],
                int.Parse(parts[1]),
                int.Parse(parts[2]),
                parts[3]
            );
        }
    }
}
