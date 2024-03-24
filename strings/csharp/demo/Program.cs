namespace MyApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string concatResult = string.Concat("Hello, ", "world!");
            Console.WriteLine($"Concat: {concatResult}");

            int compareResult = string.Compare("apple", "banana");
            Console.WriteLine($"Compare: {compareResult}");

            bool containsResult = "Hello, world!".Contains("world");
            Console.WriteLine($"Contains: {containsResult}");

            bool endsWithResult = "Hello, world!".EndsWith("world!");
            Console.WriteLine($"EndsWith: {endsWithResult}");

            int indexOfResult = "Hello, world!".IndexOf("world");
            Console.WriteLine($"IndexOf: {indexOfResult}");

            int lastIndexOfResult = "Hello, world, hello!".LastIndexOf("hello");
            Console.WriteLine($"LastIndexOf: {lastIndexOfResult}");

            string insertResult = "Hello, world!".Insert(7, "beautiful ");
            Console.WriteLine($"Insert: {insertResult}");

            string removeResult = "Hello, world!".Remove(5, 7);
            Console.WriteLine($"Remove: {removeResult}");

            string replaceResult = "Hello, world!".Replace("world", "C#");
            Console.WriteLine($"Replace: {replaceResult}");

            string[] splitResult = "Hello, world!".Split(',');
            Console.WriteLine($"Split: {string.Join(" and ", splitResult)}");

            bool startsWithResult = "Hello, world!".StartsWith("Hello");
            Console.WriteLine($"StartsWith: {startsWithResult}");

            string substringResult = "Hello, world!".Substring(7, 5);
            Console.WriteLine($"Substring: {substringResult}");

            string toLowerResult = "Hello, WORLD!".ToLower();
            Console.WriteLine($"ToLower: {toLowerResult}");

            string toUpperResult = "Hello, world!".ToUpper();
            Console.WriteLine($"ToUpper: {toUpperResult}");

            string trimResult = "   Hello, world!   ".Trim();
            Console.WriteLine($"Trim: '{trimResult}'");

            string trimStartResult = "   Hello, world!   ".TrimStart();
            Console.WriteLine($"TrimStart: '{trimStartResult}'");

            string trimEndResult = "   Hello, world!   ".TrimEnd();
            Console.WriteLine($"TrimEnd: '{trimEndResult}'");
        }
    }
}