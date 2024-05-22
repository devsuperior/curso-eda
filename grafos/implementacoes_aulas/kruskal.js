class DisjointSet {
    constructor(n) {
        this.parent = [];
        for (let i = 0; i < n; i++) {
            this.parent[i] = i;
        }
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
    }
}

class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.edges = [];
    }

    addEdge(v1, v2, w) {
        this.edges.push([v1, v2, w]);
    }

    kruskal() {
        // ordenar crescentemente por peso
        this.edges.sort((a, b) => a[2] - b[2]);

        // criar estruturas de apoio
        const disjointSet = new DisjointSet(this.numVertices);
        const mst = [];
        let totalWeight = 0;

        // percorrer a lista de arestas ordenada
        for (const [u, v, weight] of this.edges) {
            // se estiverem em componentes diferentes, faz a união
            if (disjointSet.find(u) !== disjointSet.find(v)) {
                disjointSet.union(u, v);
                mst.push([u, v, weight]);
                totalWeight += weight;
            }
        }

        return { mst, totalWeight };
    }
}

const graph = new Graph(7);
graph.addEdge(0, 1, 4);
graph.addEdge(0, 2, 8);
graph.addEdge(1, 2, 11);
graph.addEdge(1, 3, 2);
graph.addEdge(1, 4, 8);
graph.addEdge(2, 5, 1);
graph.addEdge(2, 3, 6);
graph.addEdge(3, 6, 10);
graph.addEdge(3, 5, 5);
graph.addEdge(4, 6, 7);
graph.addEdge(5, 6, 6);

const result = graph.kruskal();
console.log('Árvore Geradora Mínima:', result.mst);
console.log('Peso total:', result.totalWeight);
