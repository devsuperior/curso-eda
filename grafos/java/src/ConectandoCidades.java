import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DisjointSet {
    private int[] parent;
    public int components;

    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        components = n;
    }

    // Acha o parent da componente atual
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // Une duas componentes a partir dos parents
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            components--;
        }
    }
}

public class ConectandoCidades {

    public static int minimumCost(int n, int[][] connections) {
        List<int[]> edges = new ArrayList<>();
        Collections.addAll(edges, connections);

        // Ordenar crescentemente por peso
        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        // Criar estruturas de apoio
        DisjointSet disjointSet = new DisjointSet(n);
        int totalWeight = 0;

        // Percorrer a lista de arestas ordenada
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int weight = edge[2];

            // Se estiverem em componentes diferentes, faz a união
            if (disjointSet.find(u) != disjointSet.find(v)) {
                disjointSet.union(u, v);
                totalWeight += weight;
            }
        }

        // Verificar se todas as vértices estão conectadas
        if (disjointSet.components > 1) {
            return -1; // Não é possível formar uma árvore mínima
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        // Exemplo 1
        int n = 3;
        int[][] connections1 = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
        System.out.println(minimumCost(n, connections1)); // Output esperado: 6

        // Exemplo 2
        n = 4;
        int[][] connections2 = { { 1, 2, 3 }, { 3, 4, 4 } };
        System.out.println(minimumCost(n, connections2)); // Output esperado: -1
    }
}
