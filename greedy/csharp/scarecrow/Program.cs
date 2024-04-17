using System;

public class Program
{
    public int MinimumScarecrows(int n, string field)
    {
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (field[i] == '.')
            {
                i += 2; // A scarecrow protects this position and the next two
                ans++;
            }
        }
        return ans;
    }
}
