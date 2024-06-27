class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.edges = [];
    }

    addEdge(u, v, w) {
        this.edges.push([u, v, w]);
    }

    bellmanFord(s) {
        const dist = new Array(this.numVertices).fill(Infinity);
        dist[s] = 0;

        for (let i = 0; i < this.numVertices - 1; i++) {
            for (const [u, v, w] of this.edges) {
                if (dist[u] !== Infinity && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Verificação de ciclos negativos
        for (const [u, v, w] of this.edges) {
            if (dist[u] !== Infinity && dist[u] + w < dist[v]) {
                console.log("Graph contains negative weight cycle");
                return [];
            }
        }

        return dist;
    }
}

const graph = new Graph(6);
graph.addEdge(0, 1, 8);
graph.addEdge(0, 2, 3);
graph.addEdge(1, 4, 6);
graph.addEdge(2, 5, -1);
graph.addEdge(3, 1, -4);
graph.addEdge(3, 4, -1);
graph.addEdge(4, 5, 4);
graph.addEdge(5, 3, -3);

let s = 0;

const dist = graph.bellmanFord(s);

for (let i = 0; i < dist.length; i++) {
    console.log(`dist[${s}, ${i}] = ${dist[i]}`);
}