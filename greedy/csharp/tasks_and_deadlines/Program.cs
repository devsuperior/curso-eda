using System;
using System.Collections.Generic;

public class Program
{
    public int MaximumReward(List<(int duration, int deadline)> tasks)
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
