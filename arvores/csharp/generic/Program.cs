using System;

namespace GenericTree
{
    public class Program
    {
        public static void Main(string[] args)
        {
            GenericTree<string> myTree = new GenericTree<string>();

            IPosition<string> root = myTree.Add("Livro Azul", null);

            IPosition<string> intro = myTree.Add("Introdução", root);
            IPosition<string> cap1 = myTree.Add("Capítulo 1", root);
            IPosition<string> cap2 = myTree.Add("Capítulo 2", root);

            myTree.Add("Para quem é este livro", intro);
            myTree.Add("Agradecimentos", intro);

            myTree.Add("Conceitos", cap1);
            myTree.Add("Aplicações", cap1);

            IPosition<string> cap2Sec1 = myTree.Add("Métodos", cap2);
            myTree.Add("Problema terreno", cap2);
            myTree.Add("Problema carros", cap2);

            myTree.Add("Método recursivo", cap2Sec1);
            myTree.Add("Método imperativo", cap2Sec1);

            Console.WriteLine("Size = " + myTree.Size());
            Console.WriteLine("isEmpty = " + myTree.IsEmpty());

            Console.WriteLine("\nManual print:");
            Print(myTree);

            IPosition<string>? pos1 = myTree.FindBfs("Métodos");
            if (pos1 != null)
            {
                myTree.Remove(pos1);
                Console.WriteLine("\nSize após remoção = " + myTree.Size());
                Console.WriteLine("\nManual print:");
                Print(myTree);
            }

            IPosition<string>? pos2 = myTree.FindBfs("Para quem é este livro");
            if (pos2 != null)
            {
                myTree.Replace(pos2, "Público alvo");
                Console.WriteLine("\nManual print depois de replace:");
                Print(myTree);
            }

            IPosition<string>? pos3 = myTree.FindBfs("Livro Azul");
            IPosition<string>? pos4 = myTree.FindBfs("Capítulo 1");
            IPosition<string>? pos5 = myTree.FindBfs("Aplicações");

            if (pos3 != null)
            {
                Console.WriteLine("\nLivro Azul isExternal: " + myTree.IsExternal(pos3));
                Console.WriteLine("Livro Azul isRoot: " + myTree.IsRoot(pos3));
            }
            if (pos4 != null)
            {
                Console.WriteLine("Capítulo 1 isExternal: " + myTree.IsExternal(pos4));
                Console.WriteLine("Capítulo 1 isRoot: " + myTree.IsRoot(pos4));
            }
            if (pos5 != null)
            {
                Console.WriteLine("Aplicações isExternal: " + myTree.IsExternal(pos5));
                Console.WriteLine("Aplicações isRoot: " + myTree.IsRoot(pos5));
            }
            
            Console.WriteLine("\nBFS:");
            foreach (string element in myTree.ElementsBfs())
            {
                Console.WriteLine(element);
            }

            Console.WriteLine("\nDFS:");
            foreach (string element in myTree.ElementsDfs())
            {
                Console.WriteLine(element);
            }
        }

        public static void Print<T>(GenericTree<T> tree)
        {
            PrintRecursive(tree, tree.Root(), 0);
        }

        public static void PrintRecursive<T>(GenericTree<T> tree, IPosition<T> pos, int depth)
        {
            string spaces = new string(' ', depth * 3);
            Console.WriteLine(spaces + pos.Element());
            foreach (IPosition<T> child in tree.Children(pos))
            {
                PrintRecursive(tree, child, depth + 1);
            }
        }
    }
}
