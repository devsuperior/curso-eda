class Program {
    
    public static DateData ExtractDateData(string date) {

        var parts = date.Split('/');

        int day = Convert.ToInt32(parts[0]);
        int month = Convert.ToInt32(parts[1]);
        int year = Convert.ToInt32(parts[2]);

        return new DateData(day, month, year);
    }

    static void Main(string[] args) {

        var obj = ExtractDateData("21/07/2010");
        Console.WriteLine($"Dia: {obj.Day}");
        Console.WriteLine($"Mês: {obj.Month}");
        Console.WriteLine($"Ano: {obj.Year}");
    }
}

public class DateData {
    public int Day { get; }
    public int Month { get; }
    public int Year { get; }

    public DateData(int day, int month, int year) {
        Day = day;
        Month = month;
        Year = year;
    }
}
