// grafo direcionado e ponderado utilizando matriz de adjacências
class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = [];
        // inicializando matriz NxN cheia de -1's
        for(let i = 0; i < this.numVertices; i++) {
            this.adjMatrix[i] = [];
            for(let j = 0; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = -1;
            }
        }
    }

    addEdge(v1, v2, w) {
        // para grafo direcionado e ponderado apenas (v1, v2) = w
        this.adjMatrix[v1][v2] = w;
    }

    removeEdge(v1, v2) {
        // para grafo direcionado e ponderado apenas (v1, v2) = -1
        this.adjMatrix[v1][v2] = -1;
    }

    // imprimir grafo no console
    printGraph() {
        for(let i = 0; i < this.numVertices; i++) {
            console.log(this.adjMatrix[i].join(' '));
        }
    }

    // achar aresta de menor peso
    lowest_weight() {
        let minEdge = [-1, -1];
        let minValue = Infinity;

        // percorrendo todas as arestas possiveis
        for(let i = 0; i < this.numVertices; i++) {
            for(let j = 0; j < this.numVertices; j++) {
                // selecionar aresta se ela existir e comparar
                if(this.adjMatrix[i][j] !== -1 && this.adjMatrix[i][j] < minValue) {
                    minEdge = [i, j];
                    minValue = this.adjMatrix[i][j];
                }
            }
        }

        // não existem arestas
        if(minValue == Infinity){
            return null;
        }

        return minEdge;
    }
}

const graph = new Graph(4);
graph.addEdge(0, 1, 1);
graph.addEdge(0, 2, 4);
graph.addEdge(1, 3, 5);
graph.addEdge(2, 3, 3);
graph.addEdge(3, 3, 7);
graph.addEdge(3, 1, 1);
graph.removeEdge(0, 1);
graph.printGraph();
console.log(graph.lowest_weight());