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

		Position<String> pos1 = myTree.find("Livro Azul");
		Position<String> pos2 = myTree.find("Capítulo 1");
		Position<String> pos3 = myTree.find("Aplicações");
		
		System.out.println("\nLivro Azul:");
		if (pos1 != null) {
		    System.out.println("Encontrado");
		    System.out.println("isExternal: " + myTree.isExternal(pos1));
		    System.out.println("isRoot: " + myTree.isRoot(pos1));
		    Position<String> parent = myTree.parent(pos1);
		    if (parent != null) {
		        System.out.println("parent: " + parent.element());
		    }
		} else {
		    System.out.println("NÃO encontrado");
		}

		System.out.println("\nCapítulo 1:");
		if (pos2 != null) {
		    System.out.println("Encontrado");
		    System.out.println("isExternal: " + myTree.isExternal(pos2));
		    System.out.println("isRoot: " + myTree.isRoot(pos2));
		    Position<String> parent = myTree.parent(pos2);
		    if (parent != null) {
		        System.out.println("parent: " + parent.element());
		    }
		} else {
		    System.out.println("NÃO encontrado");
		}

		System.out.println("\nAplicações:");
		if (pos3 != null) {
		    System.out.println("Encontrado");
		    System.out.println("isExternal: " + myTree.isExternal(pos3));
		    System.out.println("isRoot: " + myTree.isRoot(pos3));
		    Position<String> parent = myTree.parent(pos3);
		    if (parent != null) {
		        System.out.println("parent: " + parent.element());
		    }
		} else {
		    System.out.println("NÃO encontrado");
		}

		Position<String> pos4 = myTree.find("Conceitos");
		myTree.replace(pos4, "Conceitos básicos");

		System.out.println("\nPRINT DFS PRE ORDER:");
		print(myTree);

		System.out.println("\nPRINT elements():");
		for (String elem : myTree.elements()) {
		    System.out.println(elem);
		}

		System.out.println("\nPRINT positions():");
		for (Position<String> pos : myTree.positions()) {
		    System.out.println(pos.element());
		}

		System.out.println("\nPRINT BFS:");
		printBfs(myTree);

		Position<String> pos5 = myTree.find("Métodos");
		if (pos5 != null) {
		    myTree.remove(pos5);
		    System.out.println("\nPRINT remove:");
		    System.out.println("SIZE = " + myTree.size());
		    print(myTree);
		}
	}
	
	public static <T> void print(GenericTree<T> tree) {
	    printRecursive(tree.root(), tree, 0);
	}

	public static <T> void printRecursive(Position<T> position, GenericTree<T> tree, int depth) {
	    String spaces = "    ".repeat(depth);
	    System.out.println(spaces + position.element());
	    for (Position<T> child : tree.children(position)) {
	        printRecursive(child, tree, depth + 1);
	    }
	}

	public static <T> void printBfs(GenericTree<T> tree) {
	    if (tree.isEmpty()) {
	        return;
	    }
	    Queue<Position<T>> queue = new LinkedList<>();
	    queue.add(tree.root());
	    while (!queue.isEmpty()) {
	    	Position<T> position = queue.poll();
	        System.out.println(position.element());
	        queue.addAll(tree.children(position));
	    }
	}
}
