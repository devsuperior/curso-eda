const rodcutting = function(n, p) {
    if(n == 0)
        return 0;

    let ans = -Infinity;
    for(let i = 1; i <= n; i++) {
        if(n - i >= 0)
            ans = Math.max(ans, rodcutting(n - i, p) + p[i - 1]);
    }

    return ans;
}

// Caso básico
let p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25];
let n = 10;

console.log(rodcutting(n, p));

// Caso grande
p = [3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
n = 40;

console.log(rodcutting(n, p));