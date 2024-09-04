using System;
using System.Diagnostics;

class TimeTest
{
    static void MyFunction()
    {
        double x = 10;
        for (long i = 0; i < 100000000L; i++)
        {
            x = -x;
        }
    }
    
    static void Main(string[] args)
    {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.Start();
        MyFunction();
        stopwatch.Stop();
        long time = stopwatch.ElapsedMilliseconds;
        Console.WriteLine($"Duration: {time}ms");
    }
}
