/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    const n = grid.length;
    const m = grid[0].length;

    // Criando matriz de memoização e inicializando com 0
    let memo = new Array(n);
    for (let i = 0; i < n; i++) {
        memo[i] = new Array(m).fill(0);
    }

    memo[0][0] = grid[0][0];

    // Inicializando primeira coluna
    for (let i = 1; i < n; i++) {
        memo[i][0] = memo[i - 1][0] + grid[i][0];
    }

    // Inicializando primeira linha
    for (let j = 1; j < m; j++) {
        memo[0][j] = memo[0][j - 1] + grid[0][j];
    }

    // Aplicando tabulação
    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
        }
    }

    return memo[n - 1][m - 1];
};

// Casos de teste
console.log(minPathSum([[1,3,1],[1,5,1],[4,2,1]]));
console.log(minPathSum([[1,2,3],[4,5,6]]));