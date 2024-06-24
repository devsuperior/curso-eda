const numberOfWays = function(n, m) {
    // Inicializa a tabela dp com zeros
    let dp = Array.from({ length: n }, () => Array(m).fill(0));

    // Preenche a primeira linha com 1s
    for (let i = 0; i < n; i++) {
        dp[i][0] = 1;
    }

    // Preenche a primeira coluna com 1s
    for (let j = 0; j < m; j++) {
        dp[0][j] = 1;
    }

    // Preenche o restante da tabela dp
    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    // O resultado final está na célula dp[n-1][m-1]
    return dp[n - 1][m - 1];
}

// Exemplo de uso
let n = 3, m = 2;
console.log(numberOfWays(n, m));  // Saída esperada: 3
