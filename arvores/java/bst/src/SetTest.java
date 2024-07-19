import java.util.Arrays;

import bst.BinarySearchTreeSet;

public class SetTest {
	public static void main(String[] args) {
        // Inicializando os conjuntos A e B
        BinarySearchTreeSet<Integer> A = new BinarySearchTreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        BinarySearchTreeSet<Integer> B = new BinarySearchTreeSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Mostrando os conteúdos dos conjuntos A e B
        System.out.println("Conjunto A: " + A);
        System.out.println("Conjunto B: " + B);

        // Adicionando um novo número ao conjunto A
        A.add(9);
        System.out.println("Conjunto A após adicionar 9: " + A);

        // Removendo o número adicionado do conjunto A
        A.remove(9);
        System.out.println("Conjunto A após remover 9: " + A);

        // Testando se um elemento pertence ao conjunto A
        System.out.println("5 pertence ao conjunto A? " + A.contains(5));

        // Testando se o conjunto A está vazio
        System.out.println("Conjunto A está vazio? " + A.isEmpty());

        // Testando o tamanho do conjunto A
        System.out.println("Tamanho do conjunto A: " + A.size());

        // União dos conjuntos A e B, salvando o resultado em um conjunto C
        BinarySearchTreeSet<Integer> C = A.union(B);
        System.out.println("União dos conjuntos A e B (Conjunto C): " + C);

        // Interseção dos conjuntos A e B, salvando o resultado em um conjunto C
        C = A.intersection(B);
        System.out.println("Interseção dos conjuntos A e B (Conjunto C): " + C);

        // Diferença entre os conjuntos A e B, salvando o resultado em um conjunto C
        C = A.difference(B);
        System.out.println("Diferença entre os conjuntos A e B (Conjunto C): " + C);
    }
}
