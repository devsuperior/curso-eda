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
        this.adjList[v2].push(v1);
    }

    neighbours(v) {
        return this.adjList[v];
    }

    dfs(v){
        let visited = Array(this.numVertices).fill(false);
        // chamar função para percorrer de fato vértices
        this._dfsUtil(v, visited);
    }

    _dfsUtil(v, visited) {
        visited[v] = true;

        console.log("Visited " + v);

        // ver vizinhos não visitados
        for(const w of this.neighbours(v)){
            if(!visited[w]) {
                visited[w] = true;
                this._dfsUtil(w, visited);
            }
        }
    }

    dfs_iter(v) {
        let visited = Array(this.numVertices).fill(false);
        let stack = [];

        stack.push(v);
        visited[v] = true;

        // enquanto ainda houver vértices para processar
        while (stack.length != 0) {
            v = stack.pop();

            console.log("Visited = " + v);
            // ver se existem vizinhos não visitados
            for(const w of this.neighbours(v)){
                if(!visited[w]){
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }
}

const graph = new Graph(5);
graph.addEdge(0, 1);
graph.addEdge(0, 2);
graph.addEdge(0, 3);
graph.addEdge(2, 3);
graph.addEdge(2, 4);
graph.addEdge(3, 4);
console.log("DFS recursiva");
graph.dfs(0);
console.log("DFS iterativa");
graph.dfs_iter(0);