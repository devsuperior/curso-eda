import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
        // Inicializando os conjuntos A e B
        Set<Integer> A = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Set<Integer> B = new HashSet<>(Set.of(4, 5, 6, 7, 8));

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
        Set<Integer> C = new HashSet<>(A);
        C.addAll(B);
        System.out.println("União dos conjuntos A e B (Conjunto C): " + C);

        // Interseção dos conjuntos A e B, salvando o resultado em um conjunto C
        C = new HashSet<>(A);
        C.retainAll(B);
        System.out.println("Interseção dos conjuntos A e B (Conjunto C): " + C);

        // Diferença entre os conjuntos A e B, salvando o resultado em um conjunto C
        C = new HashSet<>(A);
        C.removeAll(B);
        System.out.println("Diferença entre os conjuntos A e B (Conjunto C): " + C);
    }
}
