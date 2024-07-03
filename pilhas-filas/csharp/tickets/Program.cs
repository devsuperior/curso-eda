using System;
using System.Collections.Generic;

class Program
{
    public static int TimeRequiredToBuy(int[] tickets, int k)
    {
        Queue<int> queue = new Queue<int>();
        int n = tickets.Length;

        for (int i = 0; i < n; i++)
        {
            queue.Enqueue(i);
        }

        int result = 0;
        while (true)
        {
            int i = queue.Dequeue();
            tickets[i]--;
            result++;
            if (tickets[i] > 0)
            {
                queue.Enqueue(i);
            }
            else if (i == k)
            {
                return result;
            }
        }
    }

    static void Main()
    {
        Console.WriteLine(TimeRequiredToBuy(new int[] { 2, 3, 2 }, 2));
        Console.WriteLine(TimeRequiredToBuy(new int[] { 5, 1, 1, 1 }, 0));
    }
}
