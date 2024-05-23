var dfs = function(node, isConnected, visit) {
    visit[node] = true;
    for (let i = 0; i < isConnected.length; i++) {
        if (isConnected[node][i] === 1 && !visit[i]) {
            dfs(i, isConnected, visit);
        }
    }
}

/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function(isConnected) {
    const n = isConnected.length;
    let numberOfComponents = 0;
    const visit = new Array(n).fill(false);

    for (let i = 0; i < n; i++) {
        if (!visit[i]) {
            numberOfComponents++;
            dfs(i, isConnected, visit);
        }
    }

    return numberOfComponents;
};

// Exemplo 1
let isConnected = [
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
]
console.log(findCircleNum(isConnected))

// Exemplo 2
isConnected = [
    [1, 0, 0],
    [0, 1, 0],
    [0, 0, 1]
]
console.log(findCircleNum(isConnected))

