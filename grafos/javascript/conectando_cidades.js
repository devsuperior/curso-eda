class DisjointSet {
    constructor(n) {
        this.parent = [];
        for (let i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        this.components = n;
    }

    // acha parent da componente atual
    find(x) {
        while (this.parent[x] !== x) {
            x = this.parent[x];
        }
        return x;
    }

    // une duas componentes a partir dos parents
    union(x, y) {
        const rootX = this.find(x);
        const rootY = this.find(y);
        if (rootX !== rootY) {
            this.parent[rootY] = rootX;
        }
        this.components--;
    }
}

/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var minimumCost = function(n, connections) {
    function kruskal(numVertices, edges) {
        // ordenar crescentemente por peso
        edges.sort((a, b) => a[2] - b[2]);

        // criar estruturas de apoio
        const disjointSet = new DisjointSet(numVertices);
        let totalWeight = 0;

        // percorrer a lista de arestas ordenada
        for (const [u, v, weight] of edges) {
            // se estiverem em componentes diferentes, faz a união
            if (disjointSet.find(u) !== disjointSet.find(v)) {
                disjointSet.union(u, v);
                totalWeight += weight;
            }
        }

        // Verificar se todas as vértices estão conectadas
        if(disjointSet.components > 1){
            return -1; // Não é possível formar uma árvore mínima
        }

        return totalWeight;
    }

    return kruskal(n, connections);
};

let n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]];
console.log(minimumCost(n, connections));

n = 4, connections = [[1,2,3],[3,4,4]];
console.log(minimumCost(n, connections)); // Output esperado: -1
