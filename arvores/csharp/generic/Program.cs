using GenericTree;

namespace Course
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
            Console.WriteLine("IsEmpty = " + myTree.IsEmpty());

            IPosition<string>? pos1 = myTree.Find("Livro Azul");
            IPosition<string>? pos2 = myTree.Find("Capítulo 1");
            IPosition<string>? pos3 = myTree.Find("Aplicações");

            Console.WriteLine("\nLivro Azul:");
            if (pos1 != null)
            {
                Console.WriteLine("Encontrado");
                Console.WriteLine("IsExternal: " + myTree.IsExternal(pos1));
                Console.WriteLine("IsRoot: " + myTree.IsRoot(pos1));
                IPosition<string>? parent = myTree.Parent(pos1);
                if (parent != null)
                {
                    Console.WriteLine("Parent: " + parent.Element());
                }
            }
            else
            {
                Console.WriteLine("NÃO encontrado");
            }

            Console.WriteLine("\nCapítulo 1:");
            if (pos2 != null)
            {
                Console.WriteLine("Encontrado");
                Console.WriteLine("IsExternal: " + myTree.IsExternal(pos2));
                Console.WriteLine("IsRoot: " + myTree.IsRoot(pos2));
                IPosition<string>? parent = myTree.Parent(pos2);
                if (parent != null)
                {
                    Console.WriteLine("Parent: " + parent.Element());
                }
            }
            else
            {
                Console.WriteLine("NÃO encontrado");
            }

            Console.WriteLine("\nAplicações:");
            if (pos3 != null)
            {
                Console.WriteLine("Encontrado");
                Console.WriteLine("IsExternal: " + myTree.IsExternal(pos3));
                Console.WriteLine("IsRoot: " + myTree.IsRoot(pos3));
                IPosition<string>? parent = myTree.Parent(pos3);
                if (parent != null)
                {
                    Console.WriteLine("Parent: " + parent.Element());
                }
            }
            else
            {
                Console.WriteLine("NÃO encontrado");
            }

            IPosition<string>? pos4 = myTree.Find("Conceitos");
            myTree.Replace(pos4, "Conceitos básicos");

            Console.WriteLine("\nPRINT DFS PRE ORDER:");
            Print(myTree);

            Console.WriteLine("\nPRINT elements:");
            foreach (string elem in myTree.Elements())
            {
                Console.WriteLine(elem);
            }

            Console.WriteLine("\nPRINT positions:");
            foreach (IPosition<string> pos in myTree.Positions())
            {
                Console.WriteLine(pos.Element());
            }

            Console.WriteLine("\nPRINT BFS:");
            PrintBfs(myTree);

            IPosition<string>? pos5 = myTree.Find("Métodos");
            if (pos5 != null)
            {
                myTree.Remove(pos5);
                Console.WriteLine("\nPRINT remove:");
                Console.WriteLine("SIZE = " + myTree.Size());
                Print(myTree);
            }
        }

        public static void Print<T>(GenericTree<T> tree)
        {
            PrintRecursive(tree.Root(), tree, 0);
        }

        public static void PrintRecursive<T>(IPosition<T>? position, GenericTree<T> tree, int depth)
        {
            if (position == null) {
                return;
            }
            string spaces = new String(' ', depth * 4);
            Console.WriteLine(spaces + position.Element());
            foreach (IPosition<T> child in tree.Children(position))
            {
                PrintRecursive(child, tree, depth + 1);
            }
        }

        public static void PrintBfs<T>(GenericTree<T> tree)
        {
            IPosition<T>? root = tree.Root();
            if (root == null)
            {
                return;
            }
            Queue<IPosition<T>> queue = new Queue<IPosition<T>>();
            queue.Enqueue(root);
            while (queue.Count > 0)
            {
                IPosition<T> position = queue.Dequeue();
                Console.WriteLine(position.Element());
                foreach (IPosition<T> child in tree.Children(position))
                {
                    queue.Enqueue(child);
                }
            }
        }
    }
}
