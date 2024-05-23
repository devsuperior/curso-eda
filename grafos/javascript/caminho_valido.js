/**
 * @param {number} n - The number of nodes in the graph
 * @param {number[][]} edges - The edges of the graph
 * @param {number} source - The source node
 * @param {number} destination - The destination node
 * @return {boolean} - Returns true if there is a valid path from source to destination, false otherwise
 */
var validPath = function(n, edges, source, destination) {
    // Armazena todas as arestas de acordo com os nós em 'graph'
    var adj_list = [];
    for (var i = 0; i < edges.length; i++) {
        var a = edges[i][0], b = edges[i][1];
        if (!adj_list[a]) adj_list[a] = [];
        if (!adj_list[b]) adj_list[b] = [];
        adj_list[a].push(b);
        adj_list[b].push(a);
    }

    // Começa do nó fonte, adiciona-o à pilha
    var visited = new Array(n).fill(false);
    visited[source] = true;
    var stack = [source];

    while (stack.length > 0) {
        var currNode = stack.pop();
        if (currNode === destination) {
            return true;
        }
        // Adiciona todos os vizinhos não visitados do nó atual à pilha
        // e marca como visitado
        for (const neighbour of adj_list[currNode]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                stack.push(neighbour);
            }
        }
    }

    return false;
};

let n = 3;
let edges = [[0,1],[1,2],[2,0]];
let source = 0;
let destination = 2;
console.log(validPath(n, edges, source, destination));

n = 6;
edges = [[0,1],[0,2],[3,5],[5,4],[4,3]];
source = 0;
destination = 5;
console.log(validPath(n, edges, source, destination));