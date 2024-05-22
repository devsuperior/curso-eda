// grafo direcionado e ponderado utilizando lista de adjacências
class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjList = new Array(numVertices).fill(null).map(() => []);
    }

    addEdge(v1, v2, weight) {
        this.adjList[v1].push([v2, weight]);
    }

    removeEdge(v1, v2) {
        this.adjList[v1] = this.adjList[v1].filter(edge => edge[0] !== v2);
    }

    printGraph() {
        for (let i = 0; i < this.numVertices; i++) {
            let edges = this.adjList[i].map(edge => `${edge[0]} (peso: ${edge[1]})`).join(", ");
            console.log(`${i} -> ${edges}`);
        }
    }

    lowestWeight() {
        let minEdge = [-1, -1];
        let minValue = Infinity;

        // Percorrendo todas as listas de adjacência
        for (let i = 0; i < this.numVertices; i++) {
            for (let edge of this.adjList[i]) {
                // Comparar o peso da aresta
                if (edge[1] < minValue) {
                    minEdge = [i, edge[0]];
                    minValue = edge[1];
                }
            }
        }

        // Não existem arestas
        if (minValue === Infinity) {
            return null;
        }

        return minEdge;
    }

    neighbours(v) {
        return this.adjList[v].map(edge => edge[0]);
    }

    degree(v) {
        return this.adjList[v].length;
    }

    listByDegree() {
        let vertices = [];
        for (let i = 0; i < this.numVertices; i++) {
            vertices.push({vertex: i, degree: this.degree(i)});
        }
        vertices.sort((a, b) => b.degree - a.degree);
        return vertices.map(v => v.vertex);
    }
}

// Exemplo de uso:

let g = new Graph(5);
g.addEdge(0, 1, 2);
g.addEdge(0, 2, 4);
g.addEdge(1, 2, 1);
g.addEdge(1, 3, 7);
g.addEdge(2, 4, 3);

console.log("Grafo:");
g.printGraph();

console.log("Vizinhos do vértice 1:");
console.log(g.neighbours(1));

console.log("Aresta com menor peso:");
console.log(g.lowestWeight());

console.log("Grau do vértice 1:");
console.log(g.degree(1));