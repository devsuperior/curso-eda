import java.util.Arrays;

import bst.BinarySearchTreeSet;

public class SetTest {
	public static void main(String[] args) {

        BinarySearchTreeSet<Integer> A = new BinarySearchTreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        BinarySearchTreeSet<Integer> B = new BinarySearchTreeSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("Conjunto A: " + A);
        System.out.println("Conjunto B: " + B);

        A.add(9);
        System.out.println("Conjunto A após adicionar 9: " + A);

        A.remove(9);
        System.out.println("Conjunto A após remover 9: " + A);

        System.out.println("5 pertence ao conjunto A? " + A.contains(5));

        System.out.println("Conjunto A está vazio? " + A.isEmpty());

        System.out.println("Tamanho do conjunto A: " + A.size());

        BinarySearchTreeSet<Integer> C = A.union(B);
        System.out.println("União dos conjuntos A e B (Conjunto C): " + C);

        C = A.intersection(B);
        System.out.println("Interseção dos conjuntos A e B (Conjunto C): " + C);

        C = A.difference(B);
        System.out.println("Diferença entre os conjuntos A e B (Conjunto C): " + C);
    }
}
