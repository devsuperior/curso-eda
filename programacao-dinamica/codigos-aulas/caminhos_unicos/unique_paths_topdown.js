const countPaths = function(i, j, memo) {
    // Se já computamos o valor para i, j, retornamos o valor memoizado
    if (memo[i][j] !== -1) {
        return memo[i][j];
    }

    // Caso base: se estamos na primeira linha ou primeira coluna
    if (i == 0 || j == 0) {
        return 1;
    }

    // Movimentos possíveis: para cima e para a esquerda
    let moveUp = countPaths(i - 1, j, memo);
    let moveLeft = countPaths(i, j - 1, memo);

    // Armazena o resultado no memo e retorna
    memo[i][j] = moveUp + moveLeft;
    return memo[i][j];
}

const numberOfWays = function(n, m) {
    // Inicializa a matriz de memoização com -1
    let memo = Array.from({ length: n }, () => Array(m).fill(-1));
    return countPaths(n - 1, m - 1, memo);
}

// Exemplo de uso
let n = 25, m = 25;
console.log(numberOfWays(n, m));  // Saída esperada: 3
