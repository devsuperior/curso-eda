using System;

public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine(NumRescueBoats(new int[]{1, 2}, 3));
        Console.WriteLine(NumRescueBoats(new int[]{3, 2, 2, 1}, 3));
        Console.WriteLine(NumRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
    public static int NumRescueBoats(int[] people, int limit)
    {
        int l = 0, r = people.Length - 1;

        // Sorting the array of people by their weight
        Array.Sort(people);

        int boats = 0;
        while (l <= r)
        {
            // Attempt to fit two people in one boat
            if (people[r] + people[l] <= limit)
            {
                l++; // Moving to the next lightest person
                r--; // Moving to the next heaviest person
            }
            // If only the heaviest person can fit
            else if (people[r] <= limit)
            {
                r--; // Moving to the next heaviest person
            }
            // If no one can fit, move to the next lightest person
            else
            {
                l++;
            }
            boats++; // A boat is used in each iteration
        }

        return boats;
    }
}