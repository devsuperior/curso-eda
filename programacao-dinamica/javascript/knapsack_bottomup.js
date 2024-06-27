const knapsack = function(weights, values, W, n) {
    // Criação da matriz dp onde dp[i][w] representa o valor máximo que pode ser obtido considerando os primeiros i itens e capacidade w
    let dp = Array.from({ length: n + 1 }, () => Array(W + 1).fill(0));

    // Preenchendo a matriz dp de forma iterativa
    for (let i = 1; i <= n; i++) {
        for (let w = 1; w <= W; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // O valor máximo obtido será dp[n][W]
    return dp[n][W];
}

// Exemplo de uso
let weights = [1, 2, 3];
let values = [6, 10, 12];
let W = 5;
let n = 3;

console.log(knapsack(weights, values, W, n)); // Saída esperada: 22
