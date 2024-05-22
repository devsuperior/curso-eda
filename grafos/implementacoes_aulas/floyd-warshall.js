class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.edges = [];
    }

    addEdge(u, v, w) {
        this.edges.push([u, v, w]);
    }

    floydWarshall() {
        const dist = [];

        // Inicializa a matriz de distâncias
        for (let i = 0; i < this.numVertices; i++) {
            dist[i] = [];
            for (let j = 0; j < this.numVertices; j++) {
                if (i === j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Infinity;
                }
            }
        }

        // Define as distâncias iniciais baseadas nas arestas do grafo
        for (const [u, v, w] of this.edges) {
            dist[u][v] = w;
        }

        // k iterações, fazendo o relaxamento de todas as arestas possíveis
        for (let k = 0; k < this.numVertices; k++) {
            for (let i = 0; i < this.numVertices; i++) {
                for (let j = 0; j < this.numVertices; j++) {
                    if (dist[i][k] < Infinity && dist[k][j] < Infinity) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist;
    }
}

const graph = new Graph(3);
graph.addEdge(0, 1, 8);
graph.addEdge(1, 0, 3);
graph.addEdge(0, 2, 5);
graph.addEdge(2, 1, 2);

let s = 0;

const dist = graph.floydWarshall(s);

for(let i = 0; i < dist.length; i++) {
    console.log(dist[i].join(' '));
}