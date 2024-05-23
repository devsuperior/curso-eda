import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatenciaRede {

    public static int dijkstra(int s, int numVertices, List<List<int[]>> adjList) {
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[numVertices];

        // Inicializar distâncias até a origem
        dist[s] = 0;

        // Loop para garantir que todos os vértices sejam processados
        for (int k = 0; k < numVertices; k++) {
            int current = -1;

            for (int i = 0; i < numVertices; i++) {
                if (visited[i]) continue;

                // Seleciona o vértice mais próximo
                if (current == -1 || dist[i] < dist[current]) {
                    current = i;
                }
            }

            if (current == -1) break; // Todos os vértices restantes são inatingíveis
            visited[current] = true;

            // Percorrer vizinhos de current
            for (int[] edge : adjList.get(current)) {
                int neighbour = edge[0];
                int w = edge[1];

                // Tentar relaxar vizinho w
                if ((long) dist[current] + w < dist[neighbour]) {
                    dist[neighbour] = dist[current] + w;
                }
            }
        }

        // Encontre a maior distância mínima calculada durante o algoritmo de Dijkstra
        int maxMinDist = Arrays.stream(dist).max().getAsInt();
        return maxMinDist == Integer.MAX_VALUE ? -1 : maxMinDist;
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            adjList.get(u).add(new int[] { v, w });
        }

        return dijkstra(k - 1, n, adjList);
    }

    public static void main(String[] args) {
        // Exemplo 1
        int[][] times1 = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times1, n, k)); // Output esperado: 2

        // Exemplo 2
        int[][] times2 = { { 1, 2, 1 } };
        n = 2;
        k = 1;
        System.out.println(networkDelayTime(times2, n, k)); // Output esperado: 1

        // Exemplo 3
        int[][] times3 = { { 1, 2, 1 } };
        n = 2;
        k = 2;
        System.out.println(networkDelayTime(times3, n, k)); // Output esperado: -1
    }
}
