using System;
using System.Collections.Generic;

public class Sandwich
{
    public static int CountStudents(int[] students, int[] sandwiches)
    {
        Queue<int> queue = new Queue<int>(students);

        foreach (int sandwich in sandwiches)
        {
            bool eat = false;
            int count = queue.Count;

            while (!eat && count > 0)
            {
                int student = queue.Dequeue();
                if (student == sandwich)
                {
                    eat = true;
                }
                else
                {
                    queue.Enqueue(student);
                    count--;
                }
            }

            if (count == 0)
            {
                return queue.Count;
            }
        }

        return 0;
    }

    public static void Main()
    {
        Console.WriteLine(CountStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
        Console.WriteLine(CountStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
    }
}
