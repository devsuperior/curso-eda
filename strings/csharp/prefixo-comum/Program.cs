using System.Text;

class PrefixoComum
{
    static void Main(string[] args)
    {
        Console.WriteLine($"\"{LongestCommonPrefix(new string[] { "flower", "flow", "flight" })}\"");
        Console.WriteLine($"\"{LongestCommonPrefix(new string[] { "dog", "racecar", "car" })}\"");
    }

    public static string LongestCommonPrefix(string[] v)
    {
        Array.Sort(v);
        string first = v[0];
        string last = v[v.Length - 1];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.Min(first.Length, last.Length); i++)
        {
            if (first[i] != last[i])
            {
                return result.ToString();
            }
            result.Append(first[i]);
        }

        return result.ToString();
    }
}
