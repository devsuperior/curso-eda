class Program
{
    public int minimumRooms(int[] start, int[] end, int n)
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
