import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CaminhoValido {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // Armazena todas as arestas de acordo com os nós em 'graph'
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        // Começa do nó fonte, adiciona-o à pilha
        boolean[] visited = new boolean[n];
        visited[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination) {
                return true;
            }
            // Adiciona todos os vizinhos não visitados do nó atual à pilha
            // e marca como visitado
            for (int neighbour : adjList.get(currNode)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Exemplo 1
        int n = 3;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges1, source, destination)); // true

        // Exemplo 2
        n = 6;
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
        source = 0;
        destination = 5;
        System.out.println(validPath(n, edges2, source, destination)); // false
    }
}
