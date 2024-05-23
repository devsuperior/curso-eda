function dijkstra(s, numVertices, adjList) {
    const dist = new Array(numVertices).fill(Infinity);
    const visited = new Array(numVertices).fill(false);

    // inicializar distâncias até a origem
    dist[s] = 0;

    // loop para garantir que todos os vértices sejam processados
    for (let k = 0; k < numVertices; k++) {
        let current = -1;

        for (let i = 0; i < numVertices; i++) {
            if (visited[i]) continue;

            // seleciona o vértice mais próximo
            if (current === -1 || dist[i] < dist[current]) {
                current = i;
            }
        }

        if (current === -1) break;  // todos os vértices restantes são inatingíveis
        visited[current] = true;

        // percorrer vizinhos de current
        for (const [neighbour, w] of adjList[current]) {
            // tentar relaxar vizinho w
            if (dist[current] + w < dist[neighbour]) {
                dist[neighbour] = dist[current] + w;
            }
        }
    }

    // Encontre a maior distância mínima calculada durante o algoritmo de Dijkstra
    let maxMinDist = -1;
    for (let i = 0; i < dist.length; i++) {
        maxMinDist = Math.max(maxMinDist, dist[i]);
    }

    if(maxMinDist === Infinity) return -1;
    else return maxMinDist;
}

/**
 * @param {number[][]} times
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var networkDelayTime = function(times, n, k) {
    const adjList = Array.from({ length: n }, () => []);

    for (const [u, v, w] of times) {
        adjList[u - 1].push([v - 1, w]);
    }

    return dijkstra(k - 1, n, adjList);
};

// Exemplo 1
let times = [[2, 1, 1], [2, 3, 1], [3, 4, 1]];
let n = 4;
let k = 2;
console.log(networkDelayTime(times, n, k)); 

// Exemplo 2
times = [[1, 2, 1]];
n = 2;
k = 1;
console.log(networkDelayTime(times, n, k)); 

// Exemplo 3
times = [[1, 2, 1]];
n = 2;
k = 2;
console.log(networkDelayTime(times, n, k)); 