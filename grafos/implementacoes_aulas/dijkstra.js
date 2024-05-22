class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjList = [];
        // Inicializar lista de adjacências de cada vértice
        for (let i = 0; i < this.numVertices; i++) {
            this.adjList[i] = [];
        }
    }

    addEdge(v1, v2, w) {
        this.adjList[v1].push([v2, w]);
        this.adjList[v2].push([v1, w]);
    }

    dijkstra(s) {
        const dist = new Array(this.numVertices).fill(Infinity);
        const visited = new Array(this.numVertices).fill(false);
        const previous = new Array(this.numVertices).fill(-1);

        // inicializar distâncias até 
        dist[s] = 0;
        previous[s] = s;

        // loop para garantir que todos os vértices sejam processados
        for (let k = 0; k < this.numVertices; k++) {
            let current = -1;

            for (let i = 0; i < this.numVertices; i++) {
                if (visited[i])
                    continue;
                
                // seleciona o vértice mais próximo
                if (current === -1 || dist[i] < dist[current]) {
                    current = i;
                }
            }

            visited[current] = true;
            
            // percorrer vizinhos de current
            for (const [neighbour, w] of this.adjList[current]) {
                // tentar relaxar vizinho w
                if (dist[current] + w < dist[neighbour]) {
                    dist[neighbour] = dist[current] + w;
                    previous[neighbour] = current;
                }
            }
        }

        return [dist, previous];
    }

    recoverPath(s, previous){
        let current = s;
        let path = [];
        path.push(current);

        // percorrer até chegar em alguém que é o próprio pai
        while(previous[current] != current){
            path.push(previous[current]);
            current = previous[current];
        }

        return path.reverse();
    }
}

const graph = new Graph(6);
graph.addEdge(0, 1, 9);
graph.addEdge(0, 2, 3);
graph.addEdge(1, 2, 1);
graph.addEdge(1, 3, 6);
graph.addEdge(2, 4, 2);
graph.addEdge(1, 4, 3);
graph.addEdge(3, 4, 5);
graph.addEdge(4, 5, 8);
graph.addEdge(3, 5, 2);

let s = 0;

const [dist, previous] = graph.dijkstra(s);

for (let i = 0; i < dist.length; i++) {
    console.log(`dist[${s}, ${i}] = ${dist[i]}`);
}

console.log(graph.recoverPath(5, previous));