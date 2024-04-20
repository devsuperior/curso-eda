class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine(minimumRooms( new int[]{900, 940, 950, 1100, 1500, 1800},
                                        new int[]{910, 1200, 1120, 1130, 1900, 2000},
                                        6));

        Console.WriteLine(minimumRooms( new int[]{900, 1100, 1235},
                                        new int[]{1000, 1200, 1240},
                                        3));
    }
    public static int minimumRooms(int[] start, int[] end, int n)
    {
        Array.Sort(start);
        Array.Sort(end);

        int i = 0, j = 0, ans = 0, rooms = 0;

        // Allocates rooms as needed and keeps track of the maximum we needed
        while (i < n || j < n)
        {
            if (i < n && (j == n || start[i] <= end[j]))
            {
                i++;
                rooms++;
            }
            else
            {
                j++;
                rooms--;
            }

            ans = Math.Max(ans, rooms);
        }

        return ans;
    }
}
