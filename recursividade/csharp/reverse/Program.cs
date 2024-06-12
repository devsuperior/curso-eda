class Program {
    public static void Main() {
        List<string> list = new List<string> { "azul", "verde", "preto", "rosa" };
        List<string> result = reverse(list);
        Console.WriteLine(string.Join(", ", result));
    }

    public static List<T> reverse<T>(List<T> list) {
        if (list.Count <= 1) {
            return new List<T>(list);
        }

        T head = list[0];
        List<T> tail = list.GetRange(1, list.Count - 1);

        List<T> newList = reverse(tail);
        newList.Add(head);

        return newList;
    }
}
