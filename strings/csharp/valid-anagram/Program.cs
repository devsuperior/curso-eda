class Program
{

    public static void Main(string[] args)
    {

        Console.WriteLine(IsAnagram("anagram", "nagaram"));
        Console.WriteLine(IsAnagram("batata", "attaba"));
        Console.WriteLine(IsAnagram("rat", "car"));

        Console.WriteLine(IsAnagram2("anagram", "nagaram"));
        Console.WriteLine(IsAnagram2("batata", "attaba"));
        Console.WriteLine(IsAnagram2("rat", "car"));
    }

    public static bool IsAnagram(string s, string t)
    {
        char[] sChars = s.ToCharArray();
        char[] tChars = t.ToCharArray();

        Array.Sort(sChars);
        Array.Sort(tChars);

        return new string(sChars) == new string(tChars);
    }

    public static bool IsAnagram2(string s, string t)
    {

        int[] count = new int[26];

        foreach (char c in s)
        {
            count[c - 'a']++;
        }

        foreach (char c in t)
        {
            count[c - 'a']--;
        }

        foreach (int val in count)
        {
            if (val != 0)
            {
                return false;
            }
        }

        return true;
    }
}
