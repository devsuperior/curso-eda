const rodcutting = function(n, p) {
    let memo = Array(n + 1).fill(-1);

    // Caso base
    memo[0] = 0;

    // Tabulação
    for(let i = 1; i <= n; i++) {
        for(let j = 1; j <= i; j++){
            memo[i] = Math.max(memo[i], memo[i - j] + p[j - 1]);
        }
    }

    return memo[n];
}


// Caso básico
let p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25];
let n = 10;

console.log(rodcutting(n, p));

// Caso grande
p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
n = 40;

console.log(rodcutting(n, p));