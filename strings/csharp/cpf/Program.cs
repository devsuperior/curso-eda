using System.Text;
using System.Text.RegularExpressions;

class Program
{
    static string RemoveNonDigits(string str)
    {
        StringBuilder sb = new StringBuilder(); 

        foreach (char c in str)
        {
            if (char.IsDigit(c))
            {
                sb.Append(c);
            }
        }

        return sb.ToString();
    }

    public static string RemoveNonDigits2(string str) {
        string regex = "\\D";
        return Regex.Replace(str, regex, "");
    }

    static void Main()
    {
        Console.WriteLine(RemoveNonDigits("949.237.847-99"));
        Console.WriteLine(RemoveNonDigits2("949.237.847-99"));
    }
}
