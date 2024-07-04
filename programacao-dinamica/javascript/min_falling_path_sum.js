/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
    const n = matrix.length;
    const INF = Infinity;

    let memo = new Array(n).fill().map(() => new Array(n).fill(0));

    // Inicializando primeira linha
    for (let j = 0; j < n; j++) {
        memo[0][j] = matrix[0][j];
    }

    for (let i = 1; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let path_a = INF, path_b = INF, path_c = INF;
            if (isValid(i - 1, j - 1, n)) {
                path_a = matrix[i][j] + memo[i - 1][j - 1];
            }
            if (isValid(i - 1, j + 1, n)) {
                path_b = matrix[i][j] + memo[i - 1][j + 1];
            }
            if (isValid(i - 1, j, n)) {
                path_c = matrix[i][j] + memo[i - 1][j];
            }

            memo[i][j] = Math.min(path_a, Math.min(path_b, path_c));
        }
    }

    let ans = INF;
    for (let j = 0; j < n; j++) {
        ans = Math.min(ans, memo[n - 1][j]);
    }

    return ans;
};

// Função para verificar se as coordenadas são válidas
function isValid(i, j, n) {
    return i >= 0 && i < n && j >= 0 && j < n;
}

console.log(minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]));
console.log(minFallingPathSum([[-19,57],[-40,-5]]));