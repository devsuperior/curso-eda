class Program
{
    public int catchThieves(char[] arr, int n, int k)
    {
        List<int> thievesIndex = new List<int>();
        List<int> policeIndex = new List<int>();

        // Gets the indices for thieves and police
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 'T')
                thievesIndex.Add(i);
            else if (arr[i] == 'P')
                policeIndex.Add(i);
        }

        int t = 0, p = 0, ans = 0;
        // While there are remaining thieves or police
        while (t < thievesIndex.Count && p < policeIndex.Count)
        {

            int dist = Math.Abs(thievesIndex[t] - policeIndex[p]);
            if (dist <= k)
            {
                ans++;
                t++;
                p++;
            }
            else if (thievesIndex[t] < policeIndex[p])
            {
                t++;
            }
            else
            {
                p++;
            }
        }

        return ans;
    }
}
