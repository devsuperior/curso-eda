class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine(findLargest(2, 9));
        Console.WriteLine(findLargest(3, 20));
        Console.WriteLine(findLargest(4, 0));
    }
    public static string findLargest(int N, int S)
    {
        string ans = "";

        // If we put the maximum digits we still can't make S
        if (9 * N < S || (S == 0 && N > 1))
        {
            return "-1";
        }

        while (S > 0)
        {
            // Greedily fit as many '9' digits as we can
            if (S - 9 >= 0)
            {
                S -= 9;
                ans += '9';
            }
            // Fit the rest of the sum
            else
            {
                ans += (char)('0' + S);
                S = 0;
            }
        }

        // Reach N digits if we haven't
        while (ans.Length < N)
        {
            ans += '0';
        }

        return ans;

    }
}