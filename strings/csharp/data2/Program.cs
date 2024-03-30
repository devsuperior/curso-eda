using System;

class Program
{
    public static string FormatDate(int day, int month, int year)
    {
        string formatDay = day.ToString("00");
        string formatMonth = month.ToString("00");

        return $"{formatDay}/{formatMonth}/{year}";
    }

    static void Main(string[] args)
    {
        Console.WriteLine(FormatDate(21, 7, 2010));
    }
}
