/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    // Cria uma array de memoização inicializada com Infinity
    let memo = Array(amount + 1).fill(Infinity);

    // Caso base: 0 moedas são necessárias para fazer o valor 0
    memo[0] = 0;

    // Preenche a tabela dp de 1 até v
    for (let i = 1; i <= amount; i++) {
        for (let coin of coins) {
            let subproblem = i - coin;
            if (subproblem >= 0) {
                memo[i] = Math.min(memo[i], memo[subproblem] + 1);
            }
        }
    }

    // Retorna o resultado para dp[v]
    if(memo[amount] == Infinity) return -1;
    return memo[amount];
};

console.log(coinChange([1, 2, 5], 11));
console.log(coinChange([2], 3));
console.log(coinChange([1, 2, 3, 7, 11], 10000));