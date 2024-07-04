/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    const memo = Array(n + 1).fill(-1); // Inicializa o array de memoização
    return climbStairsUtil(n, memo); // Chama a função auxiliar
};

var climbStairsUtil = function(n, memo) {
    if (memo[n] !== -1) { // Se o valor já foi calculado, retorna o memo
        return memo[n];
    }

    if (n === 0 || n === 1) { // Casos base
        return 1;
    }

    memo[n] = climbStairsUtil(n - 1, memo) + climbStairsUtil(n - 2, memo); // Calcula o valor e armazena no memo
    return memo[n];
}

// Caso de teste 1
var n1 = 2;
console.log(climbStairs(n1));

// Caso de teste 2
var n2 = 3;
console.log(climbStairs(n2));

// Caso de teste 3
var n3 = 45;
console.log(climbStairs(n3));
