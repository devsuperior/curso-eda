const rodcuttingUtil = function(n, p, memo) {
    if(n == 0)
        return 0;

    if(memo[n] != -1)
        return memo[n];

    for(let i = 1; i <= n; i++) {
        if(n - i >= 0)
            memo[n] = Math.max(memo[n], rodcuttingUtil(n - i, p, memo) + p[i - 1]);
    }

    return memo[n];
}

const rodcutting = function(n, p) {
    let memo = Array(n + 1).fill(-1);

    return rodcuttingUtil(n, p, memo);
}


// Caso básico
let p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25];
let n = 10;

console.log(rodcutting(n, p));

// Caso grande
p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
n = 40;

console.log(rodcutting(n, p));