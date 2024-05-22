// grafo não-direcionado e não-ponderado utilizando matriz de adjacências
class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = [];
        // inicializando matriz NxN cheia de 0's
        for(let i = 0; i < this.numVertices; i++) {
            this.adjMatrix[i] = [];
            for(let j = 0; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
    }

    addEdge(v1, v2) {
        // para grafo não-direcionado (v1, v2) implica (v2, v1)
        this.adjMatrix[v1][v2] = 1;
        this.adjMatrix[v2][v1] = 1;
    }

    removeEdge(v1, v2) {
        // para grafo não-direcionado (v1, v2) implica (v2, v1)
        this.adjMatrix[v1][v2] = 0;
        this.adjMatrix[v2][v1] = 0;
    }

    // imprimir grafo no console
    printGraph() {
        for(let i = 0; i < this.numVertices; i++) {
            console.log(this.adjMatrix[i].join(' '));
        }
    }

    // retornar grau do vértice v
    degree(v) {
        let cont = 0;
        
        // contar quantos 1's tem na linha do vértice v
        for(let i = 0; i < this.numVertices; i++){
            if(this.adjMatrix[v][i] == 1) {
                cont++;
            }
        }

        return cont;
    }

    listByDegree() {
        let degrees = [];

        // percorrer todos os vértices
        for(let i = 0; i < this.numVertices; i++) {
            let degree = this.degree(i);

            if(!degrees[degree]){
                degrees[degree] = [];
            }

            degrees[degree].push(i);
        }

        for(let i = 0; i <= this.numVertices; i++) {
            // se existem vértices desse grau
            if(degrees[i]){
                console.log(`grau=${i}:{${degrees[i].join(", ")}}`);
            }
            // nao existe vertices
            else{
                console.log("grau=" + i + ":{}");
            }
        }
    }
}

const graph = new Graph(4);
graph.addEdge(0, 1);
graph.addEdge(0, 2);
graph.addEdge(1, 3);
graph.addEdge(2, 3);
graph.addEdge(3, 3);
// graph.removeEdge(0, 1);
graph.printGraph();
console.log("Degree: " + graph.degree(3));
console.log("Degree: " + graph.degree(0));
graph.listByDegree();