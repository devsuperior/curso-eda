/**
 * @param {number[]} cost - Um array contendo o custo de cada degrau para subir
 * @return {number} - O custo mínimo para subir os degraus
 */
var minCostClimbingStairs = function(cost) {
    const memo = Array(cost.length + 1).fill(-1); // Inicializa o array de memoização

    return minCostClimbingStairsUtil(cost.length, cost, memo);
};

/**
 * Função auxiliar para calcular o custo mínimo de subir os degraus utilizando memoização.
 * @param {number} n - O número de degraus a subir
 * @param {number[]} cost - Um array contendo o custo de cada degrau para subir
 * @param {number[]} memo - Array de memoização para armazenar resultados intermediários
 * @return {number} - O custo mínimo para subir os degraus até o degrau n
 */
var minCostClimbingStairsUtil = function(n, cost, memo) {
    if (n === 0 || n === 1) {
        return 0;
    }

    if (memo[n] !== -1) {
        return memo[n];
    }

    memo[n] = Math.min(
        minCostClimbingStairsUtil(n - 1, cost, memo) + cost[n - 1],
        minCostClimbingStairsUtil(n - 2, cost, memo) + cost[n - 2]
    );

    return memo[n];
};

// Caso de teste 1
let cost1 = [10, 15, 20];
console.log(minCostClimbingStairs(cost1));

// Caso de teste 2
let cost2 = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1];
console.log(minCostClimbingStairs(cost2));
