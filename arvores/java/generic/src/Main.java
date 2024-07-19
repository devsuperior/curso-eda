import generictree.GenericTree;
import generictree.Position;

public class Main {

	public static void main(String[] args) {
		
        GenericTree<String> myTree = new GenericTree<>();

        Position<String> root = myTree.add("Livro Azul", null);

        Position<String> intro = myTree.add("Introdução", root);
        Position<String> cap1 = myTree.add("Capítulo 1", root);
        Position<String> cap2 = myTree.add("Capítulo 2", root);

        myTree.add("Para quem é este livro", intro);
        myTree.add("Agradecimentos", intro);

        myTree.add("Conceitos", cap1);
        myTree.add("Aplicações", cap1);

        Position<String> cap2Sec1 = myTree.add("Métodos", cap2);
        myTree.add("Problema terreno", cap2);
        myTree.add("Problema carros", cap2);

        myTree.add("Método recursivo", cap2Sec1);
        myTree.add("Método imperativo", cap2Sec1);
        
        System.out.println("Size = " + myTree.size());
        System.out.println("isEmpty = " + myTree.isEmpty());

        System.out.println("\nManual print:");
        print(myTree);
        
        Position<String> pos1 = myTree.findBfs("Métodos");
        if (pos1 != null) {
            myTree.remove(pos1);
            System.out.println("\nSize após remoção = " + myTree.size());
            System.out.println("\nManual print:");
            print(myTree);        	
        }
        
        Position<String> pos2 = myTree.findBfs("Para quem é este livro");
        if (pos2 != null) {
        	myTree.replace(pos2, "Público alvo");
            System.out.println("\nManual print depois de replace:");
            print(myTree);        	
        }

        Position<String> pos3 = myTree.findBfs("Livro Azul");
        Position<String> pos4 = myTree.findBfs("Capítulo 1");
        Position<String> pos5 = myTree.findBfs("Aplicações");
        
        System.out.println("\nLivro Azul isExternal: " + myTree.isExternal(pos3));
        System.out.println("Livro Azul isRoot: " + myTree.isRoot(pos3));
        System.out.println("Capítulo 1 isExternal: " + myTree.isExternal(pos4));
        System.out.println("Capítulo 1 isRoot: " + myTree.isRoot(pos4));
        System.out.println("Aplicações isExternal: " + myTree.isExternal(pos5));
        System.out.println("Aplicações isRoot: " + myTree.isRoot(pos5));
                
        System.out.println("\nBFS:");
        for (String element : myTree.elementsBfs()) {
        	System.out.println(element);
        }

        System.out.println("\nDFS:");
        for (String element : myTree.elementsDfs()) {
        	System.out.println(element);
        }
	}
	
	public static <T> void print(GenericTree<T> tree) {
		printRecursive(tree, tree.root(), 0);
	}
	
	public static <T> void printRecursive(GenericTree<T> tree, Position<T> pos, int depth) {
		String spaces = "   ".repeat(depth);
		System.out.println(spaces + pos.element());
		for (Position<T> child : tree.children(pos)) {
			printRecursive(tree, child, depth + 1);
		}
	}
}
