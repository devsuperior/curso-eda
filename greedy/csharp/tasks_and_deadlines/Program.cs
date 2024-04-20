using System;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        var tasks = new List<(int duration, int deadline)>
        {
            (6, 10),
            (8, 15),
            (5, 12)
        };
        Console.WriteLine(MaximumReward(tasks));

        tasks = new List<(int duration, int deadline)>
        {
            (3, 47),
            (5, 11),
            (1, 70),
            (2, 100),
            (2, 41),
            (2, 66),
            (5, 80),
            (4, 84),
            (5, 81),
            (5, 40)
        };
        Console.WriteLine(MaximumReward(tasks));

        tasks = new List<(int duration, int deadline)>
        {
            (80, 55),
            (29, 46),
            (58, 5),
            (92, 80),
            (62, 68),
            (64, 20),
            (78, 56),
            (41, 66),
            (62, 44),
            (32, 80)
        };
        Console.WriteLine(MaximumReward(tasks));
    }
    public static int MaximumReward(List<(int duration, int deadline)> tasks)
    {
        // Sorts the tasks by duration and deadline
        tasks.Sort((a, b) => a.duration.CompareTo(b.duration));

        int reward = 0;
        int time = 0;
        foreach (var task in tasks)
        {
            time += task.duration;
            reward += (task.deadline - time);
        }

        return reward;
    }
}
