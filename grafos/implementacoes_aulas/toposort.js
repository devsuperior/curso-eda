class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjList = [];

        for(let i = 0; i < numVertices; i++){
            this.adjList[i] = [];
        }
    }

    addEdge(v1, v2) {
        this.adjList[v1].push(v2);
    }

    neighbours(v) {
        return this.adjList[v];
    }

    _dfsUtil(v, visited, ordered_list) {
        visited[v] = true;

        console.log("Visited " + v);

        // ver vizinhos não visitados
        for(const w of this.neighbours(v)){
            if(!visited[w]) {
                visited[w] = true;
                this._dfsUtil(w, visited, ordered_list);
            }
        }

        // aqui eh o encerramento do vértice
        ordered_list.unshift(v);
    }

    toposort(){
        let visited = Array(this.numVertices).fill(false);
        let ordered_list = [];

        for(let i = 0; i < this.numVertices; i++){
            if(!visited[i]){
                this._dfsUtil(i, visited, ordered_list);
            }
        }
        
        return ordered_list;
    }
}

const graph = new Graph(10);
graph.addEdge(0, 1);
graph.addEdge(0, 2);
graph.addEdge(0, 3);
graph.addEdge(0, 5);
graph.addEdge(1, 2);
graph.addEdge(2, 3);
graph.addEdge(2, 4);
graph.addEdge(4, 6);
graph.addEdge(5, 6);
graph.addEdge(5, 4);
graph.addEdge(9, 6);
graph.addEdge(6, 8);
graph.addEdge(6, 7);
graph.addEdge(7, 8);
console.log(graph.toposort())