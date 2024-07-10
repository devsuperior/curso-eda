const findLCS = function(s1, s2) {
    let n = s1.length;
    let m = s2.length;

    // Inicializa a matriz DP
    let memo = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));

    // Preenche a matriz DP de forma iterativa
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (s1[i - 1] === s2[j - 1]) {
                memo[i][j] = 1 + memo[i - 1][j - 1];
            } else {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
    }

    return memo[n][m];
}

// Caso de Teste 1 - Entradas simples
let s1 = "abcde";
let s2 = "ace";
console.log(findLCS(s1, s2)); // Saída esperada: 3

// Caso de Teste 2 - Entradas diferentes
s1 = "abc";
s2 = "def";
console.log(findLCS(s1, s2)); // Saída esperada: 0

// Caso de Teste 3 - Entrada idênticas
s1 = "abcdef";
s2 = "abcdef";
console.log(findLCS(s1, s2)); // Saída esperada: 6

// Caso de Teste 4 - Caso Grande
s1 = "aaaaaaaaaaaaaaaaaaabcdef";
s2 = "abcdefaaaaaaaaaaaaaaaaaaa";
console.log(findLCS(s1, s2)); // Saída esperada: 19