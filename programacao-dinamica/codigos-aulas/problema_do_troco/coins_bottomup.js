const min_coins = function(v, c) {
    // Cria uma array de memoização inicializada com Infinity
    let memo = Array(v + 1).fill(Infinity);

    // Caso base: 0 moedas são necessárias para fazer o valor 0
    memo[0] = 0;

    // Preenche a tabela dp de 1 até v
    for (let i = 1; i <= v; i++) {
        for (let coin of c) {
            let subproblem = i - coin;
            if (subproblem >= 0) {
                memo[i] = Math.min(memo[i], memo[subproblem] + 1);
            }
        }
    }

    // Retorna o resultado para dp[v]
    return memo[v];
}

console.log(min_coins(2000000, [10, 7, 1]));