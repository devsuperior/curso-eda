using System;

public class TestDoublyLinkedList
{
    public static void Main(string[] args)
    {
        var list = new DoublyLinkedList<int>();

        // 1 - Add at start
        list.AddAtStart(2);
        list.AddAtStart(9);
        PrintArray(list.ToArray());

        list.Clear();

        // 2 - Add at end
        list.AddAtEnd(2);
        list.AddAtEnd(4);
        list.AddAtEnd(8);
        list.AddAtEnd(32);
        list.AddAtEnd(128);
        PrintArray(list.ToArray());

        // 3 - Get size of the list
        Console.WriteLine("Tamanho da lista igual a: " + list.Size);

        // 4 - Add at position
        list.AddAtPosition(3, 16);
        Console.WriteLine("Adicionado 16 à posição 3:");
        PrintArray(list.ToArray());

        Console.WriteLine("Adicionado 64 à posição 5:");
        list.AddAtPosition(5, 64);
        PrintArray(list.ToArray());

        // 5 - Remove head
        list.RemoveHead();
        Console.WriteLine("Removido primeiro elemento:");
        PrintArray(list.ToArray());

        // 6 - Remove tail
        list.RemoveTail();
        Console.WriteLine("Removido último elemento:");
        PrintArray(list.ToArray());

        // 7 - Remove at position
        list.RemoveAtPosition(4);
        Console.WriteLine("Removido elemento da posição 4:");
        PrintArray(list.ToArray());

        // 8 - Remove
        list.Remove(32);
        Console.WriteLine("Removido elemento 32:");
        PrintArray(list.ToArray());

        list.Remove(4);
        Console.WriteLine("Removido elemento 4:");
        PrintArray(list.ToArray());

        // 9 - Reverse list
        list.Reverse();
        Console.WriteLine("Lista reversa:");
        PrintArray(list.ToArray());
    }

    public static void PrintArray(object[] items)
    {
        Console.Write("[");
        for (int i = 0; i < items.Length - 1; i++)
        {
            Console.Write(items[i] + ", ");
        }
        if (items.Length > 0)
        {
            Console.Write(items[items.Length - 1]);
        }
        Console.WriteLine("]");
    }
}
