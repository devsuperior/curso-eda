import java.util.LinkedList;
import java.util.Queue;

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

		Position<String> pos3 = myTree.find("Livro Azul");
		Position<String> pos4 = myTree.find("Capítulo 1");
		Position<String> pos5 = myTree.find("Aplicações");

		System.out.println("\nLivro Azul isExternal: " + myTree.isExternal(pos3));
		System.out.println("Livro Azul isRoot: " + myTree.isRoot(pos3));
		System.out.println("Capítulo 1 isExternal: " + myTree.isExternal(pos4));
		System.out.println("Capítulo 1 isRoot: " + myTree.isRoot(pos4));
		System.out.println("Aplicações isExternal: " + myTree.isExternal(pos5));
		System.out.println("Aplicações isRoot: " + myTree.isRoot(pos5));

		System.out.println("\nElements:");
		for (String element : myTree.elements()) {
			System.out.println(element);
		}

		System.out.println("\nPrint preOrder:");
		printPreOrder(myTree);

		System.out.println("\nPrint postOrder:");
		printPostOrder(myTree);

		System.out.println("\nPrint BFS:");
		printBfs(myTree);

		Position<String> pos1 = myTree.find("Métodos");
		if (pos1 != null) {
			myTree.remove(pos1);
		}

		Position<String> pos2 = myTree.find("Para quem é este livro");
		if (pos2 != null) {
			myTree.replace(pos2, "Público alvo");
		}

		System.out.println("\nRemove + replace:");
		printPreOrder(myTree);
	}

	public static <T> void printPreOrder(GenericTree<T> tree) {
		printPreOrderRecursive(tree, tree.root(), 0);
	}

	public static <T> void printPreOrderRecursive(GenericTree<T> tree, Position<T> pos, int depth) {
		String spaces = "   ".repeat(depth);
		System.out.println(spaces + pos.element());
		for (Position<T> child : tree.children(pos)) {
			printPreOrderRecursive(tree, child, depth + 1);
		}
	}

	public static <T> void printPostOrder(GenericTree<T> tree) {
		printPostOrderRecursive(tree, tree.root(), 0);
	}

	public static <T> void printPostOrderRecursive(GenericTree<T> tree, Position<T> pos, int depth) {
		for (Position<T> child : tree.children(pos)) {
			printPostOrderRecursive(tree, child, depth + 1);
		}
		String spaces = "   ".repeat(depth);
		System.out.println(spaces + pos.element());
	}

	public static <T> void printBfs(GenericTree<T> tree) {
		if (tree.isEmpty()) {
			return;
		}

		Position<T> root = tree.root();

		Queue<Elem<T>> queue = new LinkedList<>();
		queue.add(new Elem<>(root, 0));

		while (!queue.isEmpty()) {
			
			Elem<T> elem = queue.poll();
			
			String spaces = "   ".repeat(elem.depth);
			System.out.println(spaces + elem.position.element());
			
			for (Position<T> child : tree.children(elem.position)) {
				queue.add(new Elem<>(child, elem.depth + 1));
			}
		}
	}
}

class Elem<T> {
	Position<T> position;
	int depth;

	Elem(Position<T> position, int depth) {
		this.position = position;
		this.depth = depth;
	}
}
